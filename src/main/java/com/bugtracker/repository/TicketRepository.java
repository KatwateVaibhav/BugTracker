package com.bugtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracker.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
	
	public List<Ticket> findByStatusNot(String status);
}
