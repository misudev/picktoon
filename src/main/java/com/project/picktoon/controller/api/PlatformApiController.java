package com.project.picktoon.controller.api;

import com.project.picktoon.domain.Platform;
import com.project.picktoon.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/platforms")
@RequiredArgsConstructor
public class PlatformApiController {
    private final PlatformService platformService;

    @GetMapping("/{platformId}")
    public String getPlatform(@PathVariable("platformId")int platformId){
        return platformService.getPlatformById(platformId).getPlatformName();
    }

    @PostMapping
    public void addPlatform(@RequestBody String platformName){
        Platform platform = new Platform();
        platform.setPlatformName(platformName);
        platformService.addPlatform(platform);
    }

    @DeleteMapping("/{platformId}")
    public void deletePlatform(@PathVariable("platformId") int id){
        platformService.deletePlatform(id);
    }
}
