package quickpoll.poll.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import quickpoll.poll.domain.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quickpoll.poll.repository.PollRepository;

import java.net.URI;

@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;

    private Poll poll;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
//
//    @PostMapping(value = "/polls", method = RequestMethod.POST)
//    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
//        poll = pollRepository.save(poll);
//
//        // Set the location header for the newly created resource
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newPollUri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(poll.getId())
//                .toUri();
//        responseHeaders.setLocation(newPollUri);
//
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);


    }



