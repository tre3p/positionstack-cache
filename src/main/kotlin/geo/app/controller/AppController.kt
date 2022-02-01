package geo.app.controller

import geo.app.dto.ForwardGeocodingDto
import geo.app.dto.ReverseGeocodingDto
import geo.app.model.Address
import geo.app.service.AddressService
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

    @PutMapping("/forward")
    fun forwardGeo(@RequestBody forwardGeocodingDto: ForwardGeocodingDto): Address {
        return addressService.forwardGeocoding(forwardGeocodingDto)
    }

    @PutMapping("reverse")
    fun reverseGeo(@RequestBody reverseGeocodingDto: ReverseGeocodingDto): Address {
        return addressService.reverseGeocoding(reverseGeocodingDto)
    }
}