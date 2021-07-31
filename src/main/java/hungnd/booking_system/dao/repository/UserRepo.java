package hungnd.booking_system.dao.repository;

import hungnd.booking_system.entity.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u where u.userName = ?1")
    User findUserByUserName(String username);
}
