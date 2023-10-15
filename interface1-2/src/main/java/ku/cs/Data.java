package ku.cs;

public class Data {
    public static void sort(Comparable[] a) {
        for (int i = 0 ; i < a.length - 1 ; i++) {
            int minPos = i ;
            for (int j = i + 1 ; j < a.length ; j++) {
                if (a[j].compareTo(a[minPos]) < 0) {
                    minPos = j;
                }
            }

            Comparable temp = a[minPos];
            a[minPos] = a[i];
            a[i] = temp;
        }
    }
}
