package hungnd.booking_system.service;

import hungnd.booking_system.model.request.ApartmentResquest;

public interface ApartmentService {
    Object getApartmentById(String apartmentId) throws Exception;

    Object postApartment(ApartmentResquest apartmentResquest) throws Exception;

    Object updateApartment(ApartmentResquest apartmentResquest) throws Exception;
}
