package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberDto {

    String userId;
    String userName;
    String phone;
    String password;
    LocalDateTime regDt;
    LocalDateTime udtDt;

    boolean emailAuthYn;
    LocalDateTime emailAuthDt;
    String emailAuthKey;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;
    String userStatus;

    private String zipcode;
    private String address;
    private String addressDetail;

    long totalCount;
    long seq;

    public static MemberDto of(Member member) {

        MemberDto memberDto = MemberDto.builder()
                                       .userId(member.getUserId())
                                       .userName(member.getUserName())
                                       .phone(member.getPhone())
                                       .regDt(member.getRegDt())
                                       .udtDt(member.getUdtDt())
                                       .emailAuthYn(member.isEmailAuthYn())
                                       .emailAuthDt(member.getEmailAuthDt())
                                       .emailAuthKey(member.getEmailAuthKey())
                                       .resetPasswordKey(member.getResetPasswordKey())
                                       .resetPasswordLimitDt(member.getResetPasswordLimitDt())
                                       .adminYn(member.isAdminYn())
                                       .userStatus(member.getUserStatus())
                                       .zipcode(member.getZipcode())
                                       .address(member.getAddress())
                                       .addressDetail(member.getAddressDetail())
                                       .build();

        return memberDto;
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return regDt != null ? regDt.format(formatter) : "";
    }

    public String getUdtDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return udtDt != null ? udtDt.format(formatter) : "";
    }
}
