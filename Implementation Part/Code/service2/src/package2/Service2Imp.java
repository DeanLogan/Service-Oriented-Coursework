package package2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


@WebService(endpointInterface="package2.Service2Interface")

public class Service2Imp implements Service2Interface {

	private final static String PATH = "Service2Interface.xml";

	public Controller getController(JAXBContext jAXBContext) throws JAXBException, IOException {
		Controller con = null;

		if( ! new java.io.File( PATH ).exists() ) {
			new java.io.File( PATH ).createNewFile();
			con = new Controller();
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( Controller.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			con = (Controller) unmarshaller.unmarshal( inputStream );
		}
		
		return con;
	}
	
	public void saveController(Controller con, JAXBContext jAXBContext) throws JAXBException, IOException {
		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( con, outputStream );
		
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );	
	}
	
	
	//for Controller class
	public void registrationOfEndUser(int id, String roleString) throws JAXBException, IOException {
		JAXBContext jAXBContext = JAXBContext.newInstance( Controller.class );
		Controller con = getController(jAXBContext);
		con.registrationOfEndUser(id, roleString);
		saveController(con, jAXBContext);
	}
	
	public int enrollStudentOnModule(int asmId, int studentId, String moduleCode, String ay) throws JAXBException, IOException{
		JAXBContext jAXBContext = JAXBContext.newInstance( Controller.class );
		Controller con = getController(jAXBContext);
		int result = con.enrollStudentOnModule(asmId, studentId, moduleCode, ay);
		saveController(con, jAXBContext);
		return result;
	}

	public int insertNewMark(int asmId, double mark, int studentId, String moduleCode, String acdYear) throws JAXBException, IOException{
		JAXBContext jAXBContext = JAXBContext.newInstance( Controller.class );
		Controller con = getController(jAXBContext);
		int result = con.insertNewMark(asmId, mark, studentId, moduleCode, acdYear);
		saveController(con, jAXBContext);
		return result;
	}

	public String reportingMarkForStudent(int asmId, int studentId, String moduleCode, String acdYear) throws JAXBException, IOException{
		JAXBContext jAXBContext = JAXBContext.newInstance( Controller.class );
		Controller con = getController(jAXBContext);
		String result = con.reportingMarkForStudent(asmId, studentId, moduleCode, acdYear);
		saveController(con, jAXBContext);
		return result;
	}
		
	public int assignModuleToStaffMember(int id, String moduleCode, int asmId, String acdYear) throws JAXBException, IOException{
		JAXBContext jAXBContext = JAXBContext.newInstance( Controller.class );
		Controller con = getController(jAXBContext);
		int result = con.assignModuleToStaffMember(id, moduleCode, asmId, acdYear);
		saveController(con, jAXBContext);
		return result;
	}
}
