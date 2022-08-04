
package package1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the package1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcademicStaffMembers_QNAME = new QName("http://package1/", "academicStaffMembers");
    private final static QName _IOException_QNAME = new QName("http://package1/", "IOException");
    private final static QName _JAXBException_QNAME = new QName("http://package1/", "JAXBException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: package1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBException }
     * 
     */
    public JAXBException createJAXBException() {
        return new JAXBException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link AcademicStaffMembers }
     * 
     */
    public AcademicStaffMembers createAcademicStaffMembers() {
        return new AcademicStaffMembers();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link Module1 }
     * 
     */
    public Module1 createModule1() {
        return new Module1();
    }

    /**
     * Create an instance of {@link AcademicStaffMember }
     * 
     */
    public AcademicStaffMember createAcademicStaffMember() {
        return new AcademicStaffMember();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcademicStaffMembers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://package1/", name = "academicStaffMembers")
    public JAXBElement<AcademicStaffMembers> createAcademicStaffMembers(AcademicStaffMembers value) {
        return new JAXBElement<AcademicStaffMembers>(_AcademicStaffMembers_QNAME, AcademicStaffMembers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://package1/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JAXBException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://package1/", name = "JAXBException")
    public JAXBElement<JAXBException> createJAXBException(JAXBException value) {
        return new JAXBElement<JAXBException>(_JAXBException_QNAME, JAXBException.class, null, value);
    }

}
