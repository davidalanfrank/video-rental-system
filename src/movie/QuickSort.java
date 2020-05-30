package movie;

public class QuickSort {

    private int partition(int arr[][], int low, int high)
    {
        int pivot = arr[high][1];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j][1] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int[] temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int[] temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
    public void sort(int arr[][], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    public static void printArray(int arr[][])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i][0]+" ");
            System.out.print(arr[i][1]+" ");
        }


        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[][] = {{0, 51}, {1, 282}, {2, 334}, {3, 502}, {4, 28}, {5, 3111}};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
