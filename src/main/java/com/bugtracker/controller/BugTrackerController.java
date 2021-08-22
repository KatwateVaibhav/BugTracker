package com.bugtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.entity.Ticket;
import com.bugtracker.service.BugTrackerService;

@RestController
public class BugTrackerController {

    @Autowired
    private BugTrackerService service;

    @PostMapping("/addTicket")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return service.saveTicket(ticket);
    }

    @GetMapping("/ticketById/{id}")
    public Ticket readTicketById(@PathVariable int id) {
        return service.getTicketById(id);
    }

    @GetMapping("/activeTickets")
    public List<Ticket> findAllActiveTickets() {
        return service.getTickets();
    }
  

    @PutMapping("/updateTicketById")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return service.updateTicket(ticket);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable int id) {
        return service.deleteTicket(id);
    }
}
