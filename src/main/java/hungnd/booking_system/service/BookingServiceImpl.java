package hungnd.booking_system.service;

import hungnd.booking_system.adapter.BookingAdapter;
import hungnd.booking_system.dao.BookingDao;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.model.response.BookingResponse;
import hungnd.booking_system.police.BookingRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends AbstractService implements BookingService{
    @Autowired
    private BookingDao bookingDao;

    @Autowired
    @Qualifier("bookingAdapter")
    private BookingAdapter bookingAdapter;

    @Autowired
    private BookingRule bookingRule;

    @Override
    public Object getBookingById(String bookingId) throws Exception {
        BookingResponse bookingResponse = bookingAdapter.transform(bookingDao.getBookingById(bookingId));
        return bookingResponse;
    }

    @Override
    public Object postBooking(BookingRequest bookingRequest) throws Exception {
        bookingRule.verify(bookingRequest);
        BookingResponse bookingResponse = bookingAdapter.transform(bookingDao.postBooking(bookingRequest));
        return bookingResponse;
    }
}
