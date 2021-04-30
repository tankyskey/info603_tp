package bous;

public class Bous {
	public static void sort(int[] arr) {
		int iteration = 0;
        int length = arr.length;

		while( iteration < length/2 ){
			for( int i=iteration; i<length-iteration-1; i++ ) {
				if(arr[i] > arr[i+1]) swap(arr, i, i+1);
            }
			// AX) arr[length-iteration .. length] est trié
            assert sorted(arr, length-iteration+1, length) : "axiome 1 failed";

			for( int i=length-iteration-2; i>iteration; i-- ) {
				if(arr[i] < arr[i-1]) swap(arr, i, i-1);
            }
			// AX) arr[0 .. iteration] est trié
            assert sorted(arr, 0, iteration+1) : "axiome 2 failed";

			iteration++;
		}
        printArr( arr, "");
		// AX) arr est trie
        assert sorted(arr, 0, length) : "axiome 3 failed";
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

    /**
     * @brief est-ce que le tableau arr est trié entre les indices i et j-1 ?
     * @param arr: tableau
     * @param i: indice de debut
     * @param j: indice de fin
     * @return arr[i .. j] sorted ? true : false
     */
    public static boolean sorted(int[] arr, int i, int j) {
        for( ; i<j-1; i++ ) {
            if( arr[i] > arr[i+1] ) return false;
        }
        return true;
    }

    public static void printArr( int[] arr, String tab ) {
        String res = tab;
        for( int e: arr )
            res += "["+e+"]";
        System.out.println(res);
    }
}


