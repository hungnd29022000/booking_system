package hungnd.booking_system.dao;

import hungnd.booking_system.entity.Booking;
import hungnd.booking_system.factory.MySQLConnectionFactory;
import hungnd.booking_system.model.request.BookingRequest;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@Component
public class BookingDaoImpl extends AbstractDao implements BookingDao{
    @Override
    public Booking getBookingById(String bookingId) {
        Booking booking = new Booking();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + t_booking +
                " WHERE booking_id = "+bookingId;
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                booking.setBookingId(rs.getString("booking_id"));
                booking.setUserId(rs.getString("user_id"));
                booking.setApartmentId(rs.getString("apartment_id"));
                booking.setBookingTime(rs.getString("booking_time"));
                booking.setCheckIn(rs.getString("check_in"));
                booking.setCheckOut(rs.getString("check_out"));
                booking.setCustomerName(rs.getString("customer_name"));
                booking.setCustomerPhone(rs.getString("customer_phone"));
                booking.setNumberOfGuest(rs.getInt("number_of_guest"));
                booking.setTotalAmount(rs.getLong("total_amount"));
                booking.setStatus(rs.getInt("status"));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return booking;
    }

    @Override
    public Booking postBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO booking(apartment_id, user_id, booking_time,check_in,check_out,customer_name, customer_phone,number_of_guest,total_amount,status) " +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,bookingRequest.getApartmentId());
            stmt.setString(2,bookingRequest.getUserId());
            stmt.setString(3,bookingRequest.getBookingTime());
            stmt.setString(4,bookingRequest.getCheckIn());
            stmt.setString(5,bookingRequest.getCheckOut());
            stmt.setString(6,bookingRequest.getCustomerName());
            stmt.setString(7,bookingRequest.getCustomerPhone());
            stmt.setString(8,""+bookingRequest.getNumberOfGuest());
            stmt.setString(9,""+bookingRequest.getTotalAmount());
            stmt.setString(10,""+bookingRequest.getStatus());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while(rs.next()){
                booking = getBookingById(rs.getString(1));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return booking;
    }
}
