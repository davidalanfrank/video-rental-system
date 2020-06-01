package movie;

public class QuickSort {
    /**
     * The class handles all operations to do with a quick sort
     */


    /**
     * Partitions a two dimensional subarray by Hoare’s algorithm, using the first element
     *  	as a pivot.
     * */
    private int partition(int arr[][], int lower, int higher)
    {
        int pivot = arr[higher][1];
        int i = (lower-1);
        int j=lower;

        while(j<higher) {
            if (arr[j][1] < pivot) {
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }

        int[] temp = arr[i+1];
        arr[i+1] = arr[higher];
        arr[higher] = temp;

        return i+1;
    }

    /**
     * Sorts a two dimensional subarray by quicksort
     * */
    public void sort(int arr[][], int lower, int higher)
    {
        if (lower < higher)
        {
            int  splitPosition = partition(arr, lower, higher);
            sort(arr, lower,  splitPosition-1);
            sort(arr,  splitPosition+1, higher);
        }
    }
}
