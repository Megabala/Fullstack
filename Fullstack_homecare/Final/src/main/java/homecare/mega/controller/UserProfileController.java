// package homecare.mega.controller;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import homecare.mega.dto.request.UserProfileRequest;
// import homecare.mega.dto.response.UserProfileResponse;
// import homecare.mega.service.UserProfileService;

// import homecare.mega.utils.MyConstant;

// import lombok.RequiredArgsConstructor;


// @RestController
// @RequestMapping(MyConstant.USERPROFILE)
// @PreAuthorize("hasRole('USER')")
// @RequiredArgsConstructor
// public class UserProfileController {

//     private final UserProfileService userprofileService;

//       @PostMapping(MyConstant.USERPROFILE_ADD)
//     public ResponseEntity<?> addUserProfile(@RequestBody UserProfileRequest request) {
//         UserProfileResponse response = new UserProfileResponse();

//         try {
//             response = userprofileService.addUserProfile(request);
//             return new ResponseEntity<>(response, HttpStatus.CREATED);
//         }
//         catch(Exception e) {
//             return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
//         }
//     }

//     @GetMapping(MyConstant.USERPROFILE_GET)
//     public ResponseEntity<?> getUserProfile(@RequestParam String email)
//     {
//         UserProfileResponse response = new UserProfileResponse();
//         try
//         {
//             response = userprofileService.getUserProfile(email);
//             return new ResponseEntity<>(response,HttpStatus.OK);
//         }
//         catch(Exception e)
//         {
//             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//         }
//     }   
    

// }