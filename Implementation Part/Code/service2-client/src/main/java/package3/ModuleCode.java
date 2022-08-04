
package package3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleCode" type="{http://package3/}moduleCodeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moduleCode", propOrder = {
    "moduleCode"
})
public class ModuleCode {

    protected ModuleCodeEnum moduleCode;

    /**
     * Gets the value of the moduleCode property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleCodeEnum }
     *     
     */
    public ModuleCodeEnum getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the value of the moduleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleCodeEnum }
     *     
     */
    public void setModuleCode(ModuleCodeEnum value) {
        this.moduleCode = value;
    }

}
