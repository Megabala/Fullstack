package homecare.mega.service;

import homecare.mega.dto.request.RegisterRequest;
import homecare.mega.dto.response.RegisterResponse;
import homecare.mega.dto.response.UserDetailResponse;
import homecare.mega.dto.response.UserDetailsREsponse;
import homecare.mega.enumerated.Role;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

    UserDetailResponse getUser(String email);

    UserDetailsREsponse getAllUser();
    
    RegisterResponse updateUser(String id, String name, String email, Role role, String password);

    RegisterResponse deleteUser(String id);
}