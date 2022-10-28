package quickpoll.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quickpoll.poll.domain.Poll;
import quickpoll.poll.repository.PollRepository;

//@Service
public class PollService {

   @Autowired
   private PollRepository pollRepository;
//
   public ResponseEntity<Iterable<Poll>> getAllStudents(){
      return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

}

