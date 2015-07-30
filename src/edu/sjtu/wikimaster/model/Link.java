package edu.sjtu.wikimaster.model;

public class Link implements Comparable<Link>{
	
	public static final int ABSTRACT = 0;
	public static final int INFOBOX = 1;
	public static final int CONTENT = 2;
	
	private String anchorText;
	
	private String target;
	
	//private boolean inAbstract;
	private int pos;
		
	public Link(String anchorText, String target,int pos) {
		super();
		this.anchorText = anchorText;
		this.target = target;
		this.pos = pos;
	}

	public String getAnchorText() {
		return anchorText;
	}

	public void setAnchorText(String anchorText) {
		this.anchorText = anchorText;
	}
	
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public int compareTo(Link o) {
		// TODO Auto-generated method stub
		return this.target.compareTo(o.target);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Link o = (Link)obj;
		return this.anchorText.equals(o.anchorText) && this.target.equals(o.target) && this.pos==o.pos;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append(this.anchorText+":"+this.target+":"+this.pos);
		return sb.toString().hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.anchorText+":"+this.getTarget()+":"+this.pos;
	}

	public Link() {
		super();
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}
