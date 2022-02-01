package geo.app.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class AppConfig {

    @Value("\${jedis.hostname}")
    private lateinit var redisHostName: String

    @Value("\${jedis.port}")
    private var redisPort: Int = 0

    @Bean
    fun connectionFactory() : JedisConnectionFactory {
        val cfg = RedisStandaloneConfiguration(redisHostName, redisPort)
        return JedisConnectionFactory(cfg)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val template: RedisTemplate<String, Any> = RedisTemplate()
        template.setConnectionFactory(connectionFactory())
        return template
    }
}