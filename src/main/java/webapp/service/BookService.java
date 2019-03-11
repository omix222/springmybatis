package webapp.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import webapp.controller.entity.Book;
import webapp.repository.BookRepository;

@Service
public class BookService {

//	@Value("http://localhost:8081/api/books")
//	public URI webRestApiProviderUrl;

	@Autowired
	BookRepository bookRepository;

	public List<Book>getBooks() {
//		RestTemplate restTemplate = new RestTemplate();
//		Book[] book = restTemplate.getForObject(webRestApiProviderUrl, Book[].class);
//		List<Book> books = Arrays.asList(book);
//		Book book = new Book();
//		book.setAuthor("aa");
//		book.setId("1");
//		book.setPublisher("publisher");
//		book.setStatus("rentaled");
//		book.setTitle("エンタープライズアプリケーションアーキテクチャパターン");
//		book.setTags("Java");
//		List<Book> books = Arrays.asList(book);

		List<Book> books = bookRepository.findAll();
		return books;
	}

	public Book postBook(Book book) {
//		RestTemplate restTemplate = new RestTemplate();
//		Book resultBook =restTemplate.postForObject(webRestApiProviderUrl, book, Book.class);
//		if (resultBook == null ) {
//			throw new RuntimeException("resultBook is null!!!");
//		}
		bookRepository.save(book);
		Book resultBook = bookRepository.findById(book.getId()).get();
		return resultBook;
	}
}
