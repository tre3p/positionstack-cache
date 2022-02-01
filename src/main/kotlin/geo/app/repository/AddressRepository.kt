package geo.app.repository

import geo.app.model.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AddressRepository : CrudRepository<Address, String> {
    fun findByUserInputAddress(address: String) : Optional<Address>
    fun findByUserInputLongitudeAndUserInputLatitude(longitude: Double, latitude: Double): Optional<Address>
}