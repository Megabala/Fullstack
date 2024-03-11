// package homecare.mega.service.imp;

// import java.util.Optional;
// import org.springframework.stereotype.Service;

// import homecare.mega.dto.request.UserProfileRequest;

// import homecare.mega.dto.response.UserProfileResponse;

// import homecare.mega.model.UserProfile;
// import homecare.mega.repository.UserProfileRepository;

// import homecare.mega.service.UserProfileService;


// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// @SuppressWarnings("null")
// public class UserProfileServiceImpl implements UserProfileService {

//     private final UserProfileRepository userprofileRepository;

//     @Override
//     public UserProfileResponse addUserProfile(UserProfileRequest request) {

//         var userprofile= UserProfile.builder()
//                         .firstname(request.getFirstname())
//                         .lastname(request.getLastname())
//                         .middlename(request.getMiddlename())
//                         .gender(request.getGender())
//                         .address(request.getAddress())
//                         .mobilenumber(request.getMobilenumber())
//                         .dateofbirth(request.getDateofbirth())
//                         .email(request.getEmail())
//                         .build();
//                          userprofileRepository.save(userprofile);
                        

//                 return UserProfileResponse.builder().message("User registered successfully").build();
//     }

//     @Override
//     public UserProfileResponse getUserProfile(String email) {
//         Optional<UserProfile> isUserProfile = userprofileRepository.findByEmail(email);
//         if (!isUserProfile.isPresent()) {
//             return UserProfileResponse.builder()
//                         .message("User with email does not exist")
//                         .build();
//         }
//         UserProfile userprofile = isUserProfile.get();
//         return UserProfileResponse.builder()
//         .firstname(userprofile.getFirstname())
//         .lastname(userprofile.getLastname())
//         .middlename(userprofile.getMiddlename())
//         .gender(userprofile.getGender())
//         .address(userprofile.getAddress())
//         .mobilenumber(userprofile.getMobilenumber())
//         .dateofbirth(userprofile.getDateofbirth())
//         .email(userprofile.getEmail())
//         .build();
//     }

   
// }