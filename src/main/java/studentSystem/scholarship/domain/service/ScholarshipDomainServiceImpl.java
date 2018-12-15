package studentSystem.scholarship.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentSystem.scholarship.domain.ScholarshipDomainService;
import studentSystem.students.domain.entity.Student;
import studentSystem.students.domain.repository.StudentRepository;

@Service
public class ScholarshipDomainServiceImpl implements ScholarshipDomainService {

	@Autowired
	StudentRepository  studentRepository;
	
	@Override
	public BigDecimal calculateScholarshipAmount(BigDecimal idStudent) throws IllegalArgumentException {
		Student student =  studentRepository.getById(idStudent);
		return student.calculateScholarship( );
		
	}
	 
	 
}
