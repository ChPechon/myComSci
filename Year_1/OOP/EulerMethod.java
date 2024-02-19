public class EulerMethod {
    public static void main(String[] args) {
        double x0 = 0;
        double y0 = 3;

        double[] h = {1, 0.1, 0.001, 0.0001};

        double[] n = new double[4];
        for (int i = 0; i < 4; i++)
            n[i] = (int) ((1 - x0) / h[i]);

        double[] x = new double[4];
        double[] y = new double[4];
        for (int i = 0; i < 4; i++) {
            x[i] = x0;
            y[i] = y0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n[i]; j++) {
                y[i] += h[i] * (6 * Math.pow(x[i], 2) - 3 * Math.pow(x[i], 2) * y[i]);
                x[i] += h[i];
            }
            System.out.println("h = "+ h[i] + ", y(1) = " + y[i]);
        }
    }
}
