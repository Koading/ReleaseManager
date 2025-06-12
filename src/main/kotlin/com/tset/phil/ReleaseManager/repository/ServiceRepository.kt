package com.tset.phil.ReleaseManager.repository

import com.tset.phil.ReleaseManager.model.ServiceModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ServiceRepository : JpaRepository<ServiceModel, Long> {

@Query("SELECT COUNT(d) FROM Service d WHERE d.serviceName = :serviceName AND d.serviceVersionNumber = :serviceVersionNumber")
    fun countByServiceNameAndVersion(
        @Param("serviceName") serviceName: String,
        @Param("serviceVersionNumber") serviceVersionNumber: Int
    ): Long

@Query("SELECT d FROM Service d WHERE d.serviceName = :serviceName AND d.serviceVersionNumber = :serviceVersionNumber")
    fun getByServiceNameAndNumber(
        @Param("serviceName") serviceName: String,
        @Param("serviceVersionNumber") serviceVersionNumber: Int
    ): List<ServiceModel>

@Query("SELECT d FROM Service d")
    fun getAllDeployments(
    ): List<ServiceModel>

@Query("SELECT d FROM Service d WHERE d.serviceVersionNumber = :serviceVersionNumber")
    fun getByServiceVersionNumber(
        @Param("serviceVersionNumber") serviceVersionNumber: Int
    ): List<ServiceModel>

@Query("SELECT d FROM Service d WHERE d.serviceName = :serviceName")
    fun getByServiceName(
        @Param("serviceName") serviceName: String
    ): List<ServiceModel>

@Query("SELECT d FROM Service d WHERE d.systemVersionNumber = :systemVersionNumber")
    fun getBySystemVersionNumber(
        @Param("systemVersionNumber") systemVersionNumber: Int
    ): List<ServiceModel>

}