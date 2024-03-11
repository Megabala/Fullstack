
package homecare.mega.dto.response;

import java.util.List;
import homecare.mega.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    List<Payment> payment;

}