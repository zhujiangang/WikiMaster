package edu.sjtu.wikimaster;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.sjtu.wikimaster.model.Article;

public class WikipediaParser extends DefaultHandler{
	private String preTag;
	private Article article;
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if("page".equals(qName)){  
            article = new Article();
        }
		preTag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch,start,length); 
		if("title".equals(preTag))
			article.setTitle(content);
		else if("id".equals(preTag))
			if(article!=null && article.getId()==null)
				article.setId(content);
		else if("text".equals(preTag)){
			parseContent(article);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if("page".equals(qName)){
			//store
            article = null;  
        } 
		preTag = null;
	}
	
	private void parseContent(Article article){
		
	}
}
