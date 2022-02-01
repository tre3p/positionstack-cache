package geo.app.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Address")
class Address {
    var id: String? = null
    var latitude: Double? = null
    var longitude: Double? = null
    var type: String? = null
    var distance: Int? = null
    var name: String? = null
    var number: String? = null
    @JsonProperty("postal_code") var postalCode: String? = null
    var street: String? = null
    var confidence: String? = null
    var region: String? = null
    @JsonProperty("region_code") var regionCode: String? = null
    var county: String? = null
    var locality: String? = null
    @JsonProperty("administrative_area") var administrativeArea: String? = null
    var neighbourhood: String? = null
    var country: String? = null
    @JsonProperty("country_code") var countryCode: String? = null
    var continent: String? = null
    var label: String? = null
    @Indexed @JsonIgnore var userInputAddress: String? = null
    @Indexed @JsonIgnore var userInputLatitude: Double? = null
    @Indexed @JsonIgnore var userInputLongitude: Double? = null
}