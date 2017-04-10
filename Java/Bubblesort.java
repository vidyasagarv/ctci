public class Bubblesort {

	public static void bubblesort(int[] array){
		boolean isSorted = false;
		int lastUnsorted = array.length - 1;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0;i < lastUnsorted; ++i) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}

}