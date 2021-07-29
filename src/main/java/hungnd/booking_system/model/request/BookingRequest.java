package hungnd.booking_system.model.request;

import com.sun.beans.editors.DoubleEditor;

public class BookingRequest {
    private String bookingId;
    private String apartmentId;
    private String userId;
    private String customerName;
    private String customerPhone;
    private String checkIn;
    private String checkOut;
    private int numberOfGuest;
    private Double totalAmount;
    private String bookingTime;
    private int status;

    public BookingRequest() {
    }

    public BookingRequest(String bookingId, String apartmentId, String userId, String customerName, String customerPhone, String checkIn, String checkOut, int numberOfGuest, Double totalAmount, String bookingTime, int status) {
        this.bookingId = bookingId;
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

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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
