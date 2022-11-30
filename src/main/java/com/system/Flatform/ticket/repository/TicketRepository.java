package com.system.Flatform.ticket.repository;

import com.system.Flatform.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>, TicketRepositoryCustom {

}
