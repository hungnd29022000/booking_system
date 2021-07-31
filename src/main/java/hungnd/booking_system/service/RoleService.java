package hungnd.booking_system.service;

import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.response.RoleResponse;

public interface RoleService {
    Object getRoleById(Long roleId) throws Exception;

    Object postRole(RoleRequest roleRequest) throws Exception;

    Object findAll() throws Exception;
}
