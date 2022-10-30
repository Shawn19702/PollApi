package quickpoll.poll.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import quickpoll.poll.domain.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quickpoll.poll.repository.PollRepository;
import quickpoll.poll.service.PollService;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
public class PollController {
    @Autowired
    private PollService pollService;

    @Autowired
    private PollRepository pollRepository;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollService.getAllpolls();
    }


    @RequestMapping(value="/polls", method=RequestMethod.POST)
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }


    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    //    @GetMapping(value = "/{id}")
//    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
//        return ResponseEntity.ok().body(pollService.getSinglePoll(id));
//    }
    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return pollService.updatePoll(poll, pollId);
    }



    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return pollService.deletePoll(pollId);
    }

//    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
//    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
//        // Save the entity
//        Poll p = pollRepository.save(poll);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    }

//      @RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
//      public void updateLocation(@RequestBody Location location, @PathVariable String id) {
//
//         locationService.updateLocation(id, location);

}





