package com.bugtracker.actuator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.bugtracker.entity.Ticket;
import com.bugtracker.service.BugTrackerService;

@Component
public class TicketStatus implements InfoContributor {

    @Autowired
    private BugTrackerService database;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, List<Ticket>> tktStatusMap=new HashMap<>();
        tktStatusMap.put("active",database.getTickets());
        builder.withDetail("userStatus",tktStatusMap);
    }
}
