package org.amhzing.bicentennial.configuration.event

import com.hazelcast.core.EntryEvent
import com.hazelcast.core.EntryListener
import com.hazelcast.core.MapEvent
import org.slf4j.LoggerFactory

class CacheEntryListener : EntryListener<String, Any> {
    override fun entryEvicted(event: EntryEvent<String, Any>?) {
        logger.debug("Entry Evicted: {}", event)
    }

    override fun mapCleared(event: MapEvent?) {
        logger.debug("Map Cleared: {}", event)
    }

    override fun entryAdded(event: EntryEvent<String, Any>?) {
        logger.debug("Entry Added: {}", event)
    }

    override fun entryRemoved(event: EntryEvent<String, Any>?) {
        logger.debug("Entry Removed: {}", event)
    }

    override fun entryUpdated(event: EntryEvent<String, Any>?) {
        logger.debug("Entry Updated: {}", event)
    }

    override fun mapEvicted(event: MapEvent?) {
        logger.debug("Map Evicted: {}", event)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CacheEntryListener::class.java)
    }
}