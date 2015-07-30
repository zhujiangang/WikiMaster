package edu.sjtu.wikimaster.model;

import java.util.Set;

public class Article implements Comparable<Article>{
	private String id;
	private String url;
	private String title;
	private String abst;
	private String content;
	private Infobox infobox;
	private Set<Category> categories;
	private Set<Tag> tags;
	private Set<Link> outlinks;
	private Set<Article> inlinks;

	private Namespace namespace;
	private String redirect;
	private Revision revision;
	
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbst() {
		return abst;
	}
	public void setAbst(String abst) {
		this.abst = abst;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Infobox getInfobox() {
		return infobox;
	}
	public void setInfobox(Infobox infobox) {
		this.infobox = infobox;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Set<Link> getOutlinks() {
		return outlinks;
	}
	public void setOutlinks(Set<Link> outlinks) {
		this.outlinks = outlinks;
	}
	public Set<Article> getInlinks() {
		return inlinks;
	}
	public void setInlinks(Set<Article> inlinks) {
		this.inlinks = inlinks;
	}
	
	
	public Namespace getNamespace() {
		return namespace;
	}
	public void setNamespace(Namespace namespace) {
		this.namespace = namespace;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public Revision getRevision() {
		return revision;
	}
	public void setRevision(Revision revision) {
		this.revision = revision;
	}
	@Override
	public int compareTo(Article o) {
		// TODO Auto-generated method stub
		return this.url.compareTo(o.url);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Article a = (Article)obj;
		return a.url.equals(a.url);
	}
}
