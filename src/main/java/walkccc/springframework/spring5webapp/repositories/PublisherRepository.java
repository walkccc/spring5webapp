package walkccc.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import walkccc.springframework.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
