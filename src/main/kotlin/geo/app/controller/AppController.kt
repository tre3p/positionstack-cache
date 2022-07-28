package geo.app.controller

import geo.app.dto.ForwardGeocodingDto
import geo.app.dto.ReverseGeocodingDto
import geo.app.model.Address
import geo.app.service.AddressService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AppController {

    @Autowired
    private lateinit var addressService: AddressService

    @Operation(summary = "Forward geocoding")
    @ApiResponse(responseCode = "200", description = "Geocoding result")
    @PutMapping("/forward")
    fun forwardGeo(@RequestBody forwardGeocodingDto: ForwardGeocodingDto): Address {
        return addressService.forwardGeocoding(forwardGeocodingDto)
    }

    @Operation(summary = "Reverse geocoding")
    @ApiResponse(responseCode = "200", description = "Geocoding result")
    @PutMapping("reverse")
    fun reverseGeo(@RequestBody reverseGeocodingDto: ReverseGeocodingDto): Address {
        return addressService.reverseGeocoding(reverseGeocodingDto)
    }
}