package movie;

public class QuickSort {

    // Testing
    public static void main(String args[])
    {
        int arr[][] = {{0, 51}, {1, 282}, {2, 334}, {3, 502}, {4, 28}, {5, 3111}};
        int n = arr.length;

        QuickSort qSort = new QuickSort();
        qSort.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printSortedArray(arr);
    }

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

    public void sort(int arr[][], int lower, int higher)
    {
        if (lower < higher)
        {
            int  splitPosition = partition(arr, lower, higher);
            sort(arr, lower,  splitPosition-1);
            sort(arr,  splitPosition+1, higher);
        }
    }

    public static void printSortedArray(int array[][])
    {
        int n = array.length;
        for (int i=0; i<n; ++i){
            System.out.println(array[i][0]);
            System.out.println(array[i][1]);
        }
    }


}
