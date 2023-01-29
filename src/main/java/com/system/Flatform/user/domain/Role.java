package com.system.Flatform.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Getter
@Entity
@Table(name = "role")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(100) COMMENT '권한명'")
    private String roleName;

    @Column(name = "role", columnDefinition = "VARCHAR(20) COMMENT '권한'")
    private String role;
}
