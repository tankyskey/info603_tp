package bous;

public class Bous {
	public static void sort(int[] arr) {
		int iteration = 0;

		while( iteration < arr.length/2 ){
			// AX) arr[iteration .. length-iteration] n'est trie

			for( int i=0; i<arr.length-iteration-1; i++ )
				if(arr[i] > arr[i+1]) swap(arr, i, i+1);
			// AX) arr[length-iteration .. length] est trie

			for( int i=arr.length-iteration-2; i>iteration+1; i-- )
				if(arr[i] < arr[i-1]) swap(arr, i, i-1);
			// AX) arr[0 .. iteration] est trie

			iteration++;
		}
		// AX) arr est trie
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
