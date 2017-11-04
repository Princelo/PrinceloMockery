package princelo.mockery.psr.simplecache;

import java.util.Collection;
import java.util.Map;

public interface CacheInterface<T> {
    int TTL_MINUTE = 60;
    int TTL_HOUR = 3600;
    int TTL_DAY = 86400;

    /**
     * Fetch a value from the cache.
     *
     * @param key The unique key of this item in the cache
     *
     * @return mixed The value of the item from the cache, or null in case of cache miss
     */
    T get(String key);

    /**
     * Persist data in the cache, uniquely referenced by a key with an expiration TTL time.
     *
     * @param key The key of the item to store
     * @param value The value of the item to store
     * @param ttl The TTL value of this item. If no value is sent and the driver supports TTL
     *                                       then the library may set a default value for it or let the driver take care of that.
     *
     * @return bool True on success and false on failure
     */
    boolean set(String key, T value, int ttl);

    /**
     * Persist data in the cache, uniquely referenced by a key.
     *
     * @param key The key of the item to store
     * @param value The value of the item to store
     *
     * @return True on success and false on failure
     */
    boolean set(String key, T value);

    /**
     * Delete an item from the cache by its unique key
     *
     * @param key The unique cache key of the item to delete
     */
    void delete(String key);

    /**
     * Wipe clean the entire cache's keys
     */
    void clear();

    /**
     * Obtain multiple cache items by their unique keys
     *
     * @param keys A list of keys that can obtained in a single operation.
     *
     * @return a map of key => value pairs. Cache keys that do not exist or are stale will have a value of null.
     */
     Map<String, T> getMultiple(String[] keys);

    /**
     * Obtain multiple cache items by their unique keys
     *
     * @param keys A list of keys that can obtained in a single operation.
     *
     * @return a map of key => value pairs. Cache keys that do not exist or are stale will have a value of null.
     */
    Map<String, T> getMultiple(Collection<String> keys);

    /**
     * Persisting a set of key => value pairs in the cache, with an optional TTL.
     *
     * @param items A map of key => value pairs for a multiple-set operation.
     * @param ttl   The amount of seconds from the current time that the item will exist in the cache for.
     *                                     If this is null then the cache backend will fall back to its own default behaviour.
     *
     * @return bool True on success and false on failure
     */
    boolean setMultiple(Map<String, T> items, int ttl);

    /**
     * Persisting a set of key => value pairs in the cache, with an optional TTL.
     *
     * @param items A map of key => value pairs for a multiple-set operation.
     *
     * @return bool True on success and false on failure
     */
    boolean setMultiple(Map<String, T> items);

    /**
     * Delete multiple cache items in a single operation
     *
     * @param keys The array of string-based keys to be deleted
     */
    void deleteMultiple(String[] keys);

    /**
     * Delete multiple cache items in a single operation
     *
     * @param keys The collection of string-based keys to be deleted
     */
    void deleteMultiple(Collection<String> keys);

    /**
     * Identify if an item is in the cache.
     * NOTE: It is recommended that exists() is only to be used for cache warming type purposes
     * and not to be used within your live applications operations for get/set, as this method
     * is subject to a race condition where your exists() will return true and immediately after,
     * another script can remove it making the state of your app out of date.
     *
     * @param key The cache item key
     *
     * @return True if exists else false
     */
    boolean exists(String key);

}
