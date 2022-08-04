package package3;

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
public interface Service3Interface {
	
	@WebMethod
	public @WebResult(name = "getStudents") Students getStudents(@WebParam(name="getStudentsJaxb")JAXBContext jAXBContext) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "saveStudents") void saveStudents(@WebParam(name="saveStudentsStudents")Students students, @WebParam(name="saveStudentsJaxb")JAXBContext jAXBContext) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "getStudentAtId") Student getStudentAtId(@WebParam(name="getStudentAtIdId")int id) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "addStudent") void addStudent(@WebParam(name="addStudentStudent")Student student, @WebParam(name="addStudentId")int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "getModule") Module getModule(@WebParam(name="getModuleModuleCode")String moduleCode, @WebParam(name="getModuleAcdYear")String acdYear, @WebParam(name="getModuleId")int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "addModule") void addModule(@WebParam(name="addModuleId")int id, @WebParam(name="addModuleModuleCode")String moduleCode, @WebParam(name="addModuleAy")String ay) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "checkIfIdHasStudentRole") boolean checkIfIdHasStudentRole(@WebParam(name="checkIfIdHasStudentRoleId") int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "newMark") boolean newMark(@WebParam(name="newMarkId")int id, @WebParam(name="newMarkMc")String moduleCode, @WebParam(name="newMarkay")String ay, @WebParam(name="newMarkMark")double mark) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "reportMark") String reportMark(@WebParam(name="reportMarkId")int id, @WebParam(name="reportMarkModuleCode")String moduleCode, @WebParam(name="reportMarkAy")String ay) throws JAXBException, IOException;
	
}