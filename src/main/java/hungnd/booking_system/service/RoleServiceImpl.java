package hungnd.booking_system.service;

import hungnd.booking_system.adapter.RoleAdapter;
import hungnd.booking_system.dao.RoleDao;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.response.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Autowired
    @Qualifier("roleAdapter")
    private RoleAdapter roleAdapter;

    @Override
    public Object getRoleById(String roleId) throws Exception {
        RoleResponse roleResponse = roleAdapter.transform(roleDao.getRoleById(roleId));
        return roleResponse;
    }

    @Override
    public Object postRole(RoleRequest roleRequest) throws Exception {
        RoleResponse roleResponse = roleAdapter.transform(roleDao.postRole(roleRequest));
        return roleResponse;
    }
}
