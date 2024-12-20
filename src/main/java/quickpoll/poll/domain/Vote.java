package quickpoll.poll.domain;


import javax.persistence.*;



@Entity
public class Vote{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Options option;

    public Vote() {
    }

//    public Vote(Long id, Options option) {
//        this.id = id;
//        this.option = option;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", option=" + option +
                '}';
    }
}
