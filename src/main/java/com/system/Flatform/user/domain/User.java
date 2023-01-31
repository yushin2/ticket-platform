package com.system.Flatform.user.domain;

import com.system.Flatform.utils.BaseEntity;
import com.system.Flatform.utils.enums.AgeToWatch;
import com.system.Flatform.utils.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 회원 entity
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", columnDefinition = "VARCHAR(100) COMMENT '사용자 이메일'")
    private String userEmail;

    @Column(name = "password", columnDefinition = "VARCHAR(100) COMMENT '비밀번호'")
    private String password;

    @Column(name = "username", columnDefinition = "VARCHAR(20) COMMENT '사용자명'")
    private String username;

    @Column(name = "user_phone", columnDefinition = "VARCHAR(50) COMMENT '연락처'")
    private String userPhone;

    @Column(name = "birth_date", columnDefinition = "DATE COMMENT '생년월일'")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "VARCHAR(2) COMMENT '성별'")
    private Gender gender;

    @Column(name = "address", columnDefinition = "VARCHAR(50) COMMENT '주소'")
    private String address;

    @Column(name = "auth_token", columnDefinition = "VARCHAR(50) COMMENT '인증토큰'")
    private String authToken;

    @Column(name = "auth_status", columnDefinition = "INT(20) COMMENT '인증상태'")
    private int authStatus;

    @Column(name = "expired_dt", columnDefinition = "DATETIME COMMENT '만료 시간'")
    private LocalDateTime expiredDt;

    @Column(name = "generated_dt", columnDefinition = "DATETIME COMMENT '발행 시간'")
    private LocalDateTime generatedDt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @Builder

    public User(Long userId, String userEmail, String password, String username, String userPhone,
                LocalDate birthDate, Gender gender, String address, String authToken, int authStatus,
                LocalDateTime expiredDt, LocalDateTime generatedDt, List<Role> roles) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.username = username;
        this.userPhone = userPhone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.authToken = authToken;
        this.authStatus = authStatus;
        this.expiredDt = expiredDt;
        this.generatedDt = generatedDt;
        this.roles = roles;
    }
}
