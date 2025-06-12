package com.tset.phil.ReleaseManager.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.*

@Entity(name = "Service")
@Table(name = "Service")
data class ServiceModel(
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    val id : Long, 

    val serviceName : String,
    
    @JsonProperty("version")
    val serviceVersionNumber : Int,

    @JsonIgnore
    var systemVersionNumber : Int
)
