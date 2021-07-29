package hungnd.booking_system.dao;

import hungnd.booking_system.entity.User;
import hungnd.booking_system.model.request.UserRequest;

public interface UserDao {
    User getUserById(String userId);

    User postUser(UserRequest userRequest);
}
