package etc;
class Integral {
	public interface FofX {
		double eval(double x);
	}

	static final int LEFT_POINT = 0;
	static final int MID_POINT = 1;
	static final int RIGHT_POINT = 2;
	static double realAns = 1.0/3;

	static double integrate(FofX f, double a, double b, int interval, int point) {
		double sum = 0;
		double dx = (b - a) / interval;
		for (int i = 0; i < interval; i++) {
			switch (point) {
				case LEFT_POINT:
					sum += f.eval(a + i * dx) * dx;
					break;
				case MID_POINT:
					sum += f.eval(a + i * dx + dx / 2) * dx;
					break;
				case RIGHT_POINT:
					sum += f.eval(a + i * dx + dx) * dx;
					break;
			}
		}
		return sum;
	}

	static double[] integrate2(FofX f, double a, double b, int interval) {
		double sumL = 0, sumM = 0, sumR = 0;
		double d = b - a;
		double xi = 0;
		double factor = interval * (interval + 1) / 2;
		for (int i = 0; i < interval; i++) {
			double dxi = d * (interval - i) / factor;
			sumL += f.eval(xi) * dxi; // left point
			sumM += f.eval(xi + dxi / 2) * dxi; // mid point
			sumR += f.eval(xi + dxi) * dxi; // right point
			xi += dxi;
		}
		return new double[] { sumL, sumM, sumR };
	}

	static void calculateInterval1(FofX f, int point) {
		int interval = 1;
		double s = 0;
		double error = Math.abs(s - realAns);
		while (true) {
			if (error < 0.001) {
				s = integrate(f, 0, 1, interval, point);
				System.out.printf("Interval: %d%n", interval);
				System.out.printf("Error: %f%n", error);
				System.out.printf("S: %f%n", s);
				break;
			} else {
				s = integrate(f, 0, 1, interval, point);
				error = Math.abs(s - realAns);
				interval++;
			}
			
		}
	}

	static void calculateInterval2(FofX f, int point) {
		int interval = 1;
		double s2 = 0;
		double error = Math.abs(s2 - realAns);
		while (true) {
			if (error < 0.001) {
				s2 = integrate2(f, 0, 1, interval)[point];
				System.out.printf("Interval: %d%n", interval);
				System.out.printf("Error: %f%n", error);
				System.out.printf("S: %f%n", s2);
				break;
			} else {
				s2 = integrate2(f, 0, 1, interval)[point];
				error = Math.abs(s2 - realAns);
				interval++;
			}
			
		}
	}

	public static void main(String args[]) {
		FofX f = (x) -> x * x; // real answer = 1.0/3
		// FofX f = (x) -> Math.exp(x); // real answer = Math.exp(1) - 1

		System.out.println("Left point");
		calculateInterval1(f, LEFT_POINT);
		System.out.println();
		System.out.println("Middle point");
		calculateInterval1(f, MID_POINT);
		System.out.println();
		System.out.println("Right point");
		calculateInterval1(f, RIGHT_POINT);
		
		System.out.println("-".repeat(20));

		System.out.println("Left point");
		calculateInterval2(f, LEFT_POINT);
		System.out.println();
		System.out.println("Middle point");
		calculateInterval2(f, MID_POINT);
		System.out.println();
		System.out.println("Right point");
		calculateInterval2(f, RIGHT_POINT);
	}
}