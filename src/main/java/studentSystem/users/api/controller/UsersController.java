package studentSystem.users.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentSystem.common.api.controller.ResponseHandler;
import studentSystem.users.application.UserApplicationService;
import studentSystem.users.application.dto.UserAuthDto;
import studentSystem.users.application.dto.UserDto;

@RestController
@RequestMapping("api/users")
public class UsersController {
	@Autowired
	UserApplicationService userApplicationService;
	
	@Autowired
	ResponseHandler responseHandler;
	
	@RequestMapping(method = RequestMethod.POST, path = "", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> create(@RequestBody UserDto userDto) throws Exception {
        try {
        	userDto = userApplicationService.create(userDto);
            return new ResponseEntity<Object>(userDto, HttpStatus.OK);
        } catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
    }

	@RequestMapping(method = RequestMethod.POST, path = "/login", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> login(@RequestBody UserDto requestLoginUserDto) throws Exception {
		try {
			UserAuthDto userAuthDto = userApplicationService.validateUser(requestLoginUserDto);
			if (userAuthDto.isAuthenticated()) {
				return new ResponseEntity<Object>(userAuthDto, HttpStatus.OK);
			}
			return this.responseHandler.getResponse("Invalid User Name / Password", HttpStatus.NOT_FOUND);
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> get(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(value = "pageSize", required = false, defaultValue = "100") int pageSize) throws Exception {
		try {
			List<UserDto> users = userApplicationService.getPaginated(page, pageSize);
			return new ResponseEntity<Object>(users, HttpStatus.OK);
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{userId}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> get(@PathVariable("userId") long userId) throws Exception {
		try {
			UserDto userDto = userApplicationService.get(userId);
			return new ResponseEntity<Object>(userDto, HttpStatus.OK);
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
	}
}
