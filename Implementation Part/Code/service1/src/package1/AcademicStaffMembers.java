package package1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class AcademicStaffMembers {
	private AcademicStaffMember[] academicStaffMemberArray = new AcademicStaffMember[100];
	
	public AcademicStaffMembers() {
		
	}

	public AcademicStaffMember[] getAcademicStaffMemberArray() {
		return academicStaffMemberArray;
	}

	public void setAcademicStaffMemberArray(AcademicStaffMember[] academicStaffMemberArray) {
		this.academicStaffMemberArray = academicStaffMemberArray;
	}
}
