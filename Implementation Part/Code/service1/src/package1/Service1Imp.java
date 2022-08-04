package package1;

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


@WebService(endpointInterface="package1.Service1Interface")

public class Service1Imp implements Service1Interface {

	private final static String PATH = "Service1Interface.xml";

	public AcademicStaffMembers getAcademicStaffMembers(JAXBContext jAXBContext) throws JAXBException, IOException {
		AcademicStaffMembers staffMembers = new AcademicStaffMembers();
		
		if( ! new java.io.File( PATH ).exists() ) {
			new java.io.File( PATH ).createNewFile();
			staffMembers = new AcademicStaffMembers();
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			staffMembers = (AcademicStaffMembers) unmarshaller.unmarshal( inputStream );
		}
		
		return staffMembers;
	}
	
	public void saveAcademicStaffMembers(AcademicStaffMembers staffMembers, JAXBContext jAXBContext) throws JAXBException, IOException {
		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( staffMembers, outputStream );
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	public AcademicStaffMember getAcademicStaffMemberAtId(int id) throws JAXBException, IOException {
		AcademicStaffMember staffMember = new AcademicStaffMember();
		
		JAXBContext jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );

		AcademicStaffMembers staffMembers = getAcademicStaffMembers(jAXBContext);
		
		AcademicStaffMember[] staffMemberArray = staffMembers.getAcademicStaffMemberArray();
		if(staffMemberArray[id] == null) {
			staffMember.setId(-1);
		} 
		else {
			staffMember = staffMemberArray[id];
		}
		
		return staffMember;
	}
	
	public void addAcademicStaffMember(AcademicStaffMember staffMember, int id) throws JAXBException, IOException {		
		JAXBContext jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );

		AcademicStaffMembers staffMembers = getAcademicStaffMembers(jAXBContext);
		
		AcademicStaffMember[] staffMemberArray = staffMembers.getAcademicStaffMemberArray();
		staffMemberArray[id] = staffMember;
		staffMembers.setAcademicStaffMemberArray(staffMemberArray);

		saveAcademicStaffMembers(staffMembers,jAXBContext);
	}
	
	public Module1 getModule1(String moduleCode, String acdYear, int id) throws JAXBException, IOException {
		Module1 module = new Module1();
		module.setAcademicYear("");
		
		AcademicStaffMember staffMember = getAcademicStaffMemberAtId(id);
		
		Module1[] modules = staffMember.getModuleArray();
		
		for(int i=0; i<modules.length; i++) {
			if(modules[i] != null ) {
				if(modules[i].getAcademicYear().equals(acdYear) && modules[i].getModuleCode() == ModuleCode1.valueOf(moduleCode)) {
					module = modules[i];
					break;
				}
			}
		}
		return module;
	}
	
	public void addModule1(int id, String moduleCode, String ay) throws JAXBException, IOException {
		AcademicStaffMember staffMember = getAcademicStaffMemberAtId(id);
		
		ModuleCode1 mc = ModuleCode1.valueOf(moduleCode);
		Module1 module = new Module1();
		module.setModuleCode(mc);
		module.setAcademicYear(ay);
		
		Module1[] modules = staffMember.getModuleArray();
		
		for(int i=0; i<modules.length; i++) {
			if(modules[i] == null) {
				modules[i] = module;
				break;
			}
			else if(modules[i].getAcademicYear().equals(ay) && modules[i].getModuleCode() == ModuleCode1.valueOf(moduleCode)) {
				modules[i] = module;
			}
		}
		
		addAcademicStaffMember(staffMember, id);
	}
	
	public boolean checkIfIdHasACDRole(int id) throws JAXBException, IOException {
		AcademicStaffMember staffMember = getAcademicStaffMemberAtId(id);
		
		if(staffMember.getId() == -1) {
			return false;
		}
		else {
			return true;
		}
	}
}
