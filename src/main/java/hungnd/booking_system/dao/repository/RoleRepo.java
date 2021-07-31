package hungnd.booking_system.dao.repository;

import hungnd.booking_system.entity.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r where r.username = ?1")
    Role findRoleByUserName(String username);
}
