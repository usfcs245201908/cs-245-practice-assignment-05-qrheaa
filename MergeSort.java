public class MergeSort implements SortingAlgorithm {

	int[] arr;
	int[] temp = new int[100];

	public void sort(int arr[]) {
		sort(0, arr.length - 1);
	}

	void sort(int start, int end) {
		//Base case
		if(start < end) {
			int mid = (start + end)/2;
			sort(start, mid);
			sort(mid+1, end);

			//Merge two arrays together
			merge(arr, start, end);
		}
	}

	void merge(int[] arr, int start, int end) {

		for(int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}

		int mid = (start+end)/2;

		int i = start;
		int j = mid + 1;
		int k = start;

		//Divide and sort 2 unsorted arrays
		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}

		//Copy remaining elements, if any:
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		while(j <= end) {
			temp[k++] = arr[j++];
		}

		//Copy elements to original array:
		for(i = 0; i <= end; i++) {
			arr[i] = temp[i];
		}

	}

	
}