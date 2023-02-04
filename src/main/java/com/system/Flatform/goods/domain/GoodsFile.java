package com.system.Flatform.goods.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 굿즈 첨부 파일 도메인
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "goods_file")
public class GoodsFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_file_id")
    private Long goodsFileId;

    @Column(name = "file_name", columnDefinition = "VARCHAR(255) COMMENT '파일명'")
    private String fileName;
    @Column(name = "file_path", columnDefinition = "VARCHAR(255) COMMENT '파일경로'")
    private String filePath;
    @Column(name = "file_size", columnDefinition = "INT(50) COMMENT '파일용량'")
    private int fileSize;
    @Column(name = "file_type", columnDefinition = "VARCHAR(255) COMMENT '파일타입'")
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public GoodsFile(Long goodsFileId, String fileName, String filePath, int fileSize, String fileType, Goods goods) {
        this.goodsFileId = goodsFileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.goods = goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
        goods.getGoodsFileList().add(this);
    }
}
