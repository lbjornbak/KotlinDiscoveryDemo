package no.jlwcrews.shipservice.controller

import no.jlwcrews.shipservice.integration.RabbitSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ship")
class ShipController(@Autowired private val rabbitSender: RabbitSender) {

    @GetMapping
    fun getShipHello(): ResponseEntity<String> {
        return ResponseEntity.ok("Argh, we be pirate ships")
    }

    @PostMapping("/{message}")
    fun createShipMessage(@PathVariable message: String) {
        rabbitSender.sendMessage(message)
    }

    @GetMapping("/http/{message}")
    fun responseToPirateService(@PathVariable message: String): ResponseEntity<String> {
        println(message)
        return ResponseEntity.ok("Hello from ship service, thank you for your request")
    }
}