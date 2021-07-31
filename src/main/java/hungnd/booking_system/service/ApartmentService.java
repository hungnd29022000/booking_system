package hungnd.booking_system.service;

import hungnd.booking_system.model.request.ApartmentResquest;

public interface ApartmentService {
    Object getApartmentById(Long apartmentId) throws Exception;

    Object postApartment(ApartmentResquest apartmentResquest) throws Exception;

    Object findAll() throws Exception;
}
