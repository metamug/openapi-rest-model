//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.07 at 10:53:17 AM IST 
//
package com.metamug.jaxb.gener;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for request complex type.
 *
 * <p>
*/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request", propOrder = {
    "desc",
    "execute",
    "sql"
})
@XmlSeeAlso({
    Create.class,
    Read.class,
    Update.class,
    Delete.class
})
public class Request {

    protected String desc;
    protected List<Execute> execute;
    
    @XmlElement(name = "Sql", required = true)
    protected List<Sql> sql;
    
    @XmlAttribute(name = "method")
    protected Method method;
    
    @XmlAttribute(name = "id")
    protected Long id;
    
    public Request() {

    }

    public Request(Method method) {
        this.method = method;
    }
    
    public List<Execute> getExecute() {
        if (execute == null) {
            execute = new ArrayList<Execute>();
        }
        return this.execute;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {
        this.desc = value;
    }
 
    public List<Sql> getSql() {
        if (sql == null) {
            sql = new ArrayList<Sql>();
        }
        return this.sql;
    }

    /**
     * Gets the value of the method property.
     *
     * @return possible object is {@link Method }
     *
     */
    public Method getMethod() {
        if (method == null) {
            return Method.GET;
        } else {
            return method;
        }
    }

    /**
     * Sets the value of the method property.
     *
     * @param value allowed object is {@link Method }
     *
     */
    public void setMethod(Method value) {
        this.method = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link Long }
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }

}
