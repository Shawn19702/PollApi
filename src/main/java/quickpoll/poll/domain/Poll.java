package quickpoll.poll.domain;

import javax.persistence.*;
import java.util.Set;

public class Poll {
    @Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    private String question;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<Option> options;

//    public Poll(Long id, String question, Set<OptionA> options) {
//        this.id = id;
//        this.question = question;
//        this.options = options;
//    }

    public Poll() {
    }


    // now lets create sets and gets


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {

        this.options = options;
    }
    //we may need a to-string method as well


    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
