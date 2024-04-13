package com.foody.userservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "user")
public class UserController {
    private final UserService userService;


}
