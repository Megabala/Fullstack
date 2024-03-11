package homecare.mega.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import homecare.mega.model.Token;


public interface TokenRepository extends JpaRepository<Token,String> {

    List<Token> findAllByUser_IdAndExpiredIsFalseAndRevokedIsFalse(String id);

    Optional<Token> findByToken(String token);

}
