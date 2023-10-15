package ku.cs;

public class Data {
    public static double min(Measurable[] objs) {
        double min = objs[0].getMeasure();
        for (Measurable obj : objs) {
            if (obj.getMeasure() < min) {
                min = obj.getMeasure();
            }
        }
        return min;
    }
}
