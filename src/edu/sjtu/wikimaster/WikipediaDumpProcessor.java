package edu.sjtu.wikimaster;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WikipediaDumpProcessor {

	private String dumpPath = "./data/test.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WikipediaDumpProcessor wikiParser = new WikipediaDumpProcessor();
		wikiParser.parse();
	}
	
	public void format(File file){
		
	}
	
	public void parse(){
		long start = System.currentTimeMillis();
		// System.out.println(wikiTagMap.get(3607476));
		try {
			SAXParserFactory.newInstance().newSAXParser()
					.parse(new File(dumpPath), new WikipediaParser());
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("解析详情完成！耗时" + (end - start) + "ms");
	}
}
