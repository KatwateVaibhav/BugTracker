package com.bugtracker.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TICKET")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketNumber;
	private String projectName;
	private String createdBy;
    private String summary;
    private String status;
    private String assignedTo;
    private String rootCause;
    //
    private String priority;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp startDate;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp endDate;
    
    
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp creationDate;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp updationDate;
    

}
