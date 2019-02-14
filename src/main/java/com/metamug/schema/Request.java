//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.01.07 at 10:53:17 AM IST
//
package com.metamug.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request", propOrder = {
    "desc",
    "paramOrSqlOrExecuteOrXrequest",
    "param",
    "execute",
    "sql",
    "xrequest"
})
public class Request {

    @XmlElement(name = "Desc")
    protected String desc;
    @XmlElement(name = "Param")
    protected List<Param> param;
    @XmlElement(name = "Execute")
    protected List<Execute> execute;
    @XmlElement(name = "XRequest")
    protected List<Xrequest> xrequest;

    @XmlElements({
        @XmlElement(name = "Query", type = Query.class)
        ,
        @XmlElement(name = "Update", type = Update.class)
    })
    protected List<Sql> sql;
    @XmlElements({
        @XmlElement(name = "Param", type = Param.class)
        ,
        @XmlElement(name = "Query", type = Query.class)
        ,
        @XmlElement(name = "Update", type = Update.class)
        ,
        @XmlElement(name = "Execute", type = Execute.class)
        ,
        @XmlElement(name = "XRequest", type = Xrequest.class)
    })
    protected List paramOrSqlOrExecuteOrXrequest;

    @XmlAttribute(name = "status")
    protected Integer status;
    @XmlAttribute(name = "method")
    protected Method method;
    @XmlAttribute(name = "item")
    protected Boolean item;

    public Request() {
    }

    public Request(Method method) {
        this.method = method;
    }

    public Set<Param> getParam() {
        if (param == null) {
            Set<Param> paramSet = new HashSet<>();
            return paramSet;
        } else {
            Map<String, Param> paramMap = new HashMap<>();
            param.forEach((Param param1) -> {
                paramMap.put(param1.name, param1);
            });
            Set<Param> paramSet = new HashSet<>();
            paramSet.addAll(paramMap.values());
            return paramSet;
        }
    }

    public List<Execute> getExecute() {
        execute = new ArrayList<>();
        for (Object object : paramOrSqlOrExecuteOrXrequest) {
            if (object instanceof Execute) {
                execute.add((Execute) object);
            }
        }
        return execute;
    }

    public List<Sql> getSql() {
        sql = new ArrayList<>();
        for (Object object : paramOrSqlOrExecuteOrXrequest) {
            if (object instanceof Sql) {
                sql.add((Sql) object);
            }
        }
        return sql;
    }

    public List<Xrequest> getXRequest() {
        xrequest = new ArrayList<>();
        for (Object object : paramOrSqlOrExecuteOrXrequest) {
            if (object instanceof Xrequest) {
                xrequest.add((Xrequest) object);
            }
        }
        return xrequest;
    }

    public List getParamOrSqlOrExecuteOrXrequest() {
        if (paramOrSqlOrExecuteOrXrequest == null) {
            paramOrSqlOrExecuteOrXrequest = new ArrayList<>();
        }
        return this.paramOrSqlOrExecuteOrXrequest;
    }

//    public String getId() {
//        return id;
//    }
//    
//    public void setId(String value) {
//        this.id = value;
//    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {
        this.desc = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer value) {
        this.status = value;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method value) {
        this.method = value;
    }

    public boolean isItem() {
        if (item == null) {
            return false;
        } else {
            return item;
        }
    }

    public void setItem(Boolean value) {
        this.item = value;
    }
}
