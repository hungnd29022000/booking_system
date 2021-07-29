package hungnd.booking_system.model.request;

public class UserRequest {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;

    public UserRequest() {
    }

    public UserRequest(String userName, String userPassword, String userEmail, String userPhone) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
