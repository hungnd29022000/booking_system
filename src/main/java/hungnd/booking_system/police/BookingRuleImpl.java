package hungnd.booking_system.police;

import hungnd.booking_system.dao.repository.ApartmentRepo;
import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingRuleImpl extends AbstractRule implements BookingRule {
    @Autowired
    private ApartmentRepo apartmentRepo;

    @Override
    public void verify(BookingRequest bookingRequest) throws Exception {
        if (bookingRequest.getApartmentId() == bookingRequest.getUserId()){
            throw new CommonException("Not hire your home", 601);
        }
        Apartment apartment = apartmentRepo.findById(bookingRequest.getApartmentId()).get();
        long duration = DateTimeUtils.getDurationTwoDay(bookingRequest.getCheckIn(),bookingRequest.getCheckOut());
        bookingRequest.setTotalAmount(duration * apartment.getPrice());

        //set booking time
        String now = DateTimeUtils.generateTime(System.currentTimeMillis());
        bookingRequest.setBookingTime(now);

        //set status
        //check booking
        //ok -> status = 1
        bookingRequest.setStatus(1);
    }
}
