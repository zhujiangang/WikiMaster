package edu.sjtu.wikimaster.model;

import java.util.Set;

public class AttributeValue {
//	public static final int DATA_TYPE = 0;
//	public static final int OBJECT_TYPE = 1;
	
//	private int type;
	private String value;
	private Set<Link> outlinks;
//	private String url;
//	private Article objectVal;
	
	public AttributeValue(String value) {
		super();
//		this.type = DATA_TYPE;
		this.value = value;
	}

	public AttributeValue() {
		super();
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<Link> getOutlinks() {
		return outlinks;
	}

	public void setOutlinks(Set<Link> outlinks) {
		this.outlinks = outlinks;
	}

	public AttributeValue(String value, Set<Link> outlinks) {
		super();
		this.value = value;
		this.outlinks = outlinks;
	}
}
