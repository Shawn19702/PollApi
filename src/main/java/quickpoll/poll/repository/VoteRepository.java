package quickpoll.poll.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import quickpoll.poll.domain.Vote;;

@Repository


public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query(value="select v.* from Options o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    Iterable<Vote> findByPoll(Long pollId);

}
