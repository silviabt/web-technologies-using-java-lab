package com.uni.Lab7.service;

import com.uni.Lab7.domain.Food;
import com.uni.Lab7.dto.FoodDto;
import com.uni.Lab7.mapper.FoodMapper;
import com.uni.Lab7.repository.FoodDaoRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private FoodDaoRepository foodDaoRepository;

    private FoodMapper foodMapper;

    public FoodService(FoodDaoRepository foodDaoRepository, FoodMapper foodMapper) {
        this.foodDaoRepository = foodDaoRepository;
        this.foodMapper = foodMapper;
    }

    public FoodDto save(FoodDto foodDto) {
        // map dto to entity
        Food food = this.foodMapper.toEntity(foodDto);
        // saved entity in database
        Food savedFood = foodDaoRepository.save(food);
        // maped entity back to dto
        FoodDto savedFoodDto = this.foodMapper.toDto(savedFood);
        // return saved dto
        return savedFoodDto;
    }

    public FoodDto get(Long id) {
        Food food = foodDaoRepository.getOne(id);
        return this.foodMapper.toDto(food);
    }

    public boolean remove(Long id) {
        Food food = foodDaoRepository.getOne(id);
        return foodDaoRepository.delete(food);
    }
}
