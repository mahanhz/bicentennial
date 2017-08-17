package org.amhzing.bicentennial.configuration.event

import com.hazelcast.core.EntryEvent
import com.hazelcast.core.MapEvent
import com.hazelcast.map.listener.*
import org.slf4j.LoggerFactory

class CacheEntryListener : EntryAddedListener<Any, Any>,
                           EntryRemovedListener<Any, Any>,
                           EntryUpdatedListener<Any, Any>,
                           EntryEvictedListener<Any, Any>,
                           MapEvictedListener,
                           MapClearedListener {

    override fun entryAdded(event: EntryEvent<Any, Any>?) {
        logger.debug("Entry Added: {}", event)
    }

    override fun entryRemoved(event: EntryEvent<Any, Any>?) {
        logger.debug("Entry Removed: {}", event)
    }

    override fun entryUpdated(event: EntryEvent<Any, Any>?) {
        logger.debug("Entry Updated: {}", event)
    }

    override fun entryEvicted(event: EntryEvent<Any, Any>?) {
        logger.debug("Entry Evicted: {}", event)
    }

    override fun mapEvicted(event: MapEvent?) {
        logger.debug("Map Evicted: {}", event)
    }

    override fun mapCleared(event: MapEvent?) {
        logger.debug("Map Cleared: {}", event)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CacheEntryListener::class.java)
    }
}