package at.irian.jsf.model;

import at.irian.jsf.dao.RegistrationDao;
import at.irian.jsf.dao.PersonDao;
import at.irian.jsf.domain.CreditCardType;
import at.irian.jsf.domain.Registration;
import at.irian.jsf.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.apache.myfaces.orchestra.conversation.Conversation;
import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;
import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.annotations.ConversationRequire;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;
import org.apache.myfaces.orchestra.viewController.annotations.InitView;
import org.apache.myfaces.orchestra.viewController.annotations.PreRenderView;
import org.apache.myfaces.orchestra.viewController.annotations.PreProcess;

import javax.faces.context.FacesContext;

@ConversationRequire(conversationNames = "registration",
        entryPointViewIds = {"/registration.xhtml"},
    redirect="/index.xhtml")
@ViewController(
	viewIds={"/registration.xhtml","/person.xhtml","/complete.xhtml"})
public class RegistrationBean implements ConversationBindingListener {
    private RegistrationDao _registrationDao;
    private PersonDao _personDao;
    private Registration _registration;
    private Person _person;
    private List<Person> _deleted = new ArrayList<Person>(5);

    private Long _registrationId;
    private boolean _initRegistration;

    public void valueBound(ConversationBindingEvent event) {
        System.out.println("value unbound");
    }

    public void valueUnbound(ConversationBindingEvent event) {
        System.out.println("value bound");
    }

    @InitView
    public void init() {
        System.out.println("init");
    }
    @PreProcess
    public void preProcess() {
        System.out.println("preProcess");
    }
    @PreRenderView
    public void preRenderView() {
        System.out.println("preRenderView");
    }

    public void setRegistrationDao(RegistrationDao registrationDao) {
        _registrationDao = registrationDao;
    }

    public void setPersonDao(PersonDao personDao) {
        _personDao = personDao;
    }

    public void setRegistrationId(Long registrationId) {
        _registrationId = registrationId;
        _initRegistration = true;
    }

    public List<CreditCardType> getCreditCardSelectItems() {
        return Arrays.asList(CreditCardType.values());
    }

    public Registration getRegistration() {
        if (_initRegistration) {
            _initRegistration = false;
            _registration = _registrationDao.getById(_registrationId);
        }
        if (_registration == null) {
            _registration = new Registration();
        }
        return _registration;
    }

    public Person getPerson() {
        if (_person == null)
            _person = new Person();
        return _person;
    }

    public void setPerson(Person person) {
        _person = person;
    }

    public boolean isRegistrationComplete() {
        return _registration != null && _registration.getPersons() != null && _registration.getPersons().size() > 0;
    }

    public String save() {
        if (_registration != null) {
            _registrationDao.save(_registration);
        }
        for (Person person : _deleted) {
            _personDao.remove(person);
        }
        _deleted.clear();
        Conversation.getCurrentInstance().invalidate();
        //return "end";
        return "index";
    }

    public String cancel() {
        _registration = null;
        Conversation.getCurrentInstance().invalidate();
        return "index";
    }

    public String addPerson() {
        _person.setRegistration(_registration);
        if (_person != null && !_registration.getPersons().contains(_person))
            _registration.getPersons().add(_person);
        _person = null;
        return null;
    }

    public String removePerson() {
        if (_person != null) {
            _registration.getPersons().remove(_person);
            if (_person.getId() != null)
                _deleted.add(_person);
        }
        _person = null;
        return null;
    }
}
