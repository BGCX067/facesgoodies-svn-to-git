package at.irian.jsf.dao;

import at.irian.jsf.domain.Person;

import java.util.List;

public interface PersonDao {
    public void remove(Person person);
    public void save(Person person);
    public Person getById(Long id);
    public List<Person> getAllPersons();
}
