1) I assumed that CacheImpl will be in multi-threaded environment, so that synchronization should be used. More sophisticated locking may be applied using ReadWriteLock if simple synchronization degradates performance.

2) I was thinking about  reducing initial capacity and tweak load factor  of LinkedhashMap to the capacity. However, in such situation there is a high risk of hashcodes collision and placing all entries in one backet, so I left the default values in the constructor.

3) I assumed that CacheView should have reference to map which stored nodes so that one object CacheImpl implements both Cache and CacheView interfaces.
