package edu.sjtu.wikimaster.model;

public class Contributor {
	private String name;
	private String id;
	private String ip;
	private boolean isAnonymous;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isAnonymous() {
		return isAnonymous;
	}
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public Contributor(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.isAnonymous = false;
	}
	public Contributor(String ip) {
		super();
		this.ip = ip;
		this.isAnonymous = true;
	}
}
