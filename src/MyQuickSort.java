import java.util.List;

/**
 * Class MyQuickSort allows to sort collections that implement the MyList interface
 */
public class MyQuickSort {
    /**
     * @param arr  collection to sort
     * @param low  left border of sorting area
     * @param high right border of sorting area
     */
    public static void sort(MyList arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
            List<Integer> list;
        }
    }

    private static <T> int partition(MyList<T> arr, int low, int high) {

        int middle = low + (high - low) / 2;
        T pivot = arr.get(middle);

        T temp = arr.get(middle);
        arr.set(middle, arr.get(high));
        arr.set(high, temp);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            int cmp = compare(arr.get(j), pivot);
            if (cmp < 0) {
                i++;

                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    private static <T> int compare(T val1, T val2) {
        return ((Comparable<? super T>) val1).compareTo(val2);
    }
}
