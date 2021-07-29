package hungnd.booking_system.service;

import hungnd.booking_system.model.request.UserRequest;

public interface UserService {
    Object getUserById(String userId) throws Exception;

    Object postUser(UserRequest userRequest) throws Exception;

}
