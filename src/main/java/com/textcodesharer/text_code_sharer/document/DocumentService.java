package com.textcodesharer.text_code_sharer.document;

import java.util.List;

public interface DocumentService {
	List<Document> findAll();
	
	Document findById(long id);
	
	List<Document> findByCategory(String category);
	
	Document save(Document newDocument);
	
	Document update(long id, Document newDocument);
	
	void delete(long id);
}
