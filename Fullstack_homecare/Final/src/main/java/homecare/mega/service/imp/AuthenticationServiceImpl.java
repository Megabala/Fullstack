package homecare.mega.service.imp;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import homecare.mega.dto.request.ForgotPasswordRequest;
import homecare.mega.dto.request.LoginRequest;
import homecare.mega.dto.request.RegisterRequest;
import homecare.mega.dto.response.ForgotPasswordResponse;
import homecare.mega.dto.response.LoginResponse;
import homecare.mega.dto.response.RegisterResponse;
import homecare.mega.model.Token;
import homecare.mega.model.User;
import homecare.mega.repository.TokenRepository;
import homecare.mega.repository.UserRepository;
import homecare.mega.service.AuthenticationService;
import homecare.mega.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Optional<User> isUser = userRepository.findByEmail(request.getEmail());


        if(isUser.isPresent()) {
            return RegisterResponse.builder()
                                    .message("User already exists with email " + request.getEmail())
                                    .build();
        }
        var user = User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(request.getRole())
                        .build();

        userRepository.save(user);
        System.out.println("After saving user to the database");
                        

        return RegisterResponse.builder()
                                .message("User registered successfully")
                                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        
        authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(()-> new UsernameNotFoundException("User not found with email"+request.getEmail()));

        Map<String,Object> claims = new HashMap<>();
        claims.put("role",user.getRole().toString());
        var accessToken = jwtUtil.generateToken(claims,user);

        revokeAllUserTokens(user);
        saveUserToken(accessToken,user);
        return LoginResponse
        .builder()
        .message("User Logged in successfully ")
        .accessToken(accessToken)
        .build();
    }

    private void saveUserToken(String accessToken, User user) {
        var token = Token.builder()
                        .token(accessToken)
                        .user(user)
                        .expired(false)
                        .revoked(false)
                        .build();

                        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens  = tokenRepository.findAllByUser_IdAndExpiredIsFalseAndRevokedIsFalse(user.getId());
        if(validUserTokens.isEmpty())
        {
            return;
        }
        validUserTokens.forEach(token->{
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(()-> new UsernameNotFoundException("User not found with email "+request.getEmail())); 

        if(!passwordEncoder.matches(request.getCurrentPassword(),user.getPassword()))
        {
            return ForgotPasswordResponse.builder().message("Password incorrect").build();
        }
        if(!request.getNewPassword().equals(request.getConnfirmPassword()))
        {
            return ForgotPasswordResponse.builder().message("Password mismatch").build();
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        return ForgotPasswordResponse.builder().message("Password updated successfully").build();
    }
    
}