package edu.sjtu.wikimaster.model;

public class AttributeKey implements Comparable<AttributeKey>{
	
	private String key;
	
	public AttributeKey(String key){
		this.key = key;
	}

	public AttributeKey() {
		super();
	}

	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	@Override
	public int compareTo(AttributeKey o) {
		// TODO Auto-generated method stub
		return key.compareTo(o.getKey());
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		AttributeKey ak = (AttributeKey)obj;
		return this.key.equals(ak.getKey());
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.key;
	}
	
	
}
