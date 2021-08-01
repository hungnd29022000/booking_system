package hungnd.booking_system.service;

import hungnd.booking_system.adapter.ApartmentAdapter;
import hungnd.booking_system.adapter.UserAdapter;
import hungnd.booking_system.dao.jdbc.ApartmentDao;
import hungnd.booking_system.dao.jdbc.RoleDao;
import hungnd.booking_system.dao.jdbc.UserDao;
import hungnd.booking_system.dao.repository.RoleRepo;
import hungnd.booking_system.entity.Role;
import hungnd.booking_system.entity.User;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.request.UserRequest;
import hungnd.booking_system.model.response.ApartmentResponse;
import hungnd.booking_system.model.response.UserResponse;
import hungnd.booking_system.police.UserRule;
import hungnd.booking_system.dao.repository.UserRepo;
import hungnd.booking_system.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    //DAO
    @Autowired
    private ApartmentDao apartmentDao;


    //RULE
    @Autowired
    private UserRule userRule;


    //ADAPTER
    @Autowired
    @Qualifier("userAdapter")
    private UserAdapter userAdapter;

    @Autowired
    @Qualifier("apartmentAdapter")
    private ApartmentAdapter apartmentAdapter;


    //DAO REPO
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Object getUserById(Long userId) throws Exception {
        UserResponse userResponse = userAdapter.transform(userRepo.findById(userId).get());
        userResponse.setRoleName(roleRepo.findRoleByUserName(userResponse.getUserName()).getRoleName());
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

    @Override
    public Object findApartmentByUser(ApartmentResquest apartmentResquest, Double priceMax) throws Exception {
        List<ApartmentResponse> apartmentResponseList = apartmentDao.findApartmentByUser(apartmentResquest, priceMax).stream()
                .map(
                        apartment -> apartmentAdapter.transform(apartment)
                )
                .collect(Collectors.toList());
        return apartmentResponseList;
    }

    @Override
    public Object findUserByUserName(String username) throws Exception {
        UserResponse userResponse = userAdapter.transform(userRepo.findUserByUserName(username));
        userResponse.setRoleName(roleRepo.findRoleByUserName(userResponse.getUserName()).getRoleName());
        return userResponse;
    }
}
