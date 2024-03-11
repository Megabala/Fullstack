
package homecare.mega.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import homecare.mega.dto.request.PaymentRequest;

import homecare.mega.dto.response.PaymentResponse;
import homecare.mega.dto.response.RegisterResponse;

import homecare.mega.model.Payment;

import homecare.mega.repository.PaymentRepository;
import homecare.mega.service.PayService;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class PaymentServiceImpl implements PayService {

    private final PaymentRepository paymentRepository;

    @Override
    public RegisterResponse addPayment(PaymentRequest request) {

        var payment = Payment.builder()
                        .payment_status(request.getPayment_status())
                        .amount(request.getAmount())
                        .build();

        paymentRepository.save(payment);
                        

        return RegisterResponse.builder()
                                .message("Service added successfully")
                                .build();
    }

    @Override
    public PaymentResponse getAllPayment() {
        List<Payment> payment = paymentRepository.findAll();
        return PaymentResponse.builder().payment(payment).build();
    }

   
}