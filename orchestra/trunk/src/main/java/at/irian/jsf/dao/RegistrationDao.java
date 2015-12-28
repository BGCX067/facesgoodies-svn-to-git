package at.irian.jsf.dao;

import at.irian.jsf.domain.Registration;

import java.util.List;

public interface RegistrationDao {
    public void remove(Registration registration);
    public void save(Registration registration);
    public Registration getById(Long id);
    public List<Registration> getAllRegistrations();
}
