package hungnd.booking_system.service;

import hungnd.booking_system.adapter.UserAdapter;
import hungnd.booking_system.dao.UserDao;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.request.UserRequest;
import hungnd.booking_system.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userAdapter")
    private UserAdapter userAdapter;

    @Override
    public Object getUserById(String userId) throws Exception {
        UserResponse userResponse = userAdapter.transform(userDao.getUserById(userId));
        return userResponse;
    }

    @Override
    public Object postUser(UserRequest userRequest) throws Exception {
        UserResponse userResponse = userAdapter.transform(userDao.postUser(userRequest));
        return userResponse;
    }
}
