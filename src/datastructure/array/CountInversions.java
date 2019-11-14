package datastructure.array;

public class CountInversions {
	
	/* This function sorts the input array and returns the
	   number of inversions in the array */
	int mergeSort(int arr[], int array_size)
	{
	    int temp[] = new int[arr.length];
	    return _mergeSort(arr, temp, 0, array_size - 1);
	}
	 
	/* An auxiliary recursive function that sorts the input array and
	  returns the number of inversions in the array. */
	int _mergeSort(int arr[], int temp[], int left, int right)
	{
	  int mid, inv_count = 0;
	  if (right > left)
	  {
	    /* Divide the array into two parts and call _mergeSortAndCountInv()
	       for each of the parts */
	    mid = (right + left)/2;
	 
	    /* Inversion count will be sum of inversions in left-part, right-part
	      and number of inversions in merging */
	 
	    /*Merge the two parts*/
	    return _mergeSort(arr, temp, left, mid) + _mergeSort(arr, temp, mid+1, right) + merge(arr, temp, left, mid+1, right);
	  }
	  return inv_count;
	}
	 
	/* This funt merges two sorted arrays and returns inversion count in
	   the arrays.*/
	int merge(int arr[], int temp[], int left, int mid, int right)
	{
	  int i, j, k;
	  int inv_count = 0;
	 
	  i = left; /* i is index for left subarray*/
	  j = mid;  /* j is index for right subarray*/
	  k = left; /* k is index for resultant merged subarray*/
	  while ((i <= mid - 1) && (j <= right))
	  {
	    if (arr[i] <= arr[j])
	    {
	      temp[k++] = arr[i++];
	    }
	    else
	    {
	      temp[k++] = arr[j++];
	 
	     /*this is tricky -- see above explanation/diagram for merge()*/
	      inv_count = inv_count + (mid - i);
	    }
	  }
	 
	  /* Copy the remaining elements of left subarray
	   (if there are any) to temp*/
	  while (i <= mid - 1)
	    temp[k++] = arr[i++];
	 
	  /* Copy the remaining elements of right subarray
	   (if there are any) to temp*/
	  while (j <= right)
	    temp[k++] = arr[j++];
	 
	  /*Copy back the merged elements to original array*/
	  for (i=left; i <= right; i++)
	    arr[i] = temp[i];
	 
	  return inv_count;
	}
	 
	
	public static void main(String[] args) {
		  int arr[] = {1, 20, 6, 4, 5};
		  CountInversions countInversion = new CountInversions();
		  System.out.println(" Number of inversions are "+countInversion.mergeSort(arr, 5));
	}

}
