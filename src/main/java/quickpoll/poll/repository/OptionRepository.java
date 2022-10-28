package quickpoll.poll.repository;

import org.springframework.data.repository.NoRepositoryBean;
import quickpoll.poll.domain.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface OptionRepository extends CrudRepository<Option, Long> {
}
