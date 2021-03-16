package com.CaseStudy.Maple.service.RegisterAndLogin;

import com.CaseStudy.Maple.dao.RegisterAndLogin.UserDaoImpl;
import com.CaseStudy.Maple.model.RegisterAndLogin.Login;
import com.CaseStudy.Maple.model.registerandlogin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationAndLoginService {

    @Autowired
    private UserDaoImpl userdaoimpl;

    public void setUserdaoimpl(UserDaoImpl userdaoimpl) {
        this.userdaoimpl = userdaoimpl;
    }

    public String saveUser(User user) {
        if (userdaoimpl.saveUser(user) != null) {
            return user.getUserType();
        } else {
            return null;
        }
    }

    public String returnUserType(Login login) {
        User user = new User();

        login.setUserType(user.getUserType());
        return login.getUserType();
    }

    public String verifyUser(Login login) {
        if (userdaoimpl.verifyUser(login) != null) {
            return userdaoimpl.verifyUser(login);
        } else {
            return null;
        }
    }

    public List<String> retrieveStates() {
        return userdaoimpl.retrieveStates();
    }

    public List<String> retrieveUserType() {
        return userdaoimpl.retrieveUserType();
    }
}
