package com.system.Flatform.goods.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.Flatform.goods.repository.GoodsReplyRepositoryCustom;
import com.system.Flatform.utils.enums.DelYn;
import com.system.Flatform.utils.enums.UseYn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.system.Flatform.goods.domain.QTicketReply.ticketReply;

@Repository
@RequiredArgsConstructor
public class GoodsReplyRepositoryImpl implements GoodsReplyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     * 티켓 답글 삭제
     * @param ticketReplyIds
     */
    @Transactional
    @Override
    public void deleteTicketReply(List<Long> ticketReplyIds) {
        queryFactory.update(ticketReply)
                .set(ticketReply.useYn, UseYn.N)
                .set(ticketReply.delYn, DelYn.Y)
                .where(ticketReply.ticketReplyId.in(ticketReplyIds)).execute();
    }
}
