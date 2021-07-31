package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.jpa.Booking;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.model.response.BookingResponse;
import org.springframework.stereotype.Component;

@Component("bookingAdapter")
public class BookingAdapter extends AbstractAdapter implements EntityAdapter<Booking, BookingResponse> {
    @Override
    public BookingResponse transform(Booking entity) {
        BookingResponse bookingResponse = new BookingResponse(
                entity.getApartmentId(),
                entity.getUserId(),
                entity.getCheckIn(),
                entity.getCheckOut(),
                entity.getGuestCount(),
                entity.getTotal(),
                entity.getBookingTime(),
                entity.getStatus()
        );
        return bookingResponse;
    }

    public Booking transform(BookingRequest bookingRequest){
        Booking booking = new Booking(
                bookingRequest.getApartmentId(),
                bookingRequest.getUserId(),
                bookingRequest.getCheckIn(),
                bookingRequest.getCheckOut(),
                bookingRequest.getNumberOfGuest(),
                bookingRequest.getBookingId(),
                bookingRequest.getBookingTime(),
                bookingRequest.getStatus()
        );

        if (bookingRequest.getBookingId() != null){
            booking.setBookingId(bookingRequest.getBookingId());
        }

        return booking;
    }
}
