package hungnd.booking_system.service;

import hungnd.booking_system.model.request.BookingRequest;

public interface BookingService {
    Object getBookingById(String bookingId) throws Exception;

    Object postBooking(BookingRequest bookingRequest) throws Exception;
}
