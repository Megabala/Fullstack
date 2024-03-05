// package homecare.mega.controller;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import homecare.mega.dto.request.PaymentRequest;
// import homecare.mega.dto.response.PaymentResponse;
// import homecare.mega.dto.response.RegisterResponse;
// import homecare.mega.service.PayService;
// import homecare.mega.utils.MyConstant;
// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping(MyConstant.PAYMENT)
// @PreAuthorize("hasRole('USER')")
// @RequiredArgsConstructor
// public class PaymentController {

//     private final PayService paymentService;


//      @PostMapping(MyConstant.PAYMENT_ADD)
//     public ResponseEntity<?> addPayment(@RequestBody PaymentRequest request) {
//         RegisterResponse response = new RegisterResponse();

//         try {
//             response = paymentService.addPayment(request);
//             return new ResponseEntity<>(response, HttpStatus.CREATED);
//         }
//         catch(Exception e) {
//             return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
//         }
//     }

//     @GetMapping(MyConstant.PAYMENT_ALL_GET)
//     public ResponseEntity<?> getAllPayment()
//     {
//         PaymentResponse paymentResponse = new PaymentResponse();
//         try{
//                 paymentResponse =  paymentService.getAllPayment();
//                 return new ResponseEntity<>(paymentResponse,HttpStatus.CREATED);
//         }
//         catch(Exception e)
//         {
//             return new ResponseEntity<>(paymentResponse,HttpStatus.EXPECTATION_FAILED);
//         }
//     }

   
// }