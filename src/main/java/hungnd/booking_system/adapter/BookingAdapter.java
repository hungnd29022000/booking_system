package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.Booking;
import hungnd.booking_system.model.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component("bookingAdapter")
public class BookingAdapter extends AbstractAdapter implements EntityAdapter<Booking, BookingResponse> {
    @Override
    public BookingResponse transform(Booking entity) {
        BookingResponse bookingResponse = new BookingResponse(
                entity.getApartmentId(),
                entity.getUserId(),
                entity.getCustomerName(),
                entity.getCustomerPhone(),
                entity.getCheckIn(),
                entity.getCheckOut(),
                entity.getNumberOfGuest(),
                entity.getTotalAmount(),
                entity.getBookingTime(),
                entity.getStatus()
        );
        return bookingResponse;
    }
}
