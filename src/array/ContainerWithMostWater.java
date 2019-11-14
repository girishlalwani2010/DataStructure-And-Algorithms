package array;

public class ContainerWithMostWater {
	
	public static int maxArea(int[] height) {
		int i=0,j=height.length-1,k=0;
		int area[] = new int[height.length];
		while(i<j) {
			int currentArea = Math.min(height[i], height[j]) * (j-i);
			if(height[i]>height[j]) {
				j--;
			}else {
				i++;
			}
			area[k++] = currentArea;	
		}
		int max = area[0];
		for(int l=1; l<area.length; l++) {
			if(max<area[l]) {
				max = area[l];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int height[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}

}
