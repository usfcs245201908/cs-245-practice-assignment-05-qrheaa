public class QuickSort implements SortingAlgorithm {

	public void sort(int[] a) {
		qs(a,0,a.length-1);
	}

	void qs(int[] a, int left, int right) {

		//base case
		if(left < right) { //execute partition and tell where pivot is at end to quicksort everything left & right of pivot

			int p = partition(a, left, right);
			qs(a, left, p-1); //p is index of pivot —> sort left side of pivot
			qs(a, p +1, right); //—> sort right side of pivot
		}
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	int partition(int[] a, int left, int right) {

		if(left < right) { 
			int pivot = 0;
			int i = left + 1;
			int j = right;

				while(i < j) {
					while(i < right && a[i] < a[pivot])
						++i;

					while(j > i && a[j] > a[pivot]) //j should not be less than pivot
						j--;

					if(i < j) 
						swap(a, i , j);
				}

				swap(a, j, pivot);
				return j;

			}

			return left;
	}

}
