package org.amhzing.bicentennial.configuration

import com.hazelcast.config.*
import com.hazelcast.map.listener.MapListener
import org.amhzing.bicentennial.configuration.event.CacheEntryListener
import org.amhzing.bicentennial.data.cache.CacheSpec
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val SECONDS_IN_DAY: Int = 86400
const val DEFAULT_MAX_SIZE: Int  = 500

@Configuration
@EnableCaching
class CacheConfig {

    @Bean
    fun cacheEntryListener(): MapListener {
        return CacheEntryListener()
    }

    @Bean
    fun hazelCastConfig(): Config {
        return Config()
                .setInstanceName("hazelcast-instance")
                .setProperty("hazelcast.jmx", "true")
                .addMapConfig(MapConfig()
                                      .setName(CacheSpec.COUNTRIES.name)
                                      .setMaxSizeConfig(MaxSizeConfig(DEFAULT_MAX_SIZE, MaxSizeConfig.MaxSizePolicy.PER_NODE))
                                      .setEvictionPolicy(EvictionPolicy.LRU)
                                      .setTimeToLiveSeconds(SECONDS_IN_DAY)
                                      .addEntryListenerConfig(EntryListenerConfig(cacheEntryListener(),
                                                                                  false,
                                                                                  false)))
    }
}
