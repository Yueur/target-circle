package targetcircle.tools;

public class Random {
	private java.util.Random adapter;
	
	public Random(){
		adapter = new java.util.Random();
	}
	
	/**
	 * Return random number
	 * @return [0; 2^31 [
	 */
	public int getInt(){
		int tmp = adapter.nextInt();
		if(tmp < 0){
			return -tmp;
		}
		return tmp;
	}

	public int getInt(int max){
		if(max < 0){
			// Throw exception
			
		}
		return this.getInt() % max;
	}

	public int getInt(int min, int max){
		if(min < 0 || max < 0){
			// Throw exception
			
		}
		if(min > max){
			// Throw exception
			
		}
		
		return this.getInt(max-min) + min;
	}
	
	public <E> LList<E> getList(LList<E> aaa){
		LList<E> tmp = new LList<E>(aaa);
		LList<E> out = new LList<E>();
		
		int i;
		while(tmp.size() > 0){
			i = this.getInt(tmp.size()); 
			out.add(tmp.get(i));
			tmp.remove(i);
		}
		
		return out;
	}
}
