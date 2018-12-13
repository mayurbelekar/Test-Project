package org.elastica;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	
	public String apiListReader(String apiName) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		File file = new File(Constants.API_LIST);
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("api");
		String uri = null;
		for(int i=0; i< nList.getLength(); i++){
			Node node = nList.item(i);
			Element element = (Element) node;
			if(element.getAttribute("name").equals(apiName)){
				uri = element.getAttribute("value");
				break;
			}
		}
		return uri;
	}
}
