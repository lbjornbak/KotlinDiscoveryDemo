package no.jlwcrews.pirateservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class PirateServiceApplication {

    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate? {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<PirateServiceApplication>(*args)
}