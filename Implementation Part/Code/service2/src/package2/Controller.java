package package2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import package1.AcademicStaffMember;
import package1.Module1;
import package1.ModuleCode1;
import package1.ModuleCodeEnum1;
import package1.Service1Interface;
import package3.IOException_Exception;
import package3.JAXBException_Exception;
import package3.Module;
import package3.ModuleCode;
import package3.ModuleCodeEnum;
import package3.Service3Interface;
import package3.Student;



@XmlRootElement

public class Controller {
	private Service3Interface service3Interface;
	private Service1Interface service1Interface;
	
	public Controller() {
		URL url1 = null;
		URL url3 = null;
		try {
			url1 = new URL("http://localhost:8080/service1/?wsdl");
			url3 = new URL("http://localhost:8080/service3/?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		QName qname1 = new QName("http://package1/", "Service1ImpService");
		QName qname3 = new QName("http://package3/", "Service3ImpService");
		Service service1 = Service.create(url1, qname1);
		Service service3 = Service.create(url3, qname3);
		service1Interface = service1.getPort(Service1Interface.class);
		service3Interface = service3.getPort(Service3Interface.class);
	}

	public void registrationOfEndUser(int id, String role) {
		
		Role roleEnum = Role.valueOf(role);
		
		if(roleEnum == Role.Student) {
			Student student = new Student();
			student.setId(id);
			try {
				service3Interface.addStudent(student, id);
			} catch (Exception e) {
				return;
			} 
		}
		else if(roleEnum == Role.AcademicStaffMember) {
			AcademicStaffMember staffMember = new AcademicStaffMember();
			staffMember.setId(id);
			try {
				service1Interface.addAcademicStaffMember(staffMember, id);
			} catch (Exception e) {
				return;
			} 
		}
	}

	public int enrollStudentOnModule(int asmId, int studentId, String moduleCode, String ay) {
		int result = -1;	
		try {
			if(service1Interface.checkIfIdHasACDRole(asmId)) {
				if(service3Interface.checkIfIdHasStudentRole(studentId)) {
					service3Interface.addModule(studentId, moduleCode, ay);
					result = 0;
				}
			}
		} catch (IOException_Exception | JAXBException_Exception | package1.IOException_Exception | package1.JAXBException_Exception e) {
			return result;
		}
		return result;
	}

	public int insertNewMark(int asmId, double mark, int studentId, String moduleCode, String acdYear) {
		int result = -1;
		System.out.println("hello");
		try {
			if(service1Interface.checkIfIdHasACDRole(asmId)) {
				if(service3Interface.checkIfIdHasStudentRole(studentId)) {
					if(service3Interface.newMark(studentId, moduleCode, acdYear, mark)) {
						result = 0;
					}
				}
			}
		} catch (IOException_Exception | JAXBException_Exception | package1.IOException_Exception | package1.JAXBException_Exception e) {
			return result;
		}
		
		return result;
	}

	public String reportingMarkForStudent(int asmId, int studentId, String moduleCode, String acdYear) {
		String result = "";
		
		try {
			if(service1Interface.checkIfIdHasACDRole(asmId)) {
				if(service3Interface.checkIfIdHasStudentRole(studentId)) {
					result = service3Interface.reportMark(studentId, moduleCode, acdYear);
				}
			}
		} catch (IOException_Exception | JAXBException_Exception | package1.IOException_Exception | package1.JAXBException_Exception e) {
			return result;
		}
		
		return result;
	}

	public int assignModuleToStaffMember(int id, String moduleCode, int asmId, String acdYear) {
		int result = -1;	
		try {
			if(service1Interface.checkIfIdHasACDRole(id)) {
				if(service1Interface.checkIfIdHasACDRole(asmId)) {
					service1Interface.addModule1(asmId, moduleCode, acdYear);
					result = 0;
				}
			}
		} catch (package1.IOException_Exception | package1.JAXBException_Exception e) {
			return result;
		}
		return result;
	}
}