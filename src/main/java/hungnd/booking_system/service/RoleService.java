package hungnd.booking_system.service;

import hungnd.booking_system.model.request.RoleRequest;

public interface RoleService {
    Object getRoleById(String roleId) throws Exception;

    Object postRole(RoleRequest roleRequest) throws Exception;
}
