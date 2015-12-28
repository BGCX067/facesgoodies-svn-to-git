package at.irian.jsf.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import at.irian.jsf.domain.Registration;
import at.irian.jsf.domain.Person;

import java.util.List;
import java.util.Date;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
    protected EntityManager _em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        _em = em;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Registration registration) {
        if (registration.getId() == null)
            registration.setRegistrationDate(new Date());
        _em.persist(registration);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Registration registration) {
        registration = _em.merge(registration);
        _em.remove(registration);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Registration getById(Long id) {
        return _em.find(Registration.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Registration> getAllRegistrations() {
        Query query = _em.createNativeQuery("select * from registration", Registration.class);
        return query.getResultList();
    }
}
