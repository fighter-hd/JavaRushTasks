package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String resultXml = null;

        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setCoalescing(true);
//            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            marshaller.marshal(obj, document);

//            Document document = builder.parse(new File("C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests\\XmlTest2.xml"));

            NodeList ourTags = document.getElementsByTagName("*");

            for (int i = 0; i < ourTags.getLength(); i++) {
                Node node = ourTags.item(i);

                if (node.getNodeName().equalsIgnoreCase(tagName)) {
                    node.getParentNode().insertBefore(document.createComment(comment), node);
                }

                replaceTextWithCDATA(node, document);
            }

            resultXml = getStringFromDocument(document);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultXml;
    }

    private static void replaceTextWithCDATA(Node node, Document document) {
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {

            Node cdataSection = document.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cdataSection, node);
        }

        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            replaceTextWithCDATA(list.item(i), document);
        }
    }

    private static String getStringFromDocument(Document document) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            DOMSource domSource = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(domSource, result);
            return writer.toString();

        } catch(TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 6;
        cat.weight = 4;

        System.out.println(toXmlWithComment(cat,"age", "it's a comment"));
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        Cat() {}
    }
}
