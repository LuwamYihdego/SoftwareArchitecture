package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

	@Autowired
	RestOperations restTemplate;

	private String serverUrl = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		restTemplate.postForLocation(serverUrl, new Book("B12", "Tnsae", "Hiwet", 32.0));
		restTemplate.postForLocation(serverUrl, new Book("T22", "Brhane", "Nabra", 22.0));


		System.out.println("Books with isbn B12-----------------");
		Book book = restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "B12");
		System.out.println(book.toString());


		System.out.println("All books-----------------");
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		for (Book thebook : books.getBooks()) {
			System.out.println(thebook.toString());
		}


		Book book2 = restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "T22");
		System.out.println("----------- get Brhane-----------------------");
		System.out.println(book.getIsbn()+" "+ book.getAuthor());


		restTemplate.delete(serverUrl+"/{isbn}", "T22");


		book.setTitle("Software Architecture Pattern");
		restTemplate.put(serverUrl, book, book.getIsbn());


		books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books.toString());
	}


	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
