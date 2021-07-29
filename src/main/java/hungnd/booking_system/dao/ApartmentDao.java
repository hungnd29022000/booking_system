package hungnd.booking_system.dao;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.model.request.ApartmentResquest;

public interface ApartmentDao {
    Apartment getApartmentById(String apartmentId);

    Apartment postApartment(ApartmentResquest apartmentResquest);

    Apartment updateApartment(ApartmentResquest apartmentResquest);
}
