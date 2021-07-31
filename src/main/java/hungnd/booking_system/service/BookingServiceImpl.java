package hungnd.booking_system.service;

import hungnd.booking_system.adapter.BookingAdapter;
import hungnd.booking_system.dao.jdbc.BookingDao;
import hungnd.booking_system.dao.repository.BookingRepo;
import hungnd.booking_system.entity.jpa.Booking;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.model.response.BookingResponse;
import hungnd.booking_system.police.BookingRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookingServiceImpl extends AbstractService implements BookingService{
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    @Qualifier("bookingAdapter")
    private BookingAdapter bookingAdapter;

    @Autowired
    private BookingRule bookingRule;


    @Override
    public Object getBookingById(Long bookingId) throws Exception {
        Booking booking = bookingRepo.findById(bookingId).get();
        BookingResponse bookingResponse = bookingAdapter.transform(booking);
        return bookingResponse;
    }

    @Override
    public Object postBooking(BookingRequest bookingRequest) throws Exception {
        bookingRule.verify(bookingRequest);
        Booking booking = bookingRepo.save(bookingAdapter.transform(bookingRequest));
        BookingResponse bookingResponse = bookingAdapter.transform(booking);
        return bookingResponse;
    }

    @Override
    public Object findAll() throws Exception {
        return bookingRepo.findAll().stream()
                .map(
                        booking -> bookingAdapter.transform(booking)
                )
                .collect(Collectors.toList());
    }
}
