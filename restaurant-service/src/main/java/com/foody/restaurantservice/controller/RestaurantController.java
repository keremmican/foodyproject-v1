package com.foody.restaurantservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "restaurant")
public class RestaurantController {

}
