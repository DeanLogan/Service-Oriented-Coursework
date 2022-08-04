
package package3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for module complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="module">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="academicYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mark" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="moduleCode" type="{http://package3/}moduleCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "module", propOrder = {
    "academicYear",
    "mark",
    "moduleCode"
})
public class Module {

    protected String academicYear;
    protected double mark;
    protected ModuleCode moduleCode;

    /**
     * Gets the value of the academicYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the value of the academicYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcademicYear(String value) {
        this.academicYear = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     */
    public double getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     */
    public void setMark(double value) {
        this.mark = value;
    }

    /**
     * Gets the value of the moduleCode property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleCode }
     *     
     */
    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the value of the moduleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleCode }
     *     
     */
    public void setModuleCode(ModuleCode value) {
        this.moduleCode = value;
    }

}
