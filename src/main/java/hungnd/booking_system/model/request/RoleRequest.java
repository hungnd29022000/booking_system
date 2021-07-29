package hungnd.booking_system.model.request;

public class RoleRequest {
    private String roleId;
    private String roleName;
    private String userId;

    public RoleRequest() {
    }

    public RoleRequest(String roleName, String userId) {
        this.roleName = roleName;
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
