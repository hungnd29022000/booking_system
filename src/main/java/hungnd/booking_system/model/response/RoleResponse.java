package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoleResponse {
    @Expose
    @SerializedName("role_name")
    private String roleName;
    @Expose
    @SerializedName("user_id")
    private String userId;

    public RoleResponse() {
    }

    public RoleResponse(String roleName, String userId) {
        this.roleName = roleName;
        this.userId = userId;
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
