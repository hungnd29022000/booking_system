package hungnd.booking_system.service;

import hungnd.booking_system.adapter.RoleAdapter;
import hungnd.booking_system.dao.jdbc.RoleDao;
import hungnd.booking_system.dao.repository.RoleRepo;
import hungnd.booking_system.entity.Role;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.response.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends AbstractService implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    @Qualifier("roleAdapter")
    private RoleAdapter roleAdapter;

    @Override
    public Object getRoleById(Long roleId) throws Exception {
        RoleResponse roleResponse = roleAdapter.transform(roleRepo.findById(roleId).get());
        return roleResponse;
    }

    @Override
    public Object postRole(RoleRequest roleRequest) throws Exception {
        Role role = roleAdapter.transform(roleRequest);
        RoleResponse roleResponse = roleAdapter.transform(roleRepo.save(role));
        return roleResponse;
    }

    @Override
    public Object findAll() throws Exception {
        return roleRepo.findAll().stream()
                .map(
                        role -> roleAdapter.transform(role)
                )
                .collect(Collectors.toList());
    }
}
