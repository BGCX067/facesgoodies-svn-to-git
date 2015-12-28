package at.irian.jsf.domain;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "registration_id", nullable = true)
    private Registration registration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
