package homecare.mega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import homecare.mega.model.Services;

public interface ServiceRepository extends JpaRepository<Services, String> {

}