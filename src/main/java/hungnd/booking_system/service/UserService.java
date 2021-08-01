package hungnd.booking_system.service;

import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.request.UserRequest;

public interface UserService {
    Object getUserById(Long userId) throws Exception;

    Object postUser(UserRequest userRequest) throws Exception;

    Object getAllUser() throws Exception;

    Object findApartmentByUser(ApartmentResquest apartmentResquest, Double priceMax) throws Exception;

    Object findUserByUserName(String username) throws Exception;
}
