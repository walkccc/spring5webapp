package walkccc.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import walkccc.springframework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
