package array;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private List<Integer> list;

	public MinHeap() {
		list = new ArrayList<>();
	}

	public void createHeap(List<Integer> input) {
		if (input.size() > 0) {
			for (Integer i : input) {
				insert(i);
			}
		}
	}

	public void insert(int i) {
		list.add(i);
		bubbleUp(list.size() - 1);
	}

	public void bubbleUp(int pos) {
		int parentIdx = parent(pos);
		int currentIdx = pos;
		while (currentIdx > 0 && list.get(parentIdx) > list.get(currentIdx)) {
			swap(currentIdx, parentIdx);
			currentIdx = parentIdx;
			parentIdx = parent(parentIdx);
		}
	}

	private void swap(int i, int parent) {
		int temp = list.get(parent);
		list.set(parent, list.get(i));
		list.set(i, temp);
	}
	
    public int extractMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {
            int min = list.remove(0);
            return min;
        }
        // remove the last item ,and set it as new root
        int min = list.get(0);
        int lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        // bubble-down until heap property is maintained
        sinkDown(0);
        // return min key
        return min;
    }
    
	public void sinkDown(int k){
		int smallest =k;
		if(2*k<list.size() && list.get(smallest)>list.get(2*k)){
			smallest = 2*k;
		}
		if(2*k+1<list.size() && list.get(smallest)>list.get(2*k+1)){
			smallest = 2*k+1;
		}
		if(smallest!=k){
			swap(k,smallest);
			sinkDown(smallest);
		}
	}
	
	public void decreaseKey(int i, int key) {
        if (list.get(i) < key) {
            throw new IllegalArgumentException("Key is larger than the original key");
        }
        list.set(i, key);
        bubbleUp(i);
    }
	
    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }
}
