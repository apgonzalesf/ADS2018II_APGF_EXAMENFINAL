package studentSystem.students.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class UndergradeStudent extends Student implements Serializable {

	String major;

	@Override
	public BigDecimal calculateScholarship() {
		return new BigDecimal(Math.random());
	}
}
