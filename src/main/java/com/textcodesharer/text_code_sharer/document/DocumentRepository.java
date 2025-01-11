package com.textcodesharer.text_code_sharer.document;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	Optional<Document> findByCategory(String category);
}
