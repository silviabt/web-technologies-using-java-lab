package com.uni.Lab7.repository;

import com.uni.Lab7.domain.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodDaoRepository implements DaoRepository<Food> {

    private Long id = 0L;
    private final HashMap<Long, Food> foodList = new HashMap<>();

    @Override
    public Food save(Food object) {
        foodList.put(id++, object);
        return object;
    }

    @Override
    public boolean delete(Food object) {
        Optional<Long> foodKey = foodList.keySet()
                .stream()
                .filter(key -> foodList.get(key).equals(object))
                .findAny();
        if (foodKey.isPresent()) {
            foodList.remove(foodKey.get(), object);
            return true;
        }
        return false;
    }

    @Override
    public Food getOne(Long id) {
        return foodList.get(id);
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foodList.values());
    }
}
