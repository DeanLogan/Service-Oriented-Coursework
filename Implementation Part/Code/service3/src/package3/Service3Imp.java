package package3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@WebService(endpointInterface="package3.Service3Interface")

public class Service3Imp implements Service3Interface {
	
	private final static String PATH = "Service3Interface.xml";
	
	public Students getStudents(JAXBContext jAXBContext) throws JAXBException, IOException {
		Students students = new Students();

		if( ! new java.io.File( PATH ).exists() ) {
			new java.io.File( PATH ).createNewFile();
			students = new Students();
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( Students.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			students = (Students) unmarshaller.unmarshal( inputStream );
		}
		
		return students;
	}
	
	public void saveStudents(Students students, JAXBContext jAXBContext) throws JAXBException, IOException {
		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( students, outputStream );
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	public Student getStudentAtId(int id) throws JAXBException, IOException {
		Student student = new Student();
		
		JAXBContext jAXBContext = JAXBContext.newInstance( Students.class );

		Students students = getStudents(jAXBContext);
		
		Student[] studentArray = students.getStudentArray();
		if(studentArray[id] == null) {
			student.setId(-1);
		}
		else {
			student = studentArray[id];
		}
		
		return student;
	}
	
	public void addStudent(Student student, int id) throws JAXBException, IOException {		
		JAXBContext jAXBContext = JAXBContext.newInstance( Students.class );

		Students students = getStudents(jAXBContext);
		
		Student[] studentArray = students.getStudentArray();
		studentArray[id] = student;
		students.setStudentArray(studentArray);

		saveStudents(students,jAXBContext);
	}
	
	public Module getModule(String moduleCode, String acdYear, int id) throws JAXBException, IOException {
		Module module = null;
		
		Student student = getStudentAtId(id);
		
		Module[] modules = student.getModules();
		
		for(int i=0; i<modules.length; i++) {
			if(modules[i] != null ) {
				if(modules[i].getAcademicYear().equals(acdYear) && modules[i].getModuleCode() == ModuleCode.valueOf(moduleCode)) {
					module = modules[i];
					break;
				}
			}
		}
		return module;
	}
	
	public void addModule(int id, String moduleCode, String ay) throws JAXBException, IOException {
		Student student = getStudentAtId(id);
		
		ModuleCode mc = ModuleCode.valueOf(moduleCode);
		Module module = new Module();
		module.setModuleCode(mc);
		module.setAcademicYear(ay);
		
		Module[] modules = student.getModules();
		
		for(int i=0; i<modules.length; i++) {
			if(modules[i] == null) {
				modules[i] = module;
				break;
			}
			else if(modules[i].getAcademicYear().equals(ay) && modules[i].getModuleCode() == ModuleCode.valueOf(moduleCode)) {
				modules[i] = module;
			}
		}
		
		addStudent(student, id);
	}
	
	public boolean checkIfIdHasStudentRole(int id) throws JAXBException, IOException {
		Student student = getStudentAtId(id);
		
		if(student.getId() == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean newMark(int id, String moduleCode, String ay, double mark) throws JAXBException, IOException {
		double result = -1;
		Module module = getModule(moduleCode, ay, id);
		if(module == null) {
			return false;
		}
		module.setMark(mark);
		
		Student student = getStudentAtId(id);
		
		Module[] modules = student.getModules();
		
		for(int i=0; i<modules.length; i++) {
			if(modules[i] != null) {
				if(modules[i].getAcademicYear().equals(ay) && modules[i].getModuleCode() == ModuleCode.valueOf(moduleCode)) {
					modules[i] = module;
					break;
				}
			}
		}
		student.setModules(modules);
		addStudent(student, id);
		return true;
	}
	
	public String reportMark(int id, String moduleCode, String ay) throws JAXBException, IOException {
		Module module = getModule(moduleCode, ay, id);
		
		if(!module.getAcademicYear().equals("")) {
			return module.getModuleCode() + " " + module.getAcademicYear() + " " + module.getMark();
		}
		return "";
	}
}
