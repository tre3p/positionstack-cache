package geo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GeoCacheAppApplication

fun main(args: Array<String>) {
    runApplication<GeoCacheAppApplication>(*args)
}
