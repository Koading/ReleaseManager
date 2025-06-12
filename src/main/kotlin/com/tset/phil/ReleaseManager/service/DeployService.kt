package com.tset.phil.ReleaseManager.service


import com.tset.phil.ReleaseManager.model.ServiceModel
import org.springframework.stereotype.Service
import com.tset.phil.ReleaseManager.repository.ServiceRepository

@Service
class DeployService(private val repository: ServiceRepository) {

    var systemVersionNumber: Int = 0

    fun deploy(deployment : ServiceModel) : Int {
        val deploymentsByName = repository.getByServiceNameAndNumber(deployment.serviceName, deployment.serviceVersionNumber)
        val currentDeployment = deploymentsByName.firstOrNull()

        if (currentDeployment == null || deployment.serviceVersionNumber != currentDeployment.serviceVersionNumber) {
            //to my understanding the assignment here is to update all deployed services with the same versionnumber with the current systemversionnumber
            systemVersionNumber++
            
            var deploymentsWithSameVersion = repository.getByServiceVersionNumber(deployment.serviceVersionNumber)

            deploymentsWithSameVersion
                .forEach { service ->
                    if(service.systemVersionNumber != systemVersionNumber) {
                    val toSave = service.copy(systemVersionNumber = systemVersionNumber)
                    repository.save(toSave)
                }
            }

            val deploymentToSave = deployment.copy(systemVersionNumber = systemVersionNumber)
            repository.save(deploymentToSave)

        } else {
            //make a new entity with the current systemversionnumber but no new version
            val deploymentToSave = deployment.copy(systemVersionNumber = systemVersionNumber)
            repository.save(deploymentToSave)
        }

        return systemVersionNumber
    }

    fun getServices() : List<ServiceModel> {
        return repository.getAllDeployments()
    }

    fun getServicesBySystemVersion(systemVersion : Int) : List<ServiceModel> {
        return repository.getBySystemVersionNumber(systemVersion)
    }

}