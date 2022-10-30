package quickpoll.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import quickpoll.poll.domain.Poll;
import quickpoll.poll.domain.Vote;
import quickpoll.poll.repository.PollRepository;
import quickpoll.poll.repository.VoteRepository;
import quickpoll.poll.service.VoteService;

@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
    return voteService.createVote(pollId, vote);
    }


    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteService.getAllVotes(pollId);
    }

}