package studentSystem.students.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import studentSystem.common.domain.entity.BaseEntity;

public class Student extends BaseEntity implements Serializable {
	private String firstName;
	private String lastName;
	private Boolean isActive;
	private String identityDocument;
 
	public BigDecimal calculateScholarship() {
		return new BigDecimal(0);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(String identityDocument) {
		this.identityDocument = identityDocument;
	}
	 
	 

}
