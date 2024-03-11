package homecare.mega.service;


import homecare.mega.dto.request.ForgotPasswordRequest;
import homecare.mega.dto.request.LoginRequest;
import homecare.mega.dto.request.RegisterRequest;
import homecare.mega.dto.response.ForgotPasswordResponse;
import homecare.mega.dto.response.LoginResponse;
import homecare.mega.dto.response.RegisterResponse;


public interface AuthenticationService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request);
    
}