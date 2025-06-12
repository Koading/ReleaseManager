package com.tset.phil.ReleaseManager.api.controller

import org.springframework.web.bind.annotation.*

import com.tset.phil.ReleaseManager.model.ServiceModel
import com.tset.phil.ReleaseManager.service.DeployService

@RestController
@RequestMapping("/deploy")
class DeployController(private val service: DeployService) {

    @PostMapping
    fun deploy(@RequestBody deployment: ServiceModel) : Int {
        return service.deploy(deployment);
    }
}