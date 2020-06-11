package walkccc.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import walkccc.springframework.spring5webapp.domain.Author;
import walkccc.springframework.spring5webapp.domain.Book;
import walkccc.springframework.spring5webapp.domain.Publisher;
import walkccc.springframework.spring5webapp.repositories.AuthorRepository;
import walkccc.springframework.spring5webapp.repositories.BookRepository;
import walkccc.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Started in BootStrap");

    Publisher publisher = new Publisher();
    publisher.setName("Moso");
    publisher.setCity("Taipei");
    publisher.setState("TW");

    publisherRepository.save(publisher);

    Author jay = new Author("Jay", "Chen");
    Book clrs = new Book("CLRS", "123");
    jay.getBooks().add(clrs);
    clrs.getAuthors().add(jay);

    clrs.setPublisher(publisher);
    publisher.getBooks().add(clrs);

    authorRepository.save(jay);
    bookRepository.save(clrs);
    publisherRepository.save(publisher);

    Author roc = new Author("Roc", "Chen");
    Book fluidBook = new Book("Fluid Book", "456");
    roc.getBooks().add(fluidBook);
    fluidBook.getAuthors().add(roc);

    fluidBook.setPublisher(publisher);
    publisher.getBooks().add(fluidBook);

    authorRepository.save(roc);
    bookRepository.save(fluidBook);
    publisherRepository.save(publisher);

    System.out.println("# of Authors: " + authorRepository.count());
    System.out.println("# of Books: " + bookRepository.count());
    System.out.println("# of Publishers: " + publisherRepository.count());
    System.out.println("# of Books in publisher: " + publisher.getBooks().size());
  }
}
