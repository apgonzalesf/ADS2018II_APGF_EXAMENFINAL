package studentSystem.scholarship.application;

import java.math.BigDecimal;

public interface ScholarshipApplicationService {

	BigDecimal calculateScholarshipAmount(BigDecimal studentId) throws Exception;

	 

}