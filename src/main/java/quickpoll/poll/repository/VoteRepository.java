package quickpoll.poll.repository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import quickpoll.poll.domain.Vote;;

@Repository


public interface VoteRepository extends CrudRepository<Vote, Long> {
}
