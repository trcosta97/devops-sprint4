package br.com.hearMeOut.userCrud.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByStatusTrue();

    Optional<User> findByIdAndStatusTrue(Long id);
}
