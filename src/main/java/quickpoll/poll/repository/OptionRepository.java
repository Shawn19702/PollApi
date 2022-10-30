package quickpoll.poll.repository;

import quickpoll.poll.domain.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface OptionRepository extends CrudRepository<Options, Long> {
}
