package com.uni.Lab7.mapper;

import com.uni.Lab7.domain.Food;
import com.uni.Lab7.dto.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mappings({
            @Mapping(target = "description", source = "foodDto.information")
    })
    Food toEntity(FoodDto foodDto);

    @Mappings({
            @Mapping(target = "information", source = "food.description")
    })
    FoodDto toDto(Food food);
}
