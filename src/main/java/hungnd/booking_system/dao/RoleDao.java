package hungnd.booking_system.dao;

import hungnd.booking_system.entity.Role;
import hungnd.booking_system.model.request.RoleRequest;

public interface RoleDao {
    Role getRoleById(String roleId);

    Role postRole(RoleRequest roleRequest);
}
