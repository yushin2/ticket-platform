package com.system.Flatform.goods.service.impl;

import com.system.Flatform.goods.domain.Goods;
import com.system.Flatform.goods.domain.GoodsReply;
import com.system.Flatform.goods.dto.*;
import com.system.Flatform.goods.record.GoodsCreateDTO;
import com.system.Flatform.goods.record.GoodsUpdateDTO;
import com.system.Flatform.goods.repository.GoodsReplyRepository;
import com.system.Flatform.goods.repository.GoodsRepository;
import com.system.Flatform.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.system.Flatform.utils.Constants.*;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsReplyRepository goodsReplyRepository;


    /**
     * 공연 등록(저장)
     * @param goodsCreateDTO
     */
    @Transactional
    @Override
    public void createGoods(GoodsCreateDTO goodsCreateDTO) {
        goodsRepository.save(goodsCreateDTO.toEntity());
    }

    /**
     * 공연 수정
     * @param goodsUpdateDTO
     */
    @Transactional
    @Override
    public void updateGoods(GoodsUpdateDTO goodsUpdateDTO) {
        Goods goods = goodsRepository.findById(goodsUpdateDTO.goodsId()).orElseThrow(()
                -> new IllegalArgumentException(NO_GOODS_INFO_MSG));
        goods.ticketUpdate(goodsUpdateDTO);
    }

    /**
     * 공연 삭제
     * @param ticketIds
     */
    @Transactional
    @Override
    public void deleteGoods(List<Long> ticketIds) {
        goodsRepository.deleteTickets(ticketIds);
    }

    /**
     * 공연 목록 조회
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<GoodsListDTO> goodsList(Pageable pageable, String ticketName, String address) {
        return goodsRepository.ticketList(pageable, ticketName, address);
    }

    /**
     * 공연 상세 조회
     * @param ticketId
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public GoodsDetailDTO goodsDetail(Long ticketId) {
        return goodsRepository.ticketDetail(ticketId);
    }

    /**
     * 공연 답글 등록(저장)
     * @param goodsReplyCreateDTO
     */
    @Transactional
    @Override
    public void createGoodsReply(GoodsReplyCreateDTO goodsReplyCreateDTO) {
        Goods goods = goodsRepository.findById(goodsReplyCreateDTO.getTicketId()).orElseThrow(()
                -> new IllegalArgumentException(NO_GOODS_INFO_MSG));
        GoodsReply savedGoodsReply = goodsReplyRepository.save(goodsReplyCreateDTO.toEntity(goods));
        savedGoodsReply.setReplyParentId((goods.getGoodsReplyList().size() == 0) ?
                savedGoodsReply.getGoodsReplyId() :
                goods.getGoodsReplyList().get(goods.getGoodsReplyList().size()-1).getGoodsReplyId());
    }

    /**
     * 공연 답글 수정
     * @param goodsReplyUpdateDTO
     */
    @Transactional
    @Override
    public void updateGoodsReply(GoodsReplyUpdateDTO goodsReplyUpdateDTO) {
        GoodsReply goodsReply = goodsReplyRepository.findById(goodsReplyUpdateDTO.getTicketReplyId()).orElseThrow(()
                -> new IllegalArgumentException(NO_GOODS_REPLY_MSG));
        goodsReply.updateReplyContent(goodsReplyUpdateDTO);
    }

    /**
     * 공연 답글 삭제
     * @param ticketReplyIds
     */
    @Transactional
    @Override
    public void deleteGoodsReply(List<Long> ticketReplyIds) {
        goodsReplyRepository.deleteTicketReply(ticketReplyIds);
    }

}
