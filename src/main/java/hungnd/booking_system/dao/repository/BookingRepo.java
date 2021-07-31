package hungnd.booking_system.dao.repository;

import hungnd.booking_system.entity.jpa.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
