package edu.sjtu.wikimaster.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Infobox {
	
	private Map<AttributeKey,AttributeValue> infobox;

	public Infobox(Map<AttributeKey, AttributeValue> infobox) {
		super();
		this.infobox = infobox;
	}

	public Infobox() {
		infobox = new HashMap<AttributeKey, AttributeValue>();
	}

	public Map<AttributeKey, AttributeValue> getInfobox() {
		return infobox;
	}

	public void setInfobox(Map<AttributeKey, AttributeValue> infobox) {
		this.infobox = infobox;
	}
	
	public void add(AttributeKey key,AttributeValue value){
		infobox.put(key, value);
	}
	
	public void add(String key,String value){
		AttributeKey aKey = new AttributeKey(key);
		AttributeValue aValue = new AttributeValue(value);
		add(aKey,aValue);
	}
	
	public void add(String key,String value,Set<Link> outlinks){
		AttributeKey aKey = new AttributeKey(key);
		AttributeValue aValue = new AttributeValue(value,outlinks);
		add(aKey,aValue);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<AttributeKey, AttributeValue> entry : infobox.entrySet()){
			sb.append(entry.getKey().getKey()).append(":").append(entry.getValue().getValue()).append(":").append(entry.getValue().getOutlinks()).append("\n");
		}
		return sb.toString();
	}
	
}
