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
@Table(name="_userprofile")
public class UserProfile  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false ,  unique = true)
    private String email ;

    @Column(nullable = false)
    private String middlename;
    
    @Column(nullable = false)
    private String lastname;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String mobilenumber;
    
    @Column(nullable = false)
    private String dateofbirth;
    

    
    


}

