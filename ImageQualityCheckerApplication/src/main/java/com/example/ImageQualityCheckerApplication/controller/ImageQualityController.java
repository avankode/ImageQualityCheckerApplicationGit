package com.example.ImageQualityCheckerApplication.controller;


import com.example.ImageQualityCheckerApplication.service.ImageQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageQualityController {

    @Autowired
    private ImageQualityService imageQualityService;

    @GetMapping("/check-image-quality")
    public String checkImageQuality(@RequestParam String imageUrl) {
        return imageQualityService.evaluateImageQuality(imageUrl);
    }
}