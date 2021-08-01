package hungnd.booking_system.controller;

import com.ecyrd.speed4j.StopWatch;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.request.UserRequest;
import hungnd.booking_system.security.config.JwtTokenUtil;
import hungnd.booking_system.service.RoleService;
import hungnd.booking_system.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
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
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getUserById(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "user_id") Long userId
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = userService.getUserById(userId);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("get user by id error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAllUser(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = userService.getAllUser();
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("get all user error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> postUser(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "password") String userPassword,
            @RequestParam(value = "user_name") String userName,
            @RequestParam(value = "phone", defaultValue = "")String userPhone,
            @RequestParam(value = "email", defaultValue = "") String userEmail

    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            UserRequest userResquest = new UserRequest(
                    userName,
                    userPassword,
                    userEmail,
                    userPhone
            );
            serverResponse = userService.postUser(userResquest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            eLogger.error("post user error: {}", se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("post user error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/user/apartment/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> findApartment(
                HttpServletRequest request,
                HttpServletResponse response,
                @RequestParam(value = "name", defaultValue = "") String name,
                @RequestParam(value = "area", defaultValue = "") Double area,
                @RequestParam(value = "capacity", defaultValue = "") Integer capacity,
                @RequestParam(value = "price_min", defaultValue = "") Double price,
                @RequestParam(value = "price_max", defaultValue = "") Double priceMax
            ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            ApartmentResquest apartmentResquest = new ApartmentResquest();
            if(area != null) {
                apartmentResquest.setApartmentArea(area);
            }
            if(capacity != null){
                apartmentResquest.setApartmentCapacity(capacity);
            }
            if(price != null) {
                apartmentResquest.setApartmentPrice(price);
            }
            if(name != null) {
                apartmentResquest.setApartmentName(name);
            }
            serverResponse = userService.findApartmentByUser(apartmentResquest, priceMax);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            eLogger.error("post user error: {}", se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("post user error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }

    @GetMapping(value = "user/me", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getUserByToken(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            String jwtToken = null;
            String requestTokenHeader = request.getHeader("Authorization");
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);
            } else {
                eLogger.error("JWT Token does not begin with Bearer String");
            }
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            serverResponse = userService.findUserByUserName(username);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("get user by id error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }
}
