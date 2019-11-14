package datastructure.string;

public class RemoveCharFromString {
	public static void main(String[] args) {
		 String firstString = "geeksforgeeks";
		 String secondString = "mask";
		 int count[] = new int[256];
		
		for(int i=0; i<secondString.length(); i++){
			count[secondString.charAt(i)]++;
		}
		String output = "";
		for(int i=0; i<firstString.length(); i++){
			if(count[firstString.charAt(i)] == 0){
				 output = output + firstString.charAt(i);
			}
		}
		
		System.out.println(output);
		
	}
}
