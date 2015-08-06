package edu.sjtu.wikimaster.quick;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.jcommons.file.FileUtils;
import org.xml.sax.SAXException;

public class CommonnessCalculator {

	private String dumpPath = "C:/Research/EL/data/enwiki-20150602-pages-articles.xml";
	//private String dumpPath = "./data/test.xml";
	private File outFile;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonnessCalculator com = new CommonnessCalculator(new File("./data/commonness2"));
		com.compute();
	}
	
	public CommonnessCalculator(File outFile) {
		// TODO Auto-generated constructor stub
		this.outFile = outFile;
	}
	public void compute(){
		long start = System.currentTimeMillis();
		// System.out.println(wikiTagMap.get(3607476));
		try {
			SAXParserFactory.newInstance().newSAXParser()
					.parse(new File(dumpPath), new CommonnessHandler(FileUtils.getBufferedWriter(outFile)));
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("解析详情完成！耗时" + (end - start) + "ms");
	}
}
