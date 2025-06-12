package com.tset.phil.ReleaseManager.api.controller

import org.springframework.web.bind.annotation.*

import com.tset.phil.ReleaseManager.model.ServiceModel
import com.tset.phil.ReleaseManager.service.DeployService

@RestController
@RequestMapping("/services")
class ServicesController(private val service: DeployService) {

    @GetMapping
    fun getServices(@RequestParam systemVersion : Int?): List<ServiceModel> {
        if(systemVersion == null) {
            return service.getServices();
        }
        return service.getServicesBySystemVersion(systemVersion)
    }
    
}
