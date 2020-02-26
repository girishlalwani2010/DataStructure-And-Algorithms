package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


class CircularArrayList<E> extends ArrayList<E>
{
    private static final long serialVersionUID = 1L;
    public CircularArrayList(Collection<? extends E> c) {
       super(c);
    }
    @Override
    public E get(int index) {
    	if(index>=size()) {
    		return super.get(index % size());
    	}else if(index<0) {
    		index = size()-1;
    		return super.get(index % size());
    	}else {
    		return super.get(index);
    	}
    }
}

public class Test1 {
	
	public static int tool(List<String> tools, int k, String q) {
		List<String> circularList = new CircularArrayList<String>(tools);
		if(tools.get(k).equals(q)) {
			return 0;
		}
		int frwdPosition=1; 
		int i=k+1;
		while(i!=k){
			if(circularList.get(i++).equals(q)) {
				break;
			}
			frwdPosition++;
		}
		
		int bckPosition=1;
		i=k-1;
		while(i!=k){
			if(circularList.get(i--).equals(q)) {
				break;
			}
			bckPosition++;
		}
		return Math.min(frwdPosition, bckPosition);
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("r","u","a","b","e");
		System.out.println(tool(list,4,"u"));
		
	}
}
