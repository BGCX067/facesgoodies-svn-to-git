package at.irian.jsf.dao;

import at.irian.jsf.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    protected EntityManager _em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        _em = em;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Person Person) {
        if (Person.getId() == null) {
            _em.persist(Person);
        } else {
            _em.merge(Person);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Person Person) {
        Person = _em.merge(Person);
        _em.remove(Person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Person getById(Long id) {
        return _em.find(Person.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Person> getAllPersons() {
        Query query = _em.createNativeQuery("select * from Persons", Person.class);
        return query.getResultList();
    }
}
