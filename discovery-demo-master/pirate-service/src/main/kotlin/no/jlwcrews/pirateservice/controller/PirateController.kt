package no.jlwcrews.pirateservice.controller

import no.jlwcrews.pirateservice.integration.RabbitSender
import no.jlwcrews.pirateservice.integration.ShipIntegrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pirate")
class PirateController(
    @Autowired private val rabbitSender: RabbitSender,
    @Autowired private val shipIntegrationService: ShipIntegrationService
) {

    @GetMapping
    fun getPirateHello(): ResponseEntity<String> {
        return ResponseEntity.ok("Argh, we be pirates")
    }

    @PostMapping("/{message}")
    fun createPirateMessage(@PathVariable message: String) {
        rabbitSender.sendMessage(message)
    }

    @PostMapping("/callToShip")
    fun getResponseFromShipService() {
        shipIntegrationService.sendHttpCallToShipService("This is a message from the pirate service")
    }
}