package com.CaseStudy.Maple.service.Tickets;

import com.CaseStudy.Maple.dao.Tickets.TicketsDao;
import com.CaseStudy.Maple.model.Tickets.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TicketsService {

    @Autowired
    TicketsDao ticketsDao;

    public boolean saveTicket(Tickets tickets, int loginId, String username) {
        if (ticketsDao.saveTicket(tickets, loginId, username)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Tickets> retrieveTicketsData(int loginId) {
        List<Tickets> tickets = new ArrayList<Tickets>();

        List<Map<String, Object>> ticketsList = ticketsDao.retrieveTicketsData(loginId);
            for (Map<String, Object> map : ticketsList) {

                Tickets ticketsObject = new Tickets();

                ticketsObject.setTicketID((int) map.get("ticketId"));
                ticketsObject.setSubject((String) map.get("subject"));
                ticketsObject.setContent((String) map.get("content"));
                ticketsObject.setStatusID((String) map.get("status"));
                ticketsObject.setPriorityID((String) map.get("priority"));
                ticketsObject.setUserID((String) map.get("userId"));
                ticketsObject.setAgentID((String) map.get("agentID"));
                ticketsObject.setCategoryID((String) map.get("categoryId"));
                ticketsObject.setCreatedAt((String) map.get("createdAt"));
                ticketsObject.setUpdatedAt((String) map.get("updatedAt"));
                ticketsObject.setCompletedAt((String) map.get("completedAt"));
                ticketsObject.setSettingID((String) map.get("settings"));
                ticketsObject.setLoginID((int) map.get("loginId"));

                tickets.add(ticketsObject);
            }
            return tickets;
    }

    public List<String> retrieveCategory() {
        return ticketsDao.retrieveCategory();
    }

    public List<Tickets> retrieveTicketsData() {

        List<Tickets> ticketsList = ticketsDao.retrieveTicketsData();

        return ticketsList;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
