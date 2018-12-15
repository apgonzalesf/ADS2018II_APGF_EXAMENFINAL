package studentSystem.scholarship.application.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentSystem.scholarship.application.ScholarshipApplicationService;
import studentSystem.scholarship.domain.ScholarshipDomainService;

@Service
public class ScholarshipApplicationServiceImpl implements ScholarshipApplicationService {
	@Autowired
	ScholarshipDomainService scholarshipDomainService;

	@Override
	public BigDecimal calculateScholarshipAmount(BigDecimal studentId) throws Exception {
		return scholarshipDomainService.calculateScholarshipAmount(studentId);

	}

}
