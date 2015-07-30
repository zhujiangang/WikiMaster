package edu.sjtu.wikimaster;

import edu.sjtu.wikimaster.model.Document;

public class Wiki {
	
	private String wikiText;
	
	public Wiki(String wikiText){
		this.wikiText = wikiText;
	}
	
	public static Document parse(String wikiText){
		return null;
	}
	
	public Document parse(){
		return parse(wikiText);
	}
	
	
	public static String wiki2Html(String wikiText){
		return null;
	}
	
	public String wiki2Html(){
		return wiki2Html(wikiText);
	}
	
	public static String html2Wiki(String htmlText){
		return null;
	}
}
