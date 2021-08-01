package hungnd.booking_system.controller;

import com.ecyrd.speed4j.StopWatch;
import hungnd.booking_system.exception.CommonException;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.service.RoleService;
import hungnd.booking_system.utils.DateTimeUtils;
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
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;


    @GetMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getRoleById(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "role_id") Long roleId
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = roleService.getRoleById(roleId);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("find role by id error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> postRole(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "role_name") String roleName
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            RoleRequest roleResquest = new RoleRequest();
            roleResquest.setUserName(username);
            roleResquest.setRoleName(roleName);
            roleResquest.setStart(DateTimeUtils.generateTime(System.currentTimeMillis()));
            serverResponse = roleService.postRole(roleResquest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("post role error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAllRole(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            serverResponse = roleService.findAll();
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("get all role error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> changeRole(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "role_id") Long roleId,
            @RequestParam(value = "user_name") String username,
            @RequestParam(value = "role_name") String roleName
    ){
        StopWatch sw = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String svcResponse;
        Object serverResponse;
        try {
            RoleRequest roleResquest = new RoleRequest();
            roleResquest.setRoleId(roleId);
            roleResquest.setRoleName(roleName);
            roleResquest.setUserName(username);
            roleResquest.setStart(DateTimeUtils.generateTime(System.currentTimeMillis()));
            serverResponse = roleService.postRole(roleResquest);
            svcResponse = gson.toJson(serverResponse);
            requestLogger.info("finish process request {} in {}", requestUri, sw.stop());
            return new ResponseEntity<>(svcResponse, HttpStatus.OK);

        } catch (CommonException se) {
            se.printStackTrace();
            eLogger.error(se.getMessage());
            svcResponse = buildFailureResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            eLogger.error("post role error: {}", e.getMessage());
            svcResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an error occurred");
        }
        return new ResponseEntity<>(svcResponse, HttpStatus.OK);
    }
}
