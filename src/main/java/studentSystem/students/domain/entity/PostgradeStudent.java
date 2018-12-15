package studentSystem.students.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PostgradeStudent extends Student implements Serializable {
	String postgradeMajor; 
	 @Override
	public BigDecimal calculateScholarship() {
			return  new BigDecimal(Math.random());
	}
}
