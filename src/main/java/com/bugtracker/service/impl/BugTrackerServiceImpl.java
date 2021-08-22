package com.bugtracker.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracker.entity.Ticket;
import com.bugtracker.repository.TicketRepository;
import com.bugtracker.service.BugTrackerService;

@Service
public class BugTrackerServiceImpl implements BugTrackerService{
	
	 @Autowired
	 private TicketRepository repository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) {
		 return repository.findById(id).orElse(null);
	}

	@Override
	public List<Ticket> getTickets() {
		return repository.findByStatusNot("Close");
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Ticket existingTicket = repository.findById(ticket.getTicketNumber()).orElse(null);
		Objects.requireNonNull(existingTicket);
		existingTicket.setProjectName(ticket.getProjectName());
		existingTicket.setAssignedTo(ticket.getAssignedTo());
		existingTicket.setSummary(ticket.getSummary());
        existingTicket.setStatus(ticket.getStatus());
        existingTicket.setRootCause(ticket.getRootCause());
        existingTicket.setUpdationDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        return repository.save(existingTicket);
	}

	@Override
	public String deleteTicket(int id) {
		repository.deleteById(id);
        return "product removed !! " + id;
	}
	
}
