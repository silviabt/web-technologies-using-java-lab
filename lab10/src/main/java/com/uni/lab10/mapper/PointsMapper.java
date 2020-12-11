package com.uni.lab10.mapper;

import com.uni.lab10.domain.Points;
import com.uni.lab10.dto.PointsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointsMapper {

    PointsDto mapToDto(Points points);
}
