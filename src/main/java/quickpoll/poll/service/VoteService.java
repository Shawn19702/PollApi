package quickpoll.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import quickpoll.poll.domain.Poll;
import quickpoll.poll.domain.Vote;
import quickpoll.poll.repository.VoteRepository;
@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public ResponseEntity<?> createVote( Long pollId, Vote vote) {
        vote = voteRepository.save(vote);

        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    public Iterable<Vote> getAllVotes(Long pollId) {
        return voteRepository. findByPoll(pollId);


    }



//    public Vote CreateVote(Vote vote) {
//        voteRepository.save(vote);
//        return vote;
    }

