package at.irian.jsf.model;

import at.irian.jsf.domain.Registration;
import at.irian.jsf.dao.RegistrationDao;

import java.util.List;

public class RegistrationListBean {
    private RegistrationDao _registrationDao;
    private List<Registration> _list;

    public void setRegistrationDao(RegistrationDao registrationDao) {
        _registrationDao = registrationDao;
    }

    public List<Registration> getAllRegistrations() {
        if (_list == null) {
            _list = _registrationDao.getAllRegistrations();
        }
        return _list;
    }
}
