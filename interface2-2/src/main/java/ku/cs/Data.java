package ku.cs;

import java.util.Comparator;

public class Data {
    public static<T> void sort(T[] a, Comparator<T>com) {
        for (int i = 0 ; i < a.length - 1 ; i++) {
            int minPos = i;
            for (int j = i + 1 ; j < a.length ; j++) {
                if (com.compare(a[j], a[minPos]) < 0) {
                    minPos = j;
                }
            }

            T temp = a[minPos];
            a[minPos] = a[i];
            a[i] = temp;
        }
    }
}
