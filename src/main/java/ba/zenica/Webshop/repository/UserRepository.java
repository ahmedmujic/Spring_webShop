package ba.zenica.Webshop.repository;

import ba.zenica.Webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
    User findAllById(Integer id);
    /*@Query("SELECT u FROM User as u where u.userName= :username")
    public User getUserByUsername(@Param("username") String username);*/
}
