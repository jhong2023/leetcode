package design;

public class MyHashMap<K, V> {
	Entry<K, V>[] table;
	int capacity;
	int threshold;
	int size = 0;
	
	public MyHashMap(int capacity, double loadFactor){
		table = new Entry[capacity];
		threshold = (int)(capacity * loadFactor);
	}
	
	V get(K key){
		Entry<K, V> entry = table[index(key)];
		while(entry != null){
			if(entry.key.equals(key)){
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}
	
	V put(K key, V value){
		Entry<K, V> entry = table[index(key)];
		while(entry != null){
			if(entry.key.equals(key)){
				break;
			}
			entry = entry.next;
		}
		if(entry != null){
			V oldValue = entry.value;
			entry.value = value;
			return oldValue;
		}
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		newEntry.next = entry;
		table[index(key)] = newEntry;
		if (size++ >= threshold){
			resize(capacity*2);
		}
		return null;
	}
	
	int index(K key){
		return key.hashCode() % (capacity - 1);
	}
	
	void resize(int newCapacity){
		Entry[] newTable = new Entry[newCapacity];
		capacity = newCapacity;
		for(Entry<K, V> e : table){
			while(e != null){
				int index = index(e.key);
				if(newTable[index] == null){
					newTable[index] = e;
				} else {
					e.next = newTable[index];
					newTable[index] = e;
				}
			}
		}
		table = newTable;
	}
}

class Entry<K, V>{
	K key;
	V value;
	Entry<K, V> next;
	
	public Entry(K key2, V value2) {
	}
}
