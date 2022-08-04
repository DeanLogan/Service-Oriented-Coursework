
package package1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for academicStaffMembers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="academicStaffMembers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="academicStaffMemberArray" type="{http://package1/}academicStaffMember" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "academicStaffMembers", propOrder = {
    "academicStaffMemberArray"
})
public class AcademicStaffMembers {

    @XmlElement(nillable = true)
    protected List<AcademicStaffMember> academicStaffMemberArray;

    /**
     * Gets the value of the academicStaffMemberArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the academicStaffMemberArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcademicStaffMemberArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcademicStaffMember }
     * 
     * 
     */
    public List<AcademicStaffMember> getAcademicStaffMemberArray() {
        if (academicStaffMemberArray == null) {
            academicStaffMemberArray = new ArrayList<AcademicStaffMember>();
        }
        return this.academicStaffMemberArray;
    }

}
