package com.igniteSolutions.app.service;

import java.net.URL;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.igniteSolutions.app.model.Feed;
@Service
public class RssRequestServiceImpl implements RssRequestService{


	@Override
	public Feed helloWorld() {
		return new Feed("google.com");
	}

	@Override
	public Feed fetchData(String map) {
		String feedURL = (map.split("="))[1];
		Document doc = null;
		String html = "";
		try {
			DocumentBuilderFactory f = 
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            doc = b.parse(feedURL);
 
            doc.getDocumentElement().normalize();
            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++)
            {
                Node n = items.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element e = (Element) n;
 
                // get the "title elem" in this item (only one)
                NodeList titleList = 
                                e.getElementsByTagName("title");
                Element titleElem = (Element) titleList.item(0);
 
                // get the "text node" in the title (only one)
                Node titleNode = titleElem.getChildNodes().item(0);
                titleList =  e.getElementsByTagName("description");
                titleElem = (Element) titleList.item(0);
                Node descNode = titleElem.getChildNodes().item(0);
                html = html + "<div class=\"col-sm-6 col-md-4\">"+
                "<div class=\"thumbnail\">"+
                "<img src=\"...\" alt=\"...\">"+
                "<div class=\"caption\">"+
                  "<h3>" + titleNode.getNodeValue() + "</h3>" + 
                  "<p>" + descNode.getNodeValue() + "</p>"+
                  "<p><a href=\"#\" class=\"btn btn-primary\" role=\"button\">Button</a> <a href=\"#\" class=\"btn btn-default\" role=\"button\">Button</a></p>"+
                "</div>"+
             " </div>"+
            "</div>";
                
                System.out.println(titleNode.getNodeValue());
                System.out.println(descNode.getNodeValue());
                
            }
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println(html);
        return new Feed(html);
	}

}
