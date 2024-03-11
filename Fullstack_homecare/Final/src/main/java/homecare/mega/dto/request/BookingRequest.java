package homecare.mega.dto.request;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    
    private String patientname;
    private String dateofbirth;
    private String gender;
    private String address;
    private String mobilenumber;
    private String emergencycontact;
    private String medicalcondition;
    private String servicename;
    private String frequency;
    private String timing;
    private String language;
    private String bookingstatus;
     private String email;

}