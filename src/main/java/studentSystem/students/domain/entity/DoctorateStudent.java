package studentSystem.students.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class DoctorateStudent extends Student implements Serializable {
	
	String doctorateMajor; 
	 @Override
	public BigDecimal calculateScholarship() {
		return  new BigDecimal(Math.random());
	}
}
