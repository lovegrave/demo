package xin.lovegrave.community.demo.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import xin.lovegrave.community.demo.config.ApplicationContextUtils;

@Component
public class EhCacheServiceImpl {

    @Autowired
    private ApplicationContextUtils applicationContextUtils;

    public CacheManager getCacheManager(){
        EhCacheCacheManager cacheCacheManager = ApplicationContextUtils.applicationContext.getBean(EhCacheCacheManager.class);
        //获取CacheManager类
        return cacheCacheManager.getCacheManager();
    }
    public void save(String name,String key,Object value){
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(name);
        Element element = new Element(key,value);
        cache.put(element);
    }

    public Object getValue(String name,String key){
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(name);
        Element element = cache.get(key);
        return element.getObjectValue();
    }

    public void remove(String name,String key){
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(name);
        cache.remove(key);
        cacheManager.shutdown();
    }

    public void update(String name,String key,Object value){
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(name);
        cache.replace(new Element(key,value));
        cacheManager.shutdown();
    }

}
