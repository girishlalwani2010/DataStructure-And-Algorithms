package algo.binarysearch;

public class SearchInASortedArrayOfUnknownSize {

	private ArrayReader reader;

	public void setReader(ArrayReader reader) {
		this.reader = reader;
	}

	class ArrayReader {
		int index;
		int[] array;

		public void set(int[] array) {
			this.array = array;
		}

		int get(int index) {
			if (index < array.length) {
				return array[index];
			}
			return 2147483647;
		}
	}

	public int binarySearch(int low, int high, int target) {
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			int midVal = reader.get(mid);
			if (midVal == target) {
				return mid;
			}
			if (midVal > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int search(ArrayReader reader, int target) {
		int elementAtindexOutOfBound = 2147483647;
		int low = 0;
		int high = 19998;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			int midVal = reader.get(mid);
			if (midVal != elementAtindexOutOfBound) {
				low++;
			} else {
				high--;
			}
		}
		low = 0;
		return binarySearch(low, high, target);
	}
	
	public int searchEfficientWay(ArrayReader reader, int target) {
		if(reader.get(0) == target) {
			return 0;
		}
		//search boundaries
		int low=0;
		int high=1;
		while(reader.get(high)<target) {
			low = high;
			high = high<<1;
		}
		return binarySearch(low, high, target);
	}

	public static void main(String[] args) {
		int a[] = { -1, 0, 3, 5, 9, 12 };
		SearchInASortedArrayOfUnknownSize searchInUnknownSizeArr = new SearchInASortedArrayOfUnknownSize();
		ArrayReader reader = searchInUnknownSizeArr.new ArrayReader();
		searchInUnknownSizeArr.setReader(reader);
		System.out.println(searchInUnknownSizeArr.search(reader, 9));
	}

}
