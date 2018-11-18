package targetcircle.tools;

import java.util.Map;
import java.util.TreeMap;

public class LMap<K,V> {
	private Map<K,V> adapted;
	
	public LMap(){
		adapted = new TreeMap<K,V>();
	}
	
	public void clear(){
		adapted.clear();
	}
	
	public boolean containsKey(Object key){
		return adapted.containsKey(key);
	}
	
	public boolean containsValue(Object value){
		return adapted.containsValue(value);
	}
	
	public boolean equals(Object o){
		return adapted.equals(o);
	}

	public V get(Object key){
		return adapted.get(key);
	}

	public V getAtIndex(int index){
		return adapted.get(this.keyList().get(index));
	}
	
	public boolean isEmpty(){
		return adapted.isEmpty();
	}


	public V put(K key, V value){
		return adapted.put(key, value);
	}

	public V remove(Object key){
		return adapted.remove(key);
	}

	public int size(){
		return adapted.size();
	}
	
	public LList<K> keyList(){
		LList<K> tmp = new LList<K>();
		
		for(K i : adapted.keySet()){
			tmp.add(i);
		}
		return tmp;
	}

	public LList<V> valueList(){
		LList<V> tmp = new LList<V>();
		
		for(V i : adapted.values()){
			tmp.add(i);
		}
		return tmp;
	}
}

/*

Set<Map.Entry<K,V>> 	entrySet()
Returns a Set view of the mappings contained in this map.

int 	hashCode()
Returns the hash code value for this map.

void 	putAll(Map<? extends K,? extends V> m)
Copies all of the mappings from the specified map to this map (optional operation).

 */
