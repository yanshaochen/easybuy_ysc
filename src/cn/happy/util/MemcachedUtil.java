package cn.happy.util;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * MemcachedUtil
 */
public class MemcachedUtil {
    private static MemCachedClient client = new MemCachedClient();
    private static MemcachedUtil memcached = new MemcachedUtil();
    private static Logger log = Logger.getLogger(MemcachedUtil.class);

    static {
        log.debug("Instantiated cache");
        String[] servers = {"127.0.0.1:11211"};
        Integer[] weights = {3};
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setWeights(weights);
        pool.setFailover(true);
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000 * 60 * 60 * 6);
        pool.setMaintSleep(30000);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
    }

    private MemcachedUtil() {
    }

    public static MemcachedUtil getInstance() {// �����ṩ�ӿ�
        return memcached;
    }

    public boolean set(String key, Object value) {
        log.debug("set key..." + key);
        boolean done = client.set(key, value);
        log.debug("done?" + done);
        return done;
    }

    public boolean add(String key, Object value) {// ��ӻ����ж��󷽷�
        return client.add(key, value);
    }

    public boolean delete(String key) {
        return client.delete(key);
    }

    public boolean replace(String key, Object value) {// �滻�����еĶ��󷽷�
        return client.replace(key, value);
    }

    public Object get(String key) {
        return client.get(key);
    }

    public boolean flushAll() {
        Map map = client.stats();
        Set entrySet = map.entrySet();
        for (Object object : entrySet) {
            log.debug(object);
        }
        return client.flushAll();
    }

}
