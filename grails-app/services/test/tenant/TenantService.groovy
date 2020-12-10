package test.tenant

import grails.gorm.multitenancy.Tenants
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.grails.orm.hibernate.HibernateDatastore

@Slf4j
@Transactional
class TenantService {

    HibernateDatastore hibernateDatastore

    Closure closure = {
        Car c = new Car(model: 'fiat')
        c.save(failOnError: true)
    }

    def execute() {
        log.info "Adding schema..."
        hibernateDatastore.addTenantForSchema('test')

        log.info "Installing data..."
        Tenants.withId('test') {
            closure.call()
        }
    }
}
