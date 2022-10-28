package quickpoll.poll.domain;

import javax.persistence.*;



@Entity
//@Table(name = "polls", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "vote_id"
//        }),
//        @UniqueConstraint(columnNames = {
//                "QUESTION"
//        })
//})

    public class  Option {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="OPTION_ID")
        private Long id;
        @Column(name="OPTION_VALUE")
        private String value;
        // Getters and Setters omitted for brevity'


        public Option() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Option{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

