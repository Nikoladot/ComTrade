package com.example.comtrade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "HELLO")
public class Hello {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column
	private String language;
	@Column
	private String content;
	
	public Hello() {
		
	}
	

	public Hello(String language, String content) {

		this.language = language;
		this.content = content;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Hello [language=" + language + ", content=" + content + "]";
	}
	
	

}
