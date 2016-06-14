//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.30 at 02:11:34 오후 KST 
//


package org.openflamingo.model.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for actionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.openflamingo.org/schema/workflow}nodeType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.openflamingo.org/schema/workflow}mapreduce" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.openflamingo.org/schema/workflow}pig" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.openflamingo.org/schema/workflow}hive" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.openflamingo.org/schema/workflow}java" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.openflamingo.org/schema/workflow}shell" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionType", propOrder = {
    "mapreduce",
    "pig",
    "hive",
    "java",
    "shell"
})
public class ActionType
    extends NodeType
{

    protected List<Mapreduce> mapreduce;
    protected List<Pig> pig;
    protected List<Hive> hive;
    protected List<Java> java;
    protected List<Shell> shell;

    /**
     * Gets the value of the mapreduce property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapreduce property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapreduce().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mapreduce }
     * 
     * 
     */
    public List<Mapreduce> getMapreduce() {
        if (mapreduce == null) {
            mapreduce = new ArrayList<Mapreduce>();
        }
        return this.mapreduce;
    }

    /**
     * Gets the value of the pig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pig }
     * 
     * 
     */
    public List<Pig> getPig() {
        if (pig == null) {
            pig = new ArrayList<Pig>();
        }
        return this.pig;
    }

    /**
     * Gets the value of the hive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHive().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hive }
     * 
     * 
     */
    public List<Hive> getHive() {
        if (hive == null) {
            hive = new ArrayList<Hive>();
        }
        return this.hive;
    }

    /**
     * Gets the value of the java property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the java property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJava().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Java }
     * 
     * 
     */
    public List<Java> getJava() {
        if (java == null) {
            java = new ArrayList<Java>();
        }
        return this.java;
    }

    /**
     * Gets the value of the shell property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shell property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShell().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shell }
     * 
     * 
     */
    public List<Shell> getShell() {
        if (shell == null) {
            shell = new ArrayList<Shell>();
        }
        return this.shell;
    }

}
