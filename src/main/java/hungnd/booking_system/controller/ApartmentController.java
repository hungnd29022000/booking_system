package hungnd.booking_system.controller;

import com.ecyrd.speed4j.StopWatch;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ApartmentController extends BaseController{
    @Autowired
    private ApartmentService apartmentService;


    @GetMapping(value = "/apartment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getApartmentById(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "apartment_id") String apartmentId
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = apartmentService.getApartmentById(apartmentId);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("find all employee error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/apartment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> postApartment(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "user_id") int userId,
            @RequestParam(value = "apartment_name") String apartmentName,
            @RequestParam(value = "apartment_capacity") int apartmentCapacity,
            @RequestParam(value = "apartment_area") Double aparmentArea,
            @RequestParam(value = "apartment_address") String apartmentAddress,
            @RequestParam(value = "apartment_price") Double apartmentPrice,
            @RequestParam(value = "day_min") int dayMin,
            @RequestParam(value = "day_max") int dayMax

    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            ApartmentResquest apartmentResquest = new ApartmentResquest(
                    userId,
                    apartmentName,
                    apartmentCapacity,
                    apartmentPrice,
                    apartmentAddress,
                    aparmentArea,
                    dayMin,
                    dayMax
            );


            serverResponse = apartmentService.postApartment(apartmentResquest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("find all employee error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }
    @PutMapping(value = "/apartment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> updateApartment(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "user_id", defaultValue = "") int userId,
            @RequestParam(value = "apartment_id") int apartmentId,
            @RequestParam(value = "apartment_name", defaultValue = "") String apartmentName,
            @RequestParam(value = "apartment_capacity", defaultValue = "") int apartmentCapacity,
            @RequestParam(value = "apartment_area", defaultValue = "") Double aparmentArea,
            @RequestParam(value = "apartment_address", defaultValue = "") String apartmentAddress,
            @RequestParam(value = "apartment_price", defaultValue = "") Double apartmentPrice,
            @RequestParam(value = "day_min", defaultValue = "") int dayMin,
            @RequestParam(value = "day_max", defaultValue = "") int dayMax

    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            ApartmentResquest apartmentResquest = new ApartmentResquest(
                    userId,
                    apartmentName,
                    apartmentCapacity,
                    apartmentPrice,
                    apartmentAddress,
                    aparmentArea,
                    dayMin,
                    dayMax
            );
            apartmentResquest.setApartmentId(apartmentId);
            serverResponse = apartmentService.updateApartment(apartmentResquest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("find all employee error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }

}
