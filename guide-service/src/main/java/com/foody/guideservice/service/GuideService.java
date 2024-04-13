package com.foody.guideservice.service;

import com.foody.guideservice.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;
}
