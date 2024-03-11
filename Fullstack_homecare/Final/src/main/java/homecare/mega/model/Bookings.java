package homecare.mega.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String booking_id;

    @Column(nullable = false)
    private String patientname;

    @Column(nullable = false)
    private String dateofbirth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String mobilenumber;
    
    @Column(nullable = false)
    private String emergencycontact;
    
    @Column(nullable = false)
    private String medicalcondition;
    
    @Column(nullable = false)
    private String servicename;
    
    @Column(nullable = false)
    private String frequency;
    
    @Column(nullable = false)
    private String timing;
    
    @Column(nullable = false)
    private String language;
    
    @Column(nullable = false)
    private String bookingstatus;
    
    @Column(nullable = false,unique=true)
    private String email;





}