package homecare.mega.service;
import homecare.mega.dto.request.PaymentRequest;
import homecare.mega.dto.response.PaymentResponse;
import homecare.mega.dto.response.RegisterResponse;

public interface PayService {

    RegisterResponse addPayment(PaymentRequest request);

    PaymentResponse getAllPayment();

 

}
