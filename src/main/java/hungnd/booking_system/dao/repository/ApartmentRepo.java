package hungnd.booking_system.dao.repository;
import hungnd.booking_system.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepo extends JpaRepository<Apartment,Long> {
}
