package quickpoll.poll.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import quickpoll.poll.domain.Poll;


@Repository

public interface PollRepository extends CrudRepository<Poll, Long> {

}