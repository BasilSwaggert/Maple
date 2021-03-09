package com.CaseStudy.Maple.controller.Tickets;


import com.CaseStudy.Maple.model.Tickets.Tickets;
import com.CaseStudy.Maple.service.Tickets.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    public void setTicketsService(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @RequestMapping(value = "/createTicket", method = RequestMethod.POST)
    public ModelAndView createTicket(Tickets tickets, Model model, HttpSession session) {

        System.out.println("session iD : " + session.getId());
        System.out.println("session loginId at tickets controller: " + session.getAttribute("loginId"));
        String username = (String)session.getAttribute("username");

        int loginId = (int) session.getAttribute("loginId");

        System.out.println("login id at createTicket : " + loginId);

        ModelAndView mav = null;

        if (ticketsService.saveTicket(tickets, loginId, username)) {
            mav = new ModelAndView("login");
            return mav;
        } else {
            mav = new ModelAndView("login");
            return mav;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/displayTickets")
    public String myTickets(HttpSession session) {
        System.out.println("at displayTickets - my tickets");
        System.out.println(session.getId());
        int loginId = (int)session.getAttribute("loginId");
        System.out.println(loginId + "at mytickets - displaytickets");
        List<Tickets> myTickets = ticketsService.retrieveTicketsData(loginId);
    }
}
