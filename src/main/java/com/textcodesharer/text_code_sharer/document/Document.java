package com.textcodesharer.text_code_sharer.document;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Document {
	
	private @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	private String title;
	
	@Column(nullable=false)
	private String content;
	private String category;
	private String expiration;
	private String exposure;
	private String[] tags;
	private String password;
	private boolean isGuest; 
	

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", expiration=" + expiration + ", exposure=" + exposure + ", tags=" + Arrays.toString(tags)
				+ ", isGuest=" + isGuest + "]";
	}
}
