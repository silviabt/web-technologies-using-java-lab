package com.unibuc.lab11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointsDto {

    private Long id;

    private String username;

    private Integer noPoints;

    private LocalDateTime pointsAddedDate;
}
