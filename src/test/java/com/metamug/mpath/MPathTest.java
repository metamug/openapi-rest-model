/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metamug.mpath;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author anishhirlekar
 */
public class MPathTest {
    public static final String TEST_JSON = "{\n" +
      "   \"Port\":\n" +
      "   {\n" +
      "       \"alias\": \"defaultHttp\",\n" +
      "       \"Enabled\": \"true\",\n" +
      "       \"Number\": \"10092\",\n" +
      "       \"Protocol\": \"http\",\n" +
      "       \"KeepAliveTimeout\": \"20000\",\n" +
      "       \"ThreadPool\":\n" +
      "       {\n" +
      "           \"enabled\": \"false\",\n" +
      "           \"Max\": \"150\",\n" +
      "           \"ThreadPriority\": \"5\"\n" +
      "       },\n" +
      "       \"ExtendedProperties\":\n" +
      "       {\n" +
      "           \"Property\":\n" +
      "           [                         \n" +
      "               {\n" +
      "                   \"name\": \"connectionTimeout\",\n" +
      "                   \"D\": 20000\n" +
      "               },\n" +
      "               {\n" +
      "                   \"name\": \"connectionTimeout_Again!\",\n" +
      "                   \"D\": \"60000\"\n" +
      "               }\n" +      
      "           ]\n" +
      "       }\n" +
      "   }\n" +
      "}";
    
    public static final String TEST_XML = "<Resource version=\"1.1\" >\n" +
            "\n" +
            "	<Desc>Contains records for data type apple</Desc>\n" +
            "\n" +
            "	<Request method=\"GET\" item=\"true\" status=\"200\">\n" +
            "		<Param name=\"t\" blank=\"true\" min=\"1\" exists=\"table.column\" />\n" +
            "                \n" +
            "                <Sql when=\"@q eq 1\" type=\"query\">\n" +
            "                    select * from employee where employee_name = @v\n" +
            "                </Sql>\n" +
            "                <Sql when=\"@q eq 3\" type=\"update\">\n" +
            "                    <content>update employee set employee_name = @param2 where employee_id=@id\n" +
            "                </content></Sql>\n" +
            "	</Request>\n" +
            "	       \n" +
            "	<Request method=\"POST\" status=\"201\">\n" +
            "		<Desc>Request for creating an employee record.</Desc>\n" +
            "		<Sql type=\"update\">\n" +
            "		insert into employee \n" +
            "		(employee_name, employee_id) \n" +
            "		values(@name, @id)\n" +
            "		</Sql>\n" +
            "\n" +
            "	</Request>\n" +
            "\n" +
            "	<!--derived from request -->\n" +
            "	<Request method=\"PUT\" item=\"true\">\n" +
            "		<Execute className=\"com.mtg.Apple\" />\n" +
            "	</Request>\n" +
            "	\n" +
            "</Resource>\n" +
            "";
    
    public static final String TEST_XML2 = "<Resource version=\"1.1\" >\n" +
            "\n" +
            "	<Desc>Contains records for data type apple</Desc>\n" +
            "\n" +
            "	<Request method=\"GET\" item=\"true\" status=\"200\">\n" +
            "		<Param name=\"t\" blank=\"true\" min=\"1\" exists=\"table.column\" />\n" +
            "                \n" +
            "                <Sql when=\"@q eq 1\" type=\"query\">\n" +
            "                    select * from employee where employee_name = @v\n" +
            "                </Sql>\n" +
            "                <Sql when=\"@q eq 3\" type=\"update\">\n" +
            "                    <content>update employee set employee_name = @param2 where employee_id=@id\n" +
            "                </content>Illegal Content</Sql>\n" +
            "	</Request>\n" +
            "	       \n" +
            "	</Resource>";
    
    @Test
    public void TestCase1() throws XPathExpressionException, IOException,
                                    SAXException, ParserConfigurationException{
        
        String equivalentXml = XML.toString(new JSONObject(TEST_JSON));
        String mKey1 = "Port.ExtendedProperties.Property[0].D";
        String mKey2 = "Port.ExtendedProperties.Property[1].D";
        String mKey3 = "Port.ThreadPool.Max";
        Object jsonVal1 = MPathUtil.getValueFromJson(TEST_JSON, mKey1);
        Object jsonVal2 = MPathUtil.getValueFromJson(TEST_JSON, mKey2);
        Object jsonVal3 = MPathUtil.getValueFromJson(TEST_JSON, mKey3);
        /*System.out.println("json 1: "+jsonVal1);
        System.out.println("json 2: "+jsonVal2);
        System.out.println("JSON Val 3: "+jsonVal3);
        */
        Object xmlVal1 = MPathUtil.getValueFromXml(equivalentXml, mKey1);
        Object xmlVal2 = MPathUtil.getValueFromXml(equivalentXml, mKey2);
        Object xmlVal3 = MPathUtil.getValueFromXml(equivalentXml, mKey3);
        /*
        System.out.println("x1: "+xmlVal1);
        System.out.println("x2: "+xmlVal2);
        System.out.println("x Val 3: "+xmlVal3);
        */
        Assert.assertArrayEquals(new String[]{jsonVal1.toString(),jsonVal2.toString(),jsonVal3.toString()},
                        new Object[]{xmlVal1.toString(),xmlVal2.toString(),xmlVal3.toString()});
        
    }
    
    @Test
    public void TestCase2() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException{
        String equivalentJson = (XML.toJSONObject(TEST_XML)).toString();
        String mKey1 = "Resource.Request[0].method";
        String mKey2Xml = "Resource.Request[1].Sql";
        String mKey2Json = "Resource.Request[1].Sql.content";
        String mKey3 = "Resource.Request[0].Sql[1].content";
        String mKey4 = "Resource.Desc";
        String mKey5 = "Resource.version";
        //System.out.println(TEST_XML);
        String xmlVal1 = (MPathUtil.getValueFromXml(TEST_XML, mKey1)).toString();
        String xmlVal2 = (MPathUtil.getValueFromXml(TEST_XML, mKey2Xml)).toString();
        String jsonVal1 = (MPathUtil.getValueFromJson(equivalentJson, mKey1)).toString();
        String jsonVal2 = (MPathUtil.getValueFromJson(equivalentJson, mKey2Json)).toString();
        String xmlVal3 = (MPathUtil.getValueFromXml(TEST_XML, mKey3)).toString();
        String jsonVal3 = (MPathUtil.getValueFromJson(equivalentJson, mKey3)).toString();
        String xmlVal4 = (MPathUtil.getValueFromXml(TEST_XML, mKey4)).toString();
        String jsonVal4 = (MPathUtil.getValueFromJson(equivalentJson, mKey4)).toString();
        String xmlVal5 = (MPathUtil.getValueFromXml(TEST_XML, mKey5)).toString();
        String jsonVal5 = (MPathUtil.getValueFromJson(equivalentJson, mKey5)).toString();
        
        Assert.assertArrayEquals(new String[]{xmlVal1,xmlVal2,xmlVal3,xmlVal4,xmlVal5},
                        new String[]{jsonVal1,jsonVal2,jsonVal3,jsonVal4,jsonVal5});
    }
    
    @Test
    public void FailCase1() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException{
        //System.out.println(TEST_XML2);
        String mKey1 = "Resource.Request.Sql[1]";
        Assert.assertNull(MPathUtil.getValueFromXml(TEST_XML2, mKey1));
    }
    
    @Test
    public void FailCase2() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException{
        String garbageMKey = "ChangeMeToTestGarbageValues";
        Assert.assertNull(MPathUtil.getValueFromXml(TEST_XML, garbageMKey));
    }
}
