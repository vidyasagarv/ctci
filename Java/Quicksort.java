public class Quicksort {
	
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	public static void quicksort(int[] array, int left, int right){
		if(left >= right){
			return;
		}
		int index = partition(array, left, right);
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
	}

	public static int partition(int[] array, int left, int right){
		
		Random rand = new Random();
		int randomIndex = left + rand.nextInt(right - left);
		int pivot = arr[randomIndex];

		while(left <= right){
			while(array[left] < pivot){
				left++;
			}
			while(array[right] > pivot){
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
}