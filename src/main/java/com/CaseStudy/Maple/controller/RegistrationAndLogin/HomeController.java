package com.CaseStudy.Maple.controller.RegistrationAndLogin;

import com.CaseStudy.Maple.model.RegisterAndLogin.Login;
import com.CaseStudy.Maple.model.RegisterAndLogin.User;
import com.CaseStudy.Maple.service.RegisterAndLogin.RegistrationAndLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RegistrationAndLoginService r1Service;

    public void setR1Service(RegistrationAndLoginService r1Service) {
        this.r1Service = r1Service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        List<String> userType = r1Service.retrieveUserType();
        List<String> usStates = r1Service.retrieveStates();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("usStates", usStates);
        mav.addObject("userType", userType);
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(User user, Model model) {

        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Login login, Model model, HttpSession session) {
        ModelAndView mav = null;
        String userType = r1Service.verifyUser(login);
        if ("individual".equals(userType) || "enterprise".equals(userType)) {
            session.setAttribute("loginId", login.getLoginId());
            session.setAttribute("username", login.getUsername());
            session.setAttribute("userType", userType);
            String user = (String) session.getAttribute("username");
            System.out.println(user + "at login");
            System.out.println("session iD : " + session.getId());
            System.out.println("Session loginId at controller: " + session.getAttribute("loginId"));
            mav = new ModelAndView("login");
            mav.addObject("message", "welcome " + login.getUsername());

            return mav;

        } else if ("employee".equals(r1Service.verifyUser(login))) {
            session.setAttribute("loginId", login.getLoginId());
            session.setAttribute("username", login.getUsername());
            session.setAttribute("userType", userType);
            String user = (String) session.getAttribute("username");
            System.out.println("Session username at home controller " + user);
            System.out.println("Session loginId at controller: " + session.getAttribute("loginId"));
            mav = new ModelAndView("employeeLogin");
            mav.addObject("message", "welcome " + login.getUsername());

            return mav;

        } else {
            mav = new ModelAndView("error");
            mav.addObject("message", "Please enter valid username and password.");

            return mav;
        }
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        List<String> userType = r1Service.retrieveUserType();
        List<String> usStates = r1Service.retrieveStates();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("usStates", usStates);
        mav.addObject("userType", userType);
        session.invalidate();

        return mav;
    }
}
