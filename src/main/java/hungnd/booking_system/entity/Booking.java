package hungnd.booking_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "apartment_id")
    private Long apartmentId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "check_in")
    private String checkIn;
    @Column(name = "check_out")
    private String checkOut;
    @Column(name = "guest_count")
    private int guestCount;
    @Column(name = "total")
    private Long total;
    @Column(name = "booking_time")
    private String bookingTime;
    @Column(name = "status")
    private int status;

    public Booking() {
    }

    public Booking(Long apartmentId, Long userId, String checkIn, String checkOut, int guestCount, Long total, String bookingTime, int status) {
        this.apartmentId = apartmentId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestCount = guestCount;
        this.total = total;
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
