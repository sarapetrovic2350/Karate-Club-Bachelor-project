package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByUserId(Long userId);
	
}
