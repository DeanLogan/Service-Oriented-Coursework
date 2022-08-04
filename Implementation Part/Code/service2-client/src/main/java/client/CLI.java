package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import package2.IOException_Exception;
import package2.JAXBException_Exception;
import package2.Service2Interface;
import package3.Service3Interface;

public class CLI {

	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:8080/service2/?wsdl");

		QName qname = new QName("http://package2/", "Service2ImpService");

		Service service = Service.create(url, qname);

		Service2Interface obj = service.getPort(Service2Interface.class);
		
		//Use case 1
		System.out.println("1. Batch registration of end-users");
		for(int i=0; i<7; i++) {
			if(i < 5) {
				regEndUsers(obj, i, "Student");
				System.out.println("Enrolling the student with ID "+i);
			}
			else {
				regEndUsers(obj, i, "AcademicStaffMember");
				System.out.println("Enrolling the academic staff member with ID "+i);
			}
		}
		
		//Use case 2
		System.out.println("");
		System.out.println("2. Enrolling a student on a module");
		enrollStudent(obj, 0, 1, "CSC1022", "AY_2021_22");
		enrollStudent(obj, 5, 7, "CSC1022", "AY_2021_22");
		enrollStudent(obj, 5, 1, "CSC1022", "AY_2021_22");
		
		//Use case 3
		System.out.println("");
		System.out.println("3. Inserting a new mark");
		insertMark(obj, 0, 100, 1, "CSC1022", "AY_2021_22");
		insertMark(obj, 5, 100, 1, "CSC1023", "AY_2021_22");
		insertMark(obj, 5, 100, 7, "CSC1022", "AY_2021_22");
		insertMark(obj, 5, 100, 1, "CSC1022", "AY_2021_22");
		
		//Use case 4
		System.out.println("");
		System.out.println("4. Reporting the mark of a student");
		reportingMark(obj, 2, 1, "CSC1022", "AY_2021_22");
		reportingMark(obj, 5, 1, "CSC1022", "AY_2021_22");
		
		//Use case 5
		System.out.println("");
		System.out.println("5. Assigning a module to an academic staff member");
		assignModule(obj, 2, "CSC1022", 2, "AY_2021_22");
		assignModule(obj, 5, "CSC1022", 5, "AY_2021_22");
	}
	
	//Use case 1
	public static void regEndUsers(Service2Interface obj, int id, String role) {
		try {
			obj.registrationOfEndUser(id, role);
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Use case 2
	public static void enrollStudent(Service2Interface obj, int asmId, int studentId, String moduleCode, String acdYear) {
		int result = -1;		
		try {
			result = obj.enrollStudentOnModule(asmId, studentId, moduleCode, acdYear);
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		if(result == -1) {
			System.out.println("Error enrolling student with ID " +studentId+ " by the academic staff member with ID " +asmId);
		}
		else if(result == 0) {
			System.out.println("Successful enrolment of the student with ID "+studentId+" on the module with code "+moduleCode+", "+acdYear+" by the academic staff member with ID " +asmId);
		}
	}
	
	//Use case 3
	public static void insertMark(Service2Interface obj, int asmId, double mark, int studentId, String moduleCode, String acdYear) {
		int result;
		try {
			result = obj.insertNewMark(asmId, mark, studentId, moduleCode, acdYear);
		} catch (Exception e) {
			result = -1;
		}
		//casts mark to int for the output to match the result of test cases that are seen in the coursework specification
		if(result == -1) {
			System.out.println("Error inserting the mark "+(int)mark+" for the student with ID "+studentId+" on the module with code " +moduleCode+ " by the academic staff member with ID "+asmId);
		}
		else if(result == 0) {
			System.out.println("Successful insertion of the mark "+(int)mark+" for the student with ID "+studentId+" on the module with code " +moduleCode+ " by the academic staff member with ID "+asmId);
		}
	}
	
	public static void reportingMark(Service2Interface obj, int asmId, int studentId, String moduleCode, String acdYear) {
		String result;
		try {
			result = obj.reportingMarkForStudent(asmId, studentId, moduleCode, acdYear);
		} catch (Exception e) {
			result = "";
		}
		if(result.equals("")) {
			System.out.println("Error reporting the module for the student with ID "+studentId+ " by the academic staff member with ID "+asmId);
		}
		else {
			System.out.println("Reporting the modules for the student with ID "+studentId+" by the academic staff member with ID "+asmId+" "+result);
		}
	}
	
	
	public static void assignModule(Service2Interface obj, int id, String moduleCode, int asmId, String acdYear) {
		int result;
		try {
			result = obj.assignModuleToStaffMember(id, moduleCode, asmId, acdYear);
		} catch (Exception e) {
			result = -1;
		}
		if(result == -1) {
			System.out.println("Error assignment of the module "+moduleCode+", "+acdYear+ " to the academic staff member with ID "+asmId);
		}
		else if(result == 0) {
			System.out.println("Successful assignment of the module "+moduleCode+", "+acdYear+ " to the academic staff member with ID "+asmId);
		}
	}
}
