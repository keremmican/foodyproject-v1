package com.foody.restaurantservice.service;


import com.foody.restaurantservice.model.Restaurant;
import com.foody.restaurantservice.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class RestaurantServiceTest {
    @Mock
    RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRestaurant() {
        Restaurant restaurant = new Restaurant();

        restaurant.setName("test");

        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        assertEquals(restaurant, savedRestaurant);
    }
}
