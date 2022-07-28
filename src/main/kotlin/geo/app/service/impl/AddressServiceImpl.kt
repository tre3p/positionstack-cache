package geo.app.service.impl

import geo.app.dto.ForwardGeocodingDto
import geo.app.dto.ReverseGeocodingDto
import geo.app.model.Address
import geo.app.repository.AddressRepository
import geo.app.service.AddressService
import geo.app.util.AddressUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class AddressServiceImpl : AddressService {

    private final val FORWARD = "forward"
    private final val REVERSE = "reverse"

    @Autowired
    private lateinit var addressRepository: AddressRepository

    @Autowired
    private lateinit var addressUtil: AddressUtil

    override fun forwardGeocoding(forwardGeocodingDto: ForwardGeocodingDto): Address {
        val userInputAddress: String = forwardGeocodingDto.address

        val address: Optional<Address> = addressRepository.findByUserInputAddress(userInputAddress)

        if (address.isPresent) {
            return address.get()
        }

        val reqAddress: Address = addressUtil.geocodingRequest(FORWARD, userInputAddress)
        reqAddress.userInputAddress = userInputAddress

        return addressRepository.save(reqAddress)
    }

    override fun reverseGeocoding(reverseGeocodingDto: ReverseGeocodingDto): Address {
        val longitude = reverseGeocodingDto.longitude
        val latitude = reverseGeocodingDto.latitude
        val requestString = "$longitude, $latitude"

        val address: Optional<Address> = addressRepository
            .findByUserInputLongitudeAndUserInputLatitude(longitude, latitude)

        if (address.isPresent) {
            return address.get()
        }

        val reqAddress = addressUtil.geocodingRequest(REVERSE, requestString)
        reqAddress.userInputLatitude = latitude
        reqAddress.userInputLongitude = longitude

        return addressRepository.save(reqAddress)
    }
}
