package org.example.lock.reentrantreadwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Cache {

    private final Map<Integer, String> cacheMap = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public void put(Integer key, String value) {
        writeLock.lock();

        try{
            cacheMap.put(key, value);
            log.info("Added key: {} and value:{} pair in the cache", key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public String get(Integer key) {
        readLock.lock();
        try{
            return cacheMap.get(key);
        }finally {
            readLock.unlock();
        }
    }
}
