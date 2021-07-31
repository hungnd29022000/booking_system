package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoleResponse {
    @Expose
    @SerializedName("role_name")
    private String roleName;
    @Expose
    @SerializedName("username")
    private String userName;

    public RoleResponse() {
    }

    public RoleResponse(String roleName, String userName) {
        this.roleName = roleName;
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
