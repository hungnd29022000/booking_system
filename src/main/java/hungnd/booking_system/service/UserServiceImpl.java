package hungnd.booking_system.service;

import hungnd.booking_system.adapter.UserAdapter;
import hungnd.booking_system.dao.jdbc.RoleDao;
import hungnd.booking_system.dao.jdbc.UserDao;
import hungnd.booking_system.dao.repository.RoleRepo;
import hungnd.booking_system.entity.jpa.Role;
import hungnd.booking_system.entity.jpa.User;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.UserRequest;
import hungnd.booking_system.model.response.UserResponse;
import hungnd.booking_system.police.UserRule;
import hungnd.booking_system.dao.repository.UserRepo;
import hungnd.booking_system.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractService implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRule userRule;

    @Autowired
    @Qualifier("userAdapter")
    private UserAdapter userAdapter;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Object getUserById(Long userId) throws Exception {
        UserResponse userResponse = userAdapter.transform(userRepo.findById(userId).get());
        return userResponse;
    }

    @Override
    public Object postUser(UserRequest userRequest) throws Exception {
        userRule.verify(userRequest);
        //save user
        User user = userRepo.save(userAdapter.transform(userRequest));
        UserResponse userResponse = userAdapter.transform(user);
        userResponse.setRoleName("basic");

        //save role auto
        Role role = new Role();
        role.setUserName(user.getUserName());
        role.setRoleName("basic");
        role.setStart(DateTimeUtils.generateTime(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
        roleRepo.save(role);
        return userResponse;
    }

    @Override
    public Object getAllUser() throws Exception {
        return userRepo.findAll()
                .stream()
                .map(
                        user -> {
                            UserResponse userResponse = userAdapter.transform(user);
                            userResponse.setRoleName(roleRepo.findRoleByUserName(user.getUserName()).getRoleName());
                            return userResponse;
                        }
                )
                .collect(Collectors.toList());
    }
}
