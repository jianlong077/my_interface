package com.haichao.annotations.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.concurrent.TimeUnit;

public abstract class RedisLock {
	private static final Logger log = (Logger) LoggerFactory.getLogger(RedisLock.class);
    private  String redisLock = "RedisLock";


	public void lock(String key,Long timeout,Long timewait, Method method )  throws Exception {
	    long startTime=System.currentTimeMillis();
        /**
         * 确保value是唯一的:确保解析自己的锁
         */
        String keyLock=getKeyLock( key);
        Long myLock=getMyLock(key);
	    this.tryLock(keyLock,myLock, timeout, timewait,method);
        log.info("【redis分布式锁 ，执行完毕】,{key:"+keyLock+",value:"+myLock+"} 运行 耗时 ："+(System.currentTimeMillis()-startTime)+" 毫秒");
    }
    public <T> T lock(String key,Long timeout,Long timewait, MethodCallBack<T> method)  throws Exception {
        T t = null;
        long startTime=System.currentTimeMillis();
        /**
         * 确保value是唯一的:确保解析自己的锁
         */
        String keyLock=getKeyLock( key);
        Long myLock=getMyLock(key);
        t= this.tryLock(keyLock,myLock, timeout, timewait,method);
        log.info("【redis分布式锁 ，执行完毕】,{key:"+keyLock+",value:"+myLock+"} 运行 耗时 ："+(System.currentTimeMillis()-startTime)+" 毫秒");
        return t;
    }


    private void tryLock(String key,Long myLock,Long timeout,Long timewait, Method method) throws Exception {

		Boolean lock = redisTemplate().opsForValue().setIfAbsent(key, myLock, timeout, TimeUnit.SECONDS);
		if (lock) {
				log.info("【redis分布式锁 ，加锁成功】,{key:"+key+",value:"+myLock+"}");
				method.method();
	            this.unlock(key,myLock);
		}else {
				TimeUnit.SECONDS.sleep(timewait);
				tryLock( key,myLock, timeout, timewait, method);
		}
	}
    private <T> T tryLock(String key, Long myLock,Long timeout,Long timewait, MethodCallBack<T> method) throws Exception {
        T t = null;
        Boolean lock = redisTemplate().opsForValue().setIfAbsent(key, myLock, timeout, TimeUnit.SECONDS);
        if (lock) {
            log.info("【redis分布式锁 ，加陈成功】,{key:"+key+",value:"+myLock+"}");
            t= method.method();
            this.unlock(key,myLock);
            return t;
        }else {
           TimeUnit.SECONDS.sleep(timewait);
           return tryLock( key,myLock, timeout, timewait, method);
        }
    }
	//只能解锁自己的key
	private void unlock(String key, Long myLock) throws Exception {
        Object redisValue=redisTemplate().opsForValue().get(key);
        if(redisValue != null ){
            if(redisValue.toString().equals(myLock.toString())) {
                redisTemplate().opsForValue().getOperations().delete(key);
                log.info("【redis分布式锁 ，解锁成功】,{key:"+key+",value:"+myLock+"}");
            }
        }
	}

	public boolean checkKeyExist(String key, String myLock){
	    return redisTemplate().opsForValue().setIfAbsent(key, myLock, 180, TimeUnit.SECONDS);
    }
    public boolean deleteKeyExist(String key){
        return redisTemplate().opsForValue().getOperations().delete(key);
    }
    public  interface Method {
        public void method() throws Exception;
    }
    public interface MethodCallBack<T> {
        public T method() throws Exception;
    }
    public abstract RedisTemplate redisTemplate();
    protected String getKeyLock(String key){
        return redisLock+"|"+key;
    }
    public Long getMyLock(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(getKeyLock( key)+"-incrementKey", redisTemplate().getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        if ((null == increment || increment.longValue() == 0) ) {//初始设置过期时间
            entityIdCounter.expire(60*60*24, TimeUnit.SECONDS);
        }
        return increment;
    }
}
