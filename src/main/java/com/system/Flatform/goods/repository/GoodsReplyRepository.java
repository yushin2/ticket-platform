package com.system.Flatform.goods.repository;

import com.system.Flatform.goods.domain.GoodsReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsReplyRepository extends JpaRepository<GoodsReply, Long>, GoodsReplyRepositoryCustom {

}
