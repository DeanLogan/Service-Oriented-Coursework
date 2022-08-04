package package3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Students {
	private Student[] studentArray;
	
	public Students() {
		studentArray = new Student[1000];
	}

	public Student[] getStudentArray() {
		return studentArray;
	}

	public void setStudentArray(Student[] studentArray) {
		this.studentArray = studentArray;
	}
}
