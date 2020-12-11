package com.uni.lab10.controller;

import com.uni.lab10.domain.Points;
import com.uni.lab10.dto.PointsDto;
import com.uni.lab10.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/{username}")
    public ResponseEntity<PointsDto> addPoints(@PathVariable @NotNull String username) {
        PointsDto pointsDto = pointsService.addPointsFor(username);
        return ResponseEntity
                .ok()
                .body(pointsDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<PointsDto> get(@PathVariable @NotNull String username) {
        PointsDto pointsDto = pointsService.getPointsFor(username);
        return ResponseEntity
                .ok()
                .body(pointsDto);
    }
}
