package homecare.mega.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import homecare.mega.model.Bookings;


public interface BookingsRepository extends JpaRepository<Bookings,String> {
   List<Bookings> findByEmail(String email);
}
