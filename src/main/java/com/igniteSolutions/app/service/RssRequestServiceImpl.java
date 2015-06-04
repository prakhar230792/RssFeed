package com.igniteSolutions.app.service;

import java.net.URL;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
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
		// http://www.lifehack.org/feed
		// http://feeds.bbci.co.uk/news/rss.xml
		//http://feeds.feedburner.com/GoogleEarthBlog
		//http://feeds.feedburner.com/QuickOnlineTips
		//http://www.forbes.com/europe_news/index.xml
		//http://www.wired.com/category/photo/feed/
		//http://www.wired.com/category/reviews/feed/
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
            	String feedtitle= "No title available";
            	String feedDecsription= "No description available";
            	String feedMedia= "";
            	String altMedia= "/resources/images/noimage.png";
                Node n = items.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element e = (Element) n;
 
                // get the "title elem" in this item (only one)
                
                NodeList titleList = 
                                e.getElementsByTagName("title");
                
                	Element titleElem = (Element) titleList.item(0);
                if(titleElem != null)
                {
                    Node titleNode = titleElem.getChildNodes().item(0);
                    if(titleNode != null)
                    {
                    	feedtitle = titleNode.getNodeValue();
                    }
                }

                NodeList descriptionList =  e.getElementsByTagName("description");
                	Element descElem = (Element) descriptionList.item(0);
                if(descElem != null)
                {
                    Node descNode = descElem.getChildNodes().item(0);
                    if(descNode!= null)
                    {
                    	feedDecsription = descNode.getNodeValue();
                    }
                }
                
                NodeList mediaList =  e.getElementsByTagName("media:thumbnail");
                int count = 0;
                Element mediaElem = (Element) mediaList.item(count);
                System.out.print(mediaList);
                while(mediaElem != null)
                {
                	feedMedia = mediaElem.getAttribute("url");
                	count++;
                	mediaElem = (Element) mediaList.item(count);
                }
                html = html + "<div class=\"col-sm-6 col-md-4\">"+
                "<div class=\"thumbnail\">"+
                "<img src=\"" + feedMedia +"\" alt=\"\" style=\"max-height: 100px; max-width: 100px;\" />"+
                "<div class=\"caption\">"+
                  "<h3>" + feedtitle + "</h3>" + 
                  "<p>" + feedDecsription + "</p>"+
                "</div>"+
             " </div>"+
            "</div>";
                
                
            }
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println(html);
        return new Feed(html);
	}

}
