package hungnd.booking_system.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleTask {
//    @Autowired
//    private BookingDao bookingDao;
//
//    //Đặt lịch sẽ cập nhật lại trạng thái booking
//    //nếu thời gian hiện tại quá ngày check in(status = 1 hoặc 2) -> hủy booking -> status = 0
//    //nếu thời gian hiện tại quá ngày booking 3 ngày -> chưa đặt cọc (status = 1) -> hủy
//    @Scheduled(fixedDelay = 1000 * 60)
//    public void updateBooking() {
//        bookingDao.updateBookingStatus();
//        System.out.println("Updated status");
//    }
//
//    @Scheduled(cron = "0 0 12 * * ?")
//    public void finishDeal() {
//        bookingDao.updateBookingFinish();
//        System.out.println("update finish deal");
//    }
}
