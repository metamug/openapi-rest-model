//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.19 at 07:00:32 PM IST 
//
package com.metamug.parser.schema;

import com.metamug.parser.schema.xrequest.*;
import com.metamug.parser.exception.ResourceTestException;
import com.metamug.parser.service.ParserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.text.StringEscapeUtils;
import org.xml.sax.SAXException;

/**
 * For making external request to 3rd party APIs
 *
 *
 * <p>
 * Java class for xrequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="xrequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Param" type="{http://xml.metamug.net/resource/1.0}xparam" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Header" type="{http://xml.metamug.net/resource/1.0}xheader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Body" type="{http://xml.metamug.net/resource/1.0}xbody" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" use="required" type="{http://xml.metamug.net/resource/1.0}id" />
 *       &lt;attribute name="when" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="method" use="required" type="{http://xml.metamug.net/resource/1.0}method" />
 *       &lt;attribute name="verbose" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="persist" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xrequest", propOrder = {
        "xrequestChildren"
})
public class Xrequest extends InvocableElement {

    @XmlElements({
        @XmlElement(name = "Param", type = Xparam.class),
        @XmlElement(name = "Header", type = Xheader.class),
        @XmlElement(name = "Body", type = Xbody.class)
    })
    protected List<XrequestChild> xrequestChildren;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "when")
    protected String when;
    @XmlAttribute(name = "url", required = true)
    protected String url;
    @XmlAttribute(name = "method", required = true)
    protected Method method;
    @XmlAttribute(name = "output")
    protected XrequestOutput output;
    @XmlAttribute(name = "classname")
    protected String className;

    /**
     * Gets the value of the paramOrHeaderOrBody property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there is
     * not a <CODE>set</CODE> method for the paramOrHeaderOrBody property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamOrHeaderOrBody().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Xparam }
     * {@link Header }
     * {@link String }
     *
     * @return
     */
    public List<XrequestChild> getXRequestChildren() {
        if (xrequestChildren == null) {
            xrequestChildren = new ArrayList<>();
        }
        return this.xrequestChildren;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the when property.
     *
     * @return possible object is {@link String }
     */
    public String getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     *
     * @param value allowed object is {@link String }
     */
    public void setWhen(String value) {
        this.when = value;
    }

    /**
     * Gets the value of the url property.
     *
     * @return possible object is {@link String }
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value allowed object is {@link String }
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the method property.
     *
     * @return possible object is {@link Method }
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     *
     * @param value allowed object is {@link Method }
     */
    public void setMethod(Method value) {
        this.method = value;
    }

    /**
     * Gets the value of the output property.
     *
     * @return possible object is {@link XrequestOutput}.
     */
    public XrequestOutput getOutput() {
        return output;
    }

    /**
     * Sets the value of the verbose property.
     *
     * @param output allowed object is {@link XrequestOutput}
     */
    public void setOutput(XrequestOutput output) {
        this.output = output;
    }

    /**
     * Gets the value of the className property.
     *
     * @return possible object is {@link String }
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     *
     * @param value allowed object is {@link String }
     */
    public void setClassName(String value) {
        this.className = value;
    }

    @Override
    public void print(XMLStreamWriter writer, ParserService parent) throws XMLStreamException, IOException, XPathExpressionException, ResourceTestException, SAXException {
        this.parent = parent;
        //Xrequest xrequest = (Xrequest)this;
        parent.elementIds.put(getId(), this);

        if (getWhen() != null) {
            writer.writeStartElement("c:if");
            //String testString = getQuotedString(xrequest.getWhen());
            //writer.writeAttribute("test", enclose(testString.replace("$", "mtgReq.params")));
            String test = transformVariables(getWhen(), parent.elementIds, false);
            writeUnescapedData(" test=\"" + enclose(StringEscapeUtils.unescapeXml(test)) + "\"", parent.output);
        }

        //print xrequest mason tags
        writer.writeCharacters(System.lineSeparator());
        writer.writeStartElement("m:xrequest");
        writer.writeAttribute("var", getId());
        writer.writeAttribute("method", getMethod().name());
        if (getOutput() != null) {
            String outputVal = getOutput().value();
            if (outputVal.equals("headers")) {
                writer.writeAttribute("outputHeaders", "true");
                writer.writeAttribute("output", "true");
            } else if (outputVal.equals("true")) {
                writer.writeAttribute("output", "true");
            }
        }

        if (getClassName() != null) {
            writer.writeAttribute("className", getClassName());
        }

        String url = transformVariables(getUrl(),parent.elementIds,true);        
        writeUnescapedData(" url=\"" + StringEscapeUtils.unescapeXml(url) + "\"", parent.output);

        for (XrequestChild child : getXRequestChildren()) {
            child.print(writer, parent);
        }

        writer.writeEndElement(); //End of <m:xrequest>    
        writer.writeCharacters(System.lineSeparator());

        if (getWhen() != null) {
            writer.writeEndElement(); //End of <c:if>
        }
    }

    @Override
    public Set<String> getRequestParameters() {
        Set<String> p1 = new HashSet<>();
        getXRequestChildren().forEach((child) -> {
            p1.addAll(child.getRequestParameters());
        });
        return p1;
    }

    @Override
    public String extractFromMPath(String mpathVariable, String elementId, boolean enclose) {

        StringBuilder sb = new StringBuilder();

        // m:jsonPath('$.body.args.foo1',bus['id'])
        String locator = getMPathLocator(mpathVariable);

        //String transformedVariable = "m:jsonPath('$" + locator + "'," + elementId + ")";

        String transformedVariable = elementId+locator;
        
        sb.append(transformedVariable);

        return enclose ? enclose(sb.toString()) : sb.toString();
    }
}