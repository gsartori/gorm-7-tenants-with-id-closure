package test.tenant

import grails.gorm.multitenancy.Tenants
import grails.gorm.transactions.Transactional

@Transactional
class BootStrap {

    TenantService tenantService

    def init = { servletContext ->
        tenantService.execute()

        Tenants.withId ('test') {
            log.info "Reading data"
            println "Cars in shop: " + Car.count()
            Car.list().each { car ->
                println " - " + car.model
            }
        }
    }

    def destroy = {
    }
}
