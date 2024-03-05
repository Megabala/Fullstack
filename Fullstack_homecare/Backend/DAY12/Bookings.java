package homecare.mega.model;
import java.util.Date;
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
    private String service_id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String booking_date;

    @Column(nullable = false)
    private String booking_status;

    @Column(nullable = false)
    private String payment_id;
    
    @Column(nullable = false)
    private String user_id;
    
   


}

