package com.system.Flatform.ticket.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.Flatform.ticket.domain.QTicket;
import com.system.Flatform.ticket.repository.TicketRepositoryCustom;
import com.system.Flatform.utils.enums.DelYn;
import com.system.Flatform.utils.enums.UseYn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.system.Flatform.ticket.domain.QTicket.ticket;

@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    /**
     * 티켓 삭제
     * @param ticketIds
     */
    @Transactional
    @Override
    public void deleteTickets(List<Long> ticketIds) {
        queryFactory.update(ticket)
                .set(ticket.useYn, UseYn.N)
                .set(ticket.delYn, DelYn.Y)
                .where(ticket.ticketId.in(ticketIds)).execute();
    }
}
