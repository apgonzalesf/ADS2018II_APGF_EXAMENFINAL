package studentSystem.students.infrastructure.hibernate.repository;

import java.math.BigDecimal;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import studentSystem.common.infrastructure.hibernate.repository.BaseHibernateRepository;
import studentSystem.students.domain.entity.Student;
import studentSystem.students.domain.repository.StudentRepository;

@Transactional
@Repository
public class StudentHibernateRepository extends BaseHibernateRepository<Student> implements StudentRepository {

	@Override
	public Student getById(BigDecimal idStudent) {
		Student user = null;
		Criteria criteria = getSession().createCriteria(Student.class, "u"); 
		criteria.add(Restrictions.eq("u.id", idStudent));
		user = (Student) criteria.uniqueResult();
		return user;
		 
	}

 
 
}
