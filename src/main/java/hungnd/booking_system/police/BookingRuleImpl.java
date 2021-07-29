package hungnd.booking_system.police;

import hungnd.booking_system.dao.ApartmentDao;
import hungnd.booking_system.dao.BookingDao;
import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingRuleImpl extends AbstractRule implements BookingRule {
    @Autowired
    private ApartmentDao apartmentDao;

    @Override
    public void verify(BookingRequest bookingRequest) throws Exception {
        Apartment apartment = apartmentDao.getApartmentById(bookingRequest.getApartmentId());
        long duration = DateTimeUtils.getDurationTwoDay(bookingRequest.getCheckIn(),bookingRequest.getCheckOut());
        bookingRequest.setTotalAmount(duration * apartment.getApartmentPrice());

        //set booking time
        String now = DateTimeUtils.generateTime(System.currentTimeMillis());
        bookingRequest.setBookingTime(now);

        //set status
        //check booking
        //ok -> status = 1
        bookingRequest.setStatus(1);
    }
}
