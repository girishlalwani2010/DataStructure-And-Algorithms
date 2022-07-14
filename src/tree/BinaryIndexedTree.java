// Also called to be Fenwick-Tree
public class BinaryIndexedTree {
    
    private int[] tree;
    
    public void initialize(int []input) {
      tree = new int[input.length+1];
      for(int i=0; i<input.length; i++) {
         update(i+1, input[i]);
      }  
    }
  
    // add val to index and next elements to index of BIT.
    public void update(int idx, int val) {
        for(; idx<tree.length; idx = getNext(idx)){
          tree[idx]+=val;
        }
    }
  
    //return sum from 0 to idx in input array
    public int getSum(int idx) {
      int sum=0;
      for(; idx>0; idx=getParent(idx)){
        sum+=tree[idx];
      }
      return sum;
    }  
  
    private int getNext(int idx) {
        idx += idx&-idx;
        return idx;
    }
  
    private int getParent(int idx) {
        idx -= idx&-idx;
        return idx;
    }
      
    //test BIT operations
    public static void main(String args[]) {
        int[] input = {3,7,1,2,10};
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree();
        binaryIndexedTree.initialize(input);
        //get sum from L to R = getSum(R) - getSum(L-1), here we are printing getSum from 4 to 5.
        System.out.println(binaryIndexedTree.getSum(5)-binaryIndexedTree.getSum(3));
        binaryIndexedTree.update(4,10);
        binaryIndexedTree.update(5,15);
        System.out.println(binaryIndexedTree.getSum(5)-binaryIndexedTree.getSum(3));

    } 



}
