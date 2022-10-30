package quickpoll.poll.domain;

import java.util.Collection;

public class VoteResult {
    private int totalvalues;

    private Collection<OptionCount> results;

    public int getTotalvalues() {
        return totalvalues;
    }

    public void setTotalvalues(int totalvalues) {
        this.totalvalues = totalvalues;
    }

    public Collection<OptionCount> getResults() {
        return results;
    }

    public void setResults(Collection<OptionCount> results) {
        this.results = results;
    }

    public VoteResult() {
    }

    @Override
    public String toString() {
        return "VoteResult{" +
                "totalvalues=" + totalvalues +
                ", results=" + results +
                '}';
    }
}
