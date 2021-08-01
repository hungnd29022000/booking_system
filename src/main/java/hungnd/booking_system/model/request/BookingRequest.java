package hungnd.booking_system.model.request;

public class BookingRequest {
    private Long bookingId;
    private Long apartmentId;
    private Long userId;
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

    public BookingRequest(Long bookingId, Long apartmentId, Long userId, String customerName, String customerPhone, String checkIn, String checkOut, int numberOfGuest, Double totalAmount, String bookingTime, int status) {
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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
