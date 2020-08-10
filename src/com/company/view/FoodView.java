package com.company.view;

import com.company.domain.Food;

import java.util.List;

public interface FoodView
{
    public List<Food> showFoodList(Integer businessId);
    public List<Food> saveFood(Integer businessId);

}
