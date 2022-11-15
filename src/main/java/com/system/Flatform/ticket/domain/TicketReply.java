package com.system.Flatform.ticket.domain;

import com.system.Flatform.utils.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 공연 티켓 답글 도메인
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "ticket_reply")
public class TicketReply extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_reply_id")
    private Long ticketReplyId;

    @Column(name = "content", columnDefinition = "VARCHAR(255) COMMENT '답글 내용'")
    private String content;

    @Column(name = "reply_depth", columnDefinition = "INT(8) COMMENT '답글 DEPTH'")
    private int replyDepth;

    @Column(name = "reply_parent_id")
    private Long replyParentId;

    @ManyToOne(targetEntity = Ticket.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        ticket.getTicketReplyList().add(this);
    }

    @Builder
    public TicketReply(Long ticketReplyId, String content, int replyDepth, Long replyParentId, Ticket ticket) {
        this.ticketReplyId = ticketReplyId;
        this.content = content;
        this.replyDepth = replyDepth;
        this.replyParentId = replyParentId;
        this.ticket = ticket;
    }
}
