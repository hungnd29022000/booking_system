package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.Role;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.response.RoleResponse;
import org.springframework.stereotype.Component;

@Component("roleAdapter")
public class RoleAdapter extends AbstractAdapter implements EntityAdapter<Role, RoleResponse> {
    @Override
    public RoleResponse transform(Role entity) {
        RoleResponse roleResponse = new RoleResponse(
                entity.getRoleName(),
                entity.getUserName()
        );
        return roleResponse;
    }

    public Role transform(RoleRequest roleRequest){
      Role role = new Role();
      if(roleRequest.getRoleId() != null){
          role.setRoleId(role.getRoleId());
      }
      role.setRoleName(roleRequest.getRoleName());
      role.setUserName(roleRequest.getUserName());
      role.setStart(roleRequest.getStart());
      role.setExp(roleRequest.getExp());
      return role;
    }
}
