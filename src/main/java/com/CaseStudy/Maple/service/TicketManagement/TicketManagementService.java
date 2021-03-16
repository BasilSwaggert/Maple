package com.CaseStudy.Maple.service.TicketManagement;


import com.CaseStudy.Maple.dao.TicketsManagement.TicketsManagementDao;
import com.CaseStudy.Maple.model.Tickets.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketManagementService {

    @Autowired
    TicketsManagementDao tMD;

    public List<Tickets> retrieveApprovedTickets() {

        List<Tickets> tickets = tMD.retrieveTicketsData();

        List<Tickets> approvedTickets = new ArrayList<Tickets>();
            for (Tickets approved : tickets) {
                if ("approved".equals(approved.getStat())) {
                    approvedTickets.add(approved);
                }
            }
            return approvedTickets;
    }
    public List<Tickets> retrievePendingTickets() {

        List<Tickets> tickets = tMD.retrieveTicketsData();

        List<Tickets> pendingTickets = new ArrayList<Tickets>();
            for (Tickets pending : tickets) {
                if ("pending".equals(pending.getStat())) {
                    pendingTickets.add(pending);
                }
            }
            return pendingTickets;
    }

    public List<Tickets> retrieveRejectedTickets() {

        List<Tickets> tickets = tMD.retrieveTicketsData();

        List<Tickets> rejectedTickets = new ArrayList<Tickets>();
            for (Tickets rejected : tickets) {
                if ("rejected".equals(rejected.getStat())) {
                    rejectedTickets.add(rejected);
                }
            }
            return rejectedTickets;
    }
}
