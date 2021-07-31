package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingResponse {
    @Expose
    @SerializedName("apartment_id")
    private Long apartmentId;
    @Expose
    @SerializedName("user_id")
    private Long userId;
    @Expose
    @SerializedName("check_in")
    private String checkIn;
    @Expose
    @SerializedName("check_out")
    private String checkOut;
    @Expose
    @SerializedName("guest_count")
    private int guestCount;
    @Expose
    @SerializedName("total")
    private Long total;
    @Expose
    @SerializedName("booking_time")
    private String bookingTime;
    @Expose
    @SerializedName("status")
    private int status;

    public BookingResponse() {
    }

    public BookingResponse(Long apartmentId, Long userId, String checkIn, String checkOut, int guestCount, Long total, String bookingTime, int status) {
        this.apartmentId = apartmentId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestCount = guestCount;
        this.total = total;
        this.bookingTime = bookingTime;
        this.status = status;
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

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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
