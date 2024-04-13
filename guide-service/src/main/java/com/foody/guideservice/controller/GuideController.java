package com.foody.guideservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.guideservice.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "guide")
public class GuideController {
    private final GuideService guideService;
}
