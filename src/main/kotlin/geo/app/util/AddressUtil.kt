package geo.app.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import geo.app.model.Address
import kong.unirest.Unirest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AddressUtil {

    @Value("\${access.key}")
    private lateinit var accessKey: String

    private val POSITIONSTACK_URL = "http://api.positionstack.com/v1/%s?access_key=%s&query=%s&limit=1&output=json"

    fun geocodingRequest(requestType: String, data: String): Address {
        val response = Unirest
            .get(String.format(POSITIONSTACK_URL, requestType, accessKey, data))
            .asString()

        val typeRef = object : TypeReference<Map<String, List<Address>>>() {}
        val result = ObjectMapper().readValue(response.body, typeRef)

        return result["data"]!![0]
    }
}