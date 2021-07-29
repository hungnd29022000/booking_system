package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.User;
import hungnd.booking_system.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component("userAdapter")
public class UserAdapter extends AbstractAdapter implements EntityAdapter<User, UserResponse> {
    @Override
    public UserResponse transform(User entity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(entity.getUserName());
        userResponse.setUserEmail(entity.getUserEmail());
        userResponse.setUserPhone(entity.getUserPhone());
        return userResponse;
    }
}
