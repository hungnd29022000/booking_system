package hungnd.booking_system.controller;

import com.ecyrd.speed4j.StopWatch;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.request.BookingRequest;
import hungnd.booking_system.model.response.BookingResponse;
import hungnd.booking_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BookingController extends BaseController {
    @Autowired
    private BookingService bookingService;
    @GetMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getBookingById(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "booking_id") String bookingId
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = bookingService.getBookingById(bookingId);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("find booking by id error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> postBooking(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "user_id") String userId,
            @RequestParam(value = "apartment_id") String apartmentId,
            @RequestParam(value = "customer_name") String customerName,
            @RequestParam(value = "customer_phone") String customerPhone,
            @RequestParam(value = "check_in") String checkIn,
            @RequestParam(value = "check_out") String checkOut,
            @RequestParam(value = "number_of_guest") int numberOfGuest
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            BookingRequest bookingRequest = new BookingRequest();
            bookingRequest.setUserId(userId);
            bookingRequest.setApartmentId(apartmentId);
            bookingRequest.setCustomerName(customerName);
            bookingRequest.setCustomerPhone(customerPhone);
            bookingRequest.setCheckIn(checkIn);
            bookingRequest.setCheckOut(checkOut);
            bookingRequest.setNumberOfGuest(numberOfGuest);
            serverResponse = bookingService.postBooking(bookingRequest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("post booking error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }

}
