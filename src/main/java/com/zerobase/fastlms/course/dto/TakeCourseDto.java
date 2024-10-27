package com.zerobase.fastlms.course.dto;

import com.zerobase.fastlms.course.entity.TakeCourse;
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
public class TakeCourseDto {

    long id;
    long courseId;
    String userId;

    long payPrice;
    String status;

    LocalDateTime regDt;

    String userName;
    String phone;
    String subject;

    long totalCount;
    long seq;

    public static TakeCourseDto of(TakeCourse takeCourseDto) {

        return TakeCourseDto.builder()
                            .id(takeCourseDto.getId())
                            .courseId(takeCourseDto.getCourseId())
                            .userId(takeCourseDto.getUserId())
                            .payPrice(takeCourseDto.getPayPrice())
                            .status(takeCourseDto.getStatus())
                            .regDt(takeCourseDto.getRegDt())
                            .build();
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
