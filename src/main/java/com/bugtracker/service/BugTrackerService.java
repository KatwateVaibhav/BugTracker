package com.bugtracker.service;

import java.util.List;

import com.bugtracker.entity.Ticket;

public interface BugTrackerService {

	public Ticket saveTicket(Ticket ticket);

	public Ticket getTicketById(int id);

	public List<Ticket> getTickets() ;

	public Ticket updateTicket(Ticket ticket);

	public String deleteTicket(int id);
}
