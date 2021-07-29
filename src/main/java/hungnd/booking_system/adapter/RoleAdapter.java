package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.Role;
import hungnd.booking_system.model.response.RoleResponse;
import org.springframework.stereotype.Component;

@Component("roleAdapter")
public class RoleAdapter extends AbstractAdapter implements EntityAdapter<Role, RoleResponse> {
    @Override
    public RoleResponse transform(Role entity) {
        RoleResponse roleResponse = new RoleResponse(
                entity.getRoleName(),
                entity.getUserId()
        );
        return roleResponse;
    }
}
