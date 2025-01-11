package com.textcodesharer.text_code_sharer.document;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DocumentRepositoryTest {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Test
	public void DocumentRepository_Save_ReturnSavedDocument() {
		// Arrange
		Document document = Document.builder()
				.title("Some cryto tips")
				.category("Cryptocurrency")
				.content("Here are some crypto tips...").build();
		System.out.println("test document : " + document);
		
		// Act
		Document savedDocument = documentRepository.save(document);
		
		// Assert
		Assertions.assertThat(savedDocument).isNotNull();
		Assertions.assertThat(savedDocument.getId()).isGreaterThan(0);
	}
	
	@Test
	public void DocumentRepository_FindAll_ReturnMoreThanOneDocument() {
		// Arrange
		Document document1 = Document.builder()
				.title("Some crypto tips")
				.category("Cryptocurrency")
				.content("Here are some crypto tips...").build();

		Document document2 = Document.builder()
				.title("Another crypto tip")
				.category("Cryptocurrency")
				.content("A continuation of crypto tips...").build();
		
		documentRepository.save(document1);
		documentRepository.save(document2);
		
		// Act
		List<Document> documentList = documentRepository.findAll();
		
		// Assert
		Assertions.assertThat(documentList).isNotNull();
		Assertions.assertThat(documentList.size()).isEqualTo(2);
	}

	@Test
	public void DocumentRepository_FindById_ReturnDocument() {
		// Arrange
		Document document = Document.builder()
				.title("Some crypto tips")
				.category("Cryptocurrency")
				.content("Here are some crypto tips...").build();

		
		documentRepository.save(document);
		
		// Act
		Document foundDocument = documentRepository.findById(document.getId()).get();
		
		// Assert
		Assertions.assertThat(foundDocument).isNotNull();
	}
	
	@Test
	public void DocumentRepository_FindByCategory_ReturnDocumentNotNull() {
		// Arrange
		Document document = Document.builder()
				.title("Some crypto tips")
				.category("Cryptocurrency")
				.content("These are some current crypto tips...").build();
		
		documentRepository.save(document);
		
		// Act
		Optional<Document> foundDocument = documentRepository.findByCategory("Cryptocurrency");

		
		// Assert
		Assertions.assertThat(foundDocument).isNotNull();
	}
	
	@Test
	public void DocumentRepository_UpdateDocument_ReturnDocumentNotNull() {
		// Arrange
		Document document = Document.builder()
				.title("Some crypto tips")
				.category("Cryptocurrency")
				.content("Here are some crypto tips for you...").build();
		
		Document documentSave = documentRepository.save(document);

		// Act
		documentSave.setTitle("Now we talk about gaming");
		documentSave.setCategory("Gaming");
		documentSave.setContent("Some gaming tips for you right now...");
		Document updatedDocument = documentRepository.findById(documentSave.getId()).get();
		
		// Assert
		Assertions.assertThat(updatedDocument).isNotNull();		
	}

	@Test
	public void DocumentRepository_DeleteDocument_ReturnDocumentIsEmpty() {
		// Arrange
		Document document = Document.builder()
				.title("Some crypto tips")
				.category("Cryptocurrency")
				.content("Here are some crypto tips for you...").build();
		
		Document documentSave = documentRepository.save(document);

		// Act
		documentRepository.deleteById(documentSave.getId());
		Optional<Document> documentReturn = documentRepository.findById(documentSave.getId());
		
		// Assert
		Assertions.assertThat(documentReturn).isEmpty();
	}
}
