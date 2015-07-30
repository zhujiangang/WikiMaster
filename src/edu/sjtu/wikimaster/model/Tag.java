package edu.sjtu.wikimaster.model;

public class Tag implements Comparable<Tag>{
	private String text;
	
	private String url;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Tag(String text, String url) {
		super();
		this.text = text;
		this.url = url;
	}
	@Override
	public int compareTo(Tag o) {
		// TODO Auto-generated method stub
		return this.url.compareTo(o.url);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Tag o = (Tag)obj;
		return this.text.equals(o.text) && this.url.equals(o.url);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.text;
	}
	
	public Tag(){
		
	}
}
