package princelo.mockery.psr.simplecache;

public interface CounterInterface {
    /**
     * Increment a value atomically in the cache
     *
     * @param key  The cache item key
     * @param step The value to increment by
     *
     * @return The new value
     */
    int increment(String key, int step);

    /**
     * Increment a value atomically in the cache
     *
     * @param key  The cache item key
     *
     * @return The new value
     */
    int increment(String key);

    /**
     * Decrement a value atomically in the cache by its step value
     *
     * @param key  The cache item key
     * @param step The value to decrement by
     *
     * @return The new value
     */
    int decrement(String key, int step);

    /**
     * Decrement a value atomically in the cache
     *
     * @param key  The cache item key
     *
     * @return The new value
     */
    int decrement(String key);
}
