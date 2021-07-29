package hungnd.booking_system.dao;

import hungnd.booking_system.entity.Booking;
import hungnd.booking_system.model.request.BookingRequest;

public interface BookingDao {
    Booking getBookingById(String bookingId);

    Booking postBooking(BookingRequest bookingRequest);
}
