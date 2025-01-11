package com.textcodesharer.text_code_sharer.document;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
	private DocumentRepository repository;
	
	DocumentServiceImpl(DocumentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Document> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Document findById(long id) {
		return repository.findById(id).orElseThrow(() -> new DocumentNotFoundException(id));
	}
	
	@Override
	public List<Document> findByCategory(String category) {
		return repository.findByCategory(category).orElseThrow(() -> new DocumentNotFoundException("category", category));
	}
	
	@Override
	public Document save(Document newDocument) {
		if (newDocument.getContent() == null) throw new ParameterNotFoundException("content");
		if (newDocument.getTitle() == null) newDocument.setTitle("Untitled");
		System.out.println(newDocument);
		return repository.save(newDocument);
	}
	
	@Override
	public Document update(long id, Document newDocument) {
		return repository.findById(id)
				.map(document -> {
					document.setTitle(newDocument.getTitle());
					document.setCategory(newDocument.getCategory());
					return repository.save(document);
				})
				.orElseGet(() -> {
					return repository.save(newDocument);
				});
	}
	
	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
}
