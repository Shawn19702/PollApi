package quickpoll.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quickpoll.poll.domain.OptionCount;
import quickpoll.poll.domain.Poll;
import quickpoll.poll.domain.Vote;
import quickpoll.poll.domain.VoteResult;
import quickpoll.poll.repository.VoteRepository;
import quickpoll.poll.service.ComputeResultService;
import quickpoll.poll.service.VoteService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {

    @Autowired
    private ComputeResultService computeResultService;

   @Autowired
   private VoteRepository voteRepository;


    @RequestMapping(value="/computeresult", method=RequestMethod.GET)
    public ResponseEntity<?> getTotalVotes(Long id) {
       return computeResultService.computeResult(id);
    }




    }



