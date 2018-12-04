package targetcircle.core;

import targetcircle.output.IOutVisitor;
import targetcircle.tools.LList;
import targetcircle.tools.LMap;

public class GiverTaker<K extends IElement,V extends IElement> {
	private LMap<K,V> content;
	
	public GiverTaker(){
		content = new LMap<K,V>();
	}
	
	public void reset(){
		content = new LMap<K,V>();
	}
	
	// For IOutVisitor => This allow proper format 
	public void visit(IOutVisitor visitor){
		LList<K> aaa = content.keyList();
		
		for(int i=0 ; i<aaa.size() ; i++){
			//this.handleVisit(visitor, aaa.get(i), content.getAtIndex(i)); // Slower version
			
			K tmp = aaa.get(i);
			visitor.participantGT(tmp, content.get(tmp));
		}
	}
	
	public void setEntry(K key, V value){
		if(content.containsKey(key)){
			content.remove(key);
		}
		content.put(key, value);
	}
	
	public LList<K> keyList(){
		return content.keyList();
	}

	public V get(K key){
		return content.get(key);
	}
	
	public void clear(){
		content.clear();
	}
	
	public int size(){
		return content.size();
	}
}
