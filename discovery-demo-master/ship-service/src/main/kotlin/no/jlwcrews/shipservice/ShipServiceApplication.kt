package no.jlwcrews.shipservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ShipServiceApplication

fun main(args: Array<String>) {
    runApplication<ShipServiceApplication>(*args)
}
