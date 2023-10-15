package ku.cs;

public class Data {
    public static double min (Object[] objects, Measurer meas) {
        double min = meas.measure(objects[0]);
        for (Object obj : objects) {
            if (meas.measure(obj) < min) {
                min = meas.measure(obj);
            }
        }
        return min;
    }
}
