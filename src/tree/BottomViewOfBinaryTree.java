package tree;

//Java Program to print Bottom View of Binary Tree
import java.util.*;
import java.util.Map.Entry;

//Tree node class
class NodeWithHD
{
 int data; //data of the node
 int hd; //horizontal distance of the node
 NodeWithHD left, right; //left and right references

 // Constructor of tree node
 public NodeWithHD(int key)
 {
     data = key;
     hd = Integer.MAX_VALUE;
     left = right = null;
 }
}

//Tree class
class Tree
{
 NodeWithHD root; //root node of tree

 // Default constructor
 public Tree() {}

 // Parameterized tree constructor
 public Tree(NodeWithHD node)
 {
     root = node;
 }

 // Method that prints the bottom view.
 public void bottomView()
 {
     if (root == null)
         return;

     // Initialize a variable 'hd' with 0 for the root element.
     int hd = 0;

     // TreeMap which stores key value pair sorted on key value
     Map<Integer, Integer> map = new TreeMap<>();

      // Queue to store tree nodes in level order traversal
     Queue<NodeWithHD> queue = new LinkedList<NodeWithHD>();

     // Assign initialized horizontal distance value to root
     // node and add it to the queue.
     root.hd = hd;
     queue.add(root);
     map.put(hd, root.data);

     // Loop until the queue is empty (standard level order loop)
     while (!queue.isEmpty())
     {
         NodeWithHD temp = queue.remove();

         // Extract the horizontal distance value from the
         // dequeued tree node.
         hd = temp.hd;

         // Put the dequeued tree node to TreeMap having key
         // as horizontal distance. Every time we find a node
         // having same horizontal distance we need to replace
         // the data in the map.
         

         // If the dequeued node has a left child add it to the
         // queue with a horizontal distance hd-1.
         if (temp.left != null)
         {
             map.put(hd-1, temp.left.data);
             temp.left.hd = hd -1;
             queue.add(temp.left);
         }
         // If the dequeued node has a left child add it to the
         // queue with a horizontal distance hd+1.
         if (temp.right != null)
         {
        	 map.put(hd+1, temp.right.data);
        	 temp.right.hd = hd+1;
             queue.add(temp.right);
         }
     }

     // Extract the entries of map into a set to traverse
     // an iterator over that.
     Set<Entry<Integer, Integer>> set = map.entrySet();

     // Make an iterator
     Iterator<Entry<Integer, Integer>> iterator = set.iterator();

     // Traverse the map elements using the iterator.
     while (iterator.hasNext())
     {
         Map.Entry<Integer, Integer> me = iterator.next();
         System.out.print(me.getValue()+" ");
     }
     
 }
}

//Main driver class
public class BottomViewOfBinaryTree
{
 public static void main(String[] args)
 {
     NodeWithHD root = new NodeWithHD(20);
     root.left = new NodeWithHD(8);
     root.right = new NodeWithHD(22);
     root.left.left = new NodeWithHD(5);
     root.left.right = new NodeWithHD(3);
     root.right.left = new NodeWithHD(4);
     root.right.right = new NodeWithHD(25);
     root.left.right.left = new NodeWithHD(10);
     root.left.right.right = new NodeWithHD(14);
     PrintAllRootToLeafPaths tree = new PrintAllRootToLeafPaths();
     System.out.println("Bottom view of the given binary tree:");
     	tree.bottomView();
 }
}
