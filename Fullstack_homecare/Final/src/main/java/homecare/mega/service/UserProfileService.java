package homecare.mega.service;


import homecare.mega.dto.request.UserProfileRequest;
import homecare.mega.dto.response.UserProfileResponse;


public interface UserProfileService {

    UserProfileResponse addUserProfile(UserProfileRequest request);

    UserProfileResponse getUserProfile(String email);

    
}