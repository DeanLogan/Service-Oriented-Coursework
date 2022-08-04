package package1;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@WebService
@SOAPBinding(style=Style.RPC)
public interface Service1Interface {
	
	@WebMethod
	public @WebResult(name = "getAcademicStaffMembers") AcademicStaffMembers getAcademicStaffMembers(@WebParam(name="getAcademicStaffMembersJaxb")JAXBContext jAXBContext) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "saveAcademicStaffMembers") void saveAcademicStaffMembers(@WebParam(name="saveAcademicStaffMembersAcademicStaffMembers")AcademicStaffMembers staffMembers, @WebParam(name="saveAcademicStaffMembersJaxb")JAXBContext jAXBContext) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "getAcademicStaffMemberAtId") AcademicStaffMember getAcademicStaffMemberAtId(@WebParam(name="getAcademicStaffMemberAtIdId")int id) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "addAcademicStaffMember") void addAcademicStaffMember(@WebParam(name="addAcademicStaffMemberAcademicStaffMember")AcademicStaffMember staffMember, @WebParam(name="addAcademicStaffMemberId")int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "getModule1") Module1 getModule1(@WebParam(name="getModule1Module1Code")String moduleCode, @WebParam(name="getModule1AcdYear")String acdYear, @WebParam(name="getModule1Id")int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "addModule1") void addModule1(@WebParam(name="addModule1Id")int id, @WebParam(name="addModule1ModuleCode")String moduleCode, @WebParam(name="addModule1Ay")String ay) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "checkIfIdHasACDRole") boolean checkIfIdHasACDRole(@WebParam(name="checkIfIdHasACDRole") int id) throws JAXBException, IOException;
}
