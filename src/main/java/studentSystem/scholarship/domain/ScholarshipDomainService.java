package studentSystem.scholarship.domain;

import java.math.BigDecimal;

import studentSystem.students.domain.entity.Student;

public interface ScholarshipDomainService {

	BigDecimal calculateScholarshipAmount(BigDecimal studentId )
			throws IllegalArgumentException;

}