package com.uni.Lab7.controller;

import com.uni.Lab7.domain.Food;
import com.uni.Lab7.dto.FoodDto;
import com.uni.Lab7.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodDto> create(@RequestBody FoodDto foodDto) {
        FoodDto savedFoodDto = foodService.save(foodDto);
        return new ResponseEntity<>(savedFoodDto, null == savedFoodDto ? HttpStatus.EXPECTATION_FAILED : HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodDto> get(@PathVariable("id") Long id) {
        FoodDto foodDto = foodService.get(id);
        return new ResponseEntity<>(foodDto, null == foodDto ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

    @GetMapping(value = "/somethingElse/{id}")
    public ResponseEntity<FoodDto> getOne(@PathVariable("id") Long id) {
        FoodDto foodDto = foodService.get(id);
        return new ResponseEntity<>(foodDto, null == foodDto ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") Long id) {
        boolean removed = foodService.remove(id);
        return new ResponseEntity<>(removed, HttpStatus.OK);
    }

}
