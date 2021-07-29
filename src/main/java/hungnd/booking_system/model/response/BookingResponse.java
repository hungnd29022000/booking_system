package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingResponse {
    @Expose
    @SerializedName("apartment_id")
    private String apartmentId;
    @Expose
    @SerializedName("user_id")
    private String userId;
    @Expose
    @SerializedName("customer_name")
    private String customerName;
    @Expose
    @SerializedName("customer_phone")
    private String customerPhone;
    @Expose
    @SerializedName("check_in")
    private String checkIn;
    @Expose
    @SerializedName("check_out")
    private String checkOut;
    @Expose
    @SerializedName("number_of_guest")
    private int numberOfGuest;
    @Expose
    @SerializedName("total_amount")
    private Long totalAmount;
    @Expose
    @SerializedName("booking_time")
    private String bookingTime;
    @Expose
    @SerializedName("status")
    private int status;

    public BookingResponse() {
    }

    public BookingResponse(String apartmentId, String userId, String customerName, String customerPhone, String checkIn, String checkOut, int numberOfGuest, Long totalAmount, String bookingTime, int status) {
        this.apartmentId = apartmentId;
        this.userId = userId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfGuest = numberOfGuest;
        this.totalAmount = totalAmount;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
