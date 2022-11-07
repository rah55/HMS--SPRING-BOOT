package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.user;

public interface userRepository extends JpaRepository<user, Integer> {
	@Query(value = "selecct * from user where user_id=?1", nativeQuery = true)
	user findByUserId(int userid);
}
