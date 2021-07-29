package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @Expose
    @SerializedName("username")
    private String userName;
    @Expose
    @SerializedName("email")
    private String userEmail;
    @Expose
    @SerializedName("phone")
    private String userPhone;

    public UserResponse() {
    }

    public UserResponse(String userName, String userEmail, String userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
