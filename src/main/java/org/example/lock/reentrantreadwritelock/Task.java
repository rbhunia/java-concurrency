package org.example.lock.reentrantreadwritelock;

    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;

    import java.util.Random;
    import java.util.concurrent.Callable;

    @AllArgsConstructor
    @Slf4j
    public class Task implements Callable<String> {

        private Cache cache;

        @Override
        public String call() throws Exception {
            while (true){
                Integer key = new Random().nextInt(1000);
                cache.put(key, String.valueOf(key));
                if(cache.get(key) == null){
                    log.info("{} is not added to the cache", key);
                }
            }
        }
    }
