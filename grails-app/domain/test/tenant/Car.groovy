package test.tenant

import grails.gorm.MultiTenant

class Car implements MultiTenant<Car> {

    String model

    static constraints = {
    }
}
