package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.User;
import hungnd.booking_system.model.request.UserRequest;
import hungnd.booking_system.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component("userAdapter")
public class UserAdapter extends AbstractAdapter implements EntityAdapter<User, UserResponse> {
    @Override
    public UserResponse transform(User entity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(String.valueOf(entity.getUserId()));
        userResponse.setUserName(entity.getUserName());
        userResponse.setUserEmail(entity.getEmail());
        userResponse.setUserPhone(entity.getPhone());
        return userResponse;
    }

    public User transform(UserRequest userRequest){
        User user = new User();
        if(userRequest.getUserId() != null) {
            user.setUserId(Long.valueOf(userRequest.getUserId()));
        }
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getUserPassword());
        user.setPhone(userRequest.getUserPhone());
        user.setEmail(userRequest.getUserEmail());
        return user;
    };

}
