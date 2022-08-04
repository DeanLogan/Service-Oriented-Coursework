package package2;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBException;

import package1.Module1;


@WebService
@SOAPBinding(style=Style.RPC)
public interface Service2Interface {
	
	//for Controller class
	@WebMethod
	public @WebResult(name = "registrationOfEndUser") void registrationOfEndUser(@WebParam(name="registrationOfEndUserId")int id, @WebParam(name="registrationOfEndUserRole") String role) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "enrollStudentOnModule") int enrollStudentOnModule(@WebParam(name="enrollStudentOnModuleAsmId")int asmId, @WebParam(name="enrollStudentOnModuleStudentId") int studentId, @WebParam(name="enrollStudentOnModuleStudentMc") String moduleCode, @WebParam(name="enrollStudentOnModuleStudentAy") String ay)throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "insertNewMark") int insertNewMark(@WebParam(name="insertNewMarkAsmId")int asmId, @WebParam(name="insertNewMarkMark") double mark, @WebParam(name="insertNewMarkStudentId") int studentId, @WebParam(name="insertNewMarkModuleCode") String moduleCode, @WebParam(name="insertNewMarkMarkAcdYear") String acdYear)throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "reportingMarkForStudent") String reportingMarkForStudent(@WebParam(name="reportingMarkForStudentAsmId")int asmId, @WebParam(name="reportingMarkForStudentStudentId")int idOfStudent, @WebParam(name="reportingMarkForStudentModuleCode")String moduleCode, @WebParam(name="reportingMarkForStudentAcdYear") String acdYear)throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "assignModuleToStaffMember") int assignModuleToStaffMember(@WebParam(name="assignModuleToStaffMemberId")int id, @WebParam(name="assignModuleToStaffMemberModuleCode")String moduleCode, @WebParam(name="assignModuleToStaffMemberAsmId")int asmId, @WebParam(name="assignModuleToStaffMemberAcdYear") String acdYear)throws JAXBException, IOException;
}

