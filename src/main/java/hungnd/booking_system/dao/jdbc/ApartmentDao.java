package hungnd.booking_system.dao.jdbc;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.model.request.ApartmentResquest;

import java.util.List;

public interface ApartmentDao {
    List<Apartment> findApartmentByUser(ApartmentResquest apartmentResquest, Double priceMax);
}
