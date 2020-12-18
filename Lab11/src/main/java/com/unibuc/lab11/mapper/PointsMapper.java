package com.unibuc.lab11.mapper;

import com.unibuc.lab11.domain.Points;
import com.unibuc.lab11.dto.PointsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointsMapper {

    PointsDto mapToDto(Points points);
}
