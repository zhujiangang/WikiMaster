package edu.sjtu.wikimaster.model;

import java.util.HashSet;
import java.util.Set;

public class Category implements Comparable<Category>{
	private static int idAvail = 0;
	private int id;
	private String name;
	private String url;
	private Category father;
	private Category root;
	private Set<Category> children;
	private int height;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Category(){
		
	}
	
	public Category(String name,String url){
		this.id = idAvail++;
		this.name = name;
		this.url = url;
	}
	public Category(String url, String name, Category father)
	{
		this.id = idAvail++;
		this.url = url;
		this.name = name;
		this.father = father;
		//this.root = father.root;
		if(father != null){
			father.addChild(this);
			height = father.height+1;
			root = father.root;
		}else{
			height = 1;
			root = this;
		}
		children = new HashSet<Category>();
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Category getFather()
	{
		return father;
	}

	public void setFather(Category father)
	{
		this.father = father;
	}

	public Category getRoot() {
		return root;
	}

	public void setRoot(Category root) {
		this.root = root;
	}
	
	public void addChild(Category category)
	{
		category.father = this;
		children.add(category);
	}
	
	public void deleteChild(Category category){
		category.father = null;
		children.remove(category);
	}
	public Set<Category> getChildren() {
		return children;
	}

	public void setChildren(Set<Category> children) {
		this.children = children;
	}
	
	@Override
	public int compareTo(Category o) {
		// TODO Auto-generated method stub
		return this.url.compareTo(o.url);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Category o = (Category)obj;
		return this.name.equals(o.name) && this.url.equals(o.url);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
