package quickpoll.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quickpoll.poll.domain.OptionCount;
import quickpoll.poll.domain.Vote;
import quickpoll.poll.domain.VoteResult;
import quickpoll.poll.repository.PollRepository;
import quickpoll.poll.repository.VoteRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ComputeResultService {

    @Autowired
    private VoteRepository voteRepository;


        public ResponseEntity<?> computeResult(Long pollId) {

            VoteResult voteResult = new VoteResult();
            Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

            int totalVotes = 0;
            Map<Long, OptionCount> tempMap = new HashMap<Long, OptionCount>();

            for (Vote v : allVotes) {

                totalVotes++;

                OptionCount optionCount = tempMap.get(v.getOption().getId());

                if (optionCount == null) {

                    optionCount = new OptionCount();
                    optionCount.setOptionId(v.getOption().getId());
                    tempMap.put(v.getOption().getId(), optionCount);

                }
                optionCount.setCount(optionCount.getCount() + 1);
            }

            voteResult.setTotalvalues(totalVotes);
            voteResult.setResults(tempMap.values());

            return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

        }



    }
