package design;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V>{
	private static final long serialVersionUID = 1L;
	
	private static final int CACHE_SIZE = 10;
	private final int maxSize;
	
	public LRUCache(final int maxSize){
		super(maxSize + 1, 1.0f, true);
		this.maxSize = maxSize;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return super.size() > maxSize;
	}
	
	Map<String, String> cache = 
			Collections.synchronizedMap(
			new LRUCache<String, String>(CACHE_SIZE));

}
