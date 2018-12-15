package studentSystem.students.api.controller;

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
@RequestMapping("api/students")
public class StudentsController {
	@Autowired
	UserApplicationService userApplicationService;
	
	@Autowired
	ResponseHandler responseHandler;
	 
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
	
	 
}
