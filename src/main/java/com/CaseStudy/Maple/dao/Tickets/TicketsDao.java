package com.CaseStudy.Maple.dao.Tickets;

import com.CaseStudy.Maple.model.Tickets.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean saveTicket(Tickets tickets, int loginID, String username) {

        String query = "insert into tickets (ticketID, subject, content, statusID, priorityID, userID, agentID, categoryID, createdAt, settingID, loginID) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println("the loginID is: " + loginID);
        System.out.println("loginId from login class is: " + loginID);

        if (0 != jdbcTemplate.update(query, new Object[] {tickets.getCategoryID(), tickets.getSubject(), tickets.getContent(), tickets.getStatusID(), tickets.getPriorityID(),
                 "pending", "yet to resolve...", loginID, username, tickets.getTicketID() })) {
            return true;
        } else {
            return false;
        }
    }




}
