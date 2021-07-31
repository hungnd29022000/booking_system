package hungnd.booking_system.service;

import hungnd.booking_system.model.request.BookingRequest;

public interface BookingService {
    Object getBookingById(Long bookingId) throws Exception;

    Object postBooking(BookingRequest bookingRequest) throws Exception;

    Object findAll() throws Exception;
}
