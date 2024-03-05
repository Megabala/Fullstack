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
@Table(name="_services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String service_id;

    @Column(nullable = false)
    private String service_name ;

    @Column(nullable = false)
    private String description ;

    @Column(nullable = false)
    private float amount ;

    @Column(nullable = false)
    private String duration ;

    @Column(nullable = false)
    private boolean availability ;


}
