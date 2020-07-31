package bfs;

public class Pair<T1, T2> {

	private String key; 
	private int value;
	
	public Pair(String beginWord, int val) {
		this.key=beginWord;
		this.value = val;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
