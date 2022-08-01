package com.example.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashMap;
import java.util.Map;

public class XMLParseTest {
    public static void main(String[] args) throws Exception {
        //dom解析 sax解析
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //文档构建 对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        //得到文档对象 document记录xml中所有得信息
        Document document = builder.parse("D:\\ProductMapper.xml");

        Map<String,String> map = new HashMap<>();

        NodeList list = document.getElementsByTagName("select");
        for (int i = 0; i<list.getLength();i++){
            Node node = list.item(i);
            Element e = (Element) node;
            String id = e.getAttribute("id");
            String sql = e.getTextContent().trim();
            map.put(id,sql);
        }
        NodeList list2 = document.getElementsByTagName("update");
        for (int i = 0; i<list2.getLength();i++){
            Node node = list.item(i);
            Element e = (Element) node;
            String id = e.getAttribute("id");
            String sql = e.getTextContent().trim();
            map.put(id,sql);
        }
        NodeList list3 = document.getElementsByTagName("delete");
        for (int i = 0; i<list3.getLength();i++){
            Node node = list.item(i);
            Element e = (Element) node;
            String id = e.getAttribute("id");
            String sql = e.getTextContent().trim();
            map.put(id,sql);
        }
        NodeList list4 = document.getElementsByTagName("insert");
        for (int i = 0; i<list4.getLength();i++){
            Node node = list.item(i);
            Element e = (Element) node;
            String id = e.getAttribute("id");
            String sql = e.getTextContent().trim();
            map.put(id,sql);
        }
        System.out.println(map);
    }
}
