package com.system.Flatform.utils;


import com.system.Flatform.utils.enums.DelYn;
import com.system.Flatform.utils.enums.UseYn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@MappedSuperclass
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'Y'")
    @Column(name = "use_yn", insertable = false)
    private UseYn useYn;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'N'")
    @Column(name = "del_yn", insertable = false)
    private DelYn delYn;

    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @LastModifiedDate
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;

    @PrePersist
    public void prePersist() {
        this.useYn = this.useYn == null ? UseYn.Y : null;
        this.delYn = this.delYn == null ? DelYn.N : null;
    }

}
