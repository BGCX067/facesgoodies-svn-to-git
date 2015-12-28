package at.irian.jsf.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street;
    private String zip;
    private String city;
    @OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL, mappedBy = "registration")
    private List<Person> persons;

    @Enumerated(value = EnumType.STRING)
    private CreditCardType creditCardType;
    private String creditCardNumber;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Person> getPersons() {
        if (persons == null)
            persons = new ArrayList<Person>(5);
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
