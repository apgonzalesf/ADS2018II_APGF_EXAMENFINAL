package studentSystem.scholarship.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import studentSystem.common.api.controller.ResponseHandler;
import studentSystem.scholarship.application.ScholarshipApplicationService;

@RestController
@RequestMapping("api/scholarship/{studentId}")
public class ScholarshipController {
	@Autowired
	ScholarshipApplicationService scholarshipApplicationService;

	@Autowired
	ResponseHandler responseHandler;

	@RequestMapping(path = "/calculate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> get(@PathVariable("studentId") BigDecimal studentId) {
		try {
			BigDecimal calculateScholarshipAmount = scholarshipApplicationService.calculateScholarshipAmount(studentId);
			return this.responseHandler.getDataResponse(calculateScholarshipAmount, HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
	}
}
