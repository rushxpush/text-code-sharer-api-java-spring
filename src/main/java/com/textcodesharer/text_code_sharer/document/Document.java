package com.textcodesharer.text_code_sharer.document;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Document {
	
	private @Id
	@GeneratedValue Long id;

	private String title;
	private String content;
	private String category;
	private String expiration;
	private String exposure;
	private String[] tags;
	private String password;
	private boolean isGuest; 
	
	Document() {}
	
	Document(String title, String category) {
		this.title = title;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", expiration=" + expiration + ", exposure=" + exposure + ", tags=" + Arrays.toString(tags)
				+ ", isGuest=" + isGuest + "]";
	}
	

}
