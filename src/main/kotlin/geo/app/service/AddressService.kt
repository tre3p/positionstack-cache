package geo.app.service

import geo.app.dto.ForwardGeocodingDto
import geo.app.dto.ReverseGeocodingDto
import geo.app.model.Address

interface AddressService {
    fun forwardGeocoding(forwardGeocodingDto: ForwardGeocodingDto): Address
    fun reverseGeocoding(reverseGeocodingDto: ReverseGeocodingDto): Address
}