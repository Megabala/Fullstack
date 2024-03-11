package homecare.mega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import homecare.mega.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, String> {

}