package studentSystem.students.domain.repository;

import java.math.BigDecimal;

import studentSystem.common.domain.repository.BaseRepository;
import studentSystem.students.domain.entity.Student;

public interface StudentRepository extends BaseRepository<Student> {

	Student getById(BigDecimal  idStudent);

	 
}
