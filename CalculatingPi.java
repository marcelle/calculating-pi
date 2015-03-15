public class CalculatingPi {
	
	public static void main(String[] args) {
		polygonApprox(101);

		gaussLegendre(1);
		gaussLegendre(2);
		gaussLegendre(3);
	}	


	// polygon approximation: as the number of sides of a regular polygon increases
	// the perimeter approaches the length of a circle
	// using a unit circle, n * sin(180/n) -> pi as n -> infinity

	public static void polygonApprox(double sides) {
		System.out.println("Polygon approximation:");
		for (double n = 5; n < sides; n+=5) {
			double pi = n*Math.sin(Math.toRadians(360/n)); // but this is silly because you need pi to convert from degrees to radians
			System.out.println("For n = " + n + " pi = " + pi);
		}
	}

	// Gauss-Legendre algorithm http://en.wikipedia.org/wiki/Gauss–Legendre_algorithm

	// a_0 = 1 	b_0 = 1/sqrt(2)	 t_0 = 1/4  p_0 = 1
	// a_n+1 = (a_n + b_n)/2  b_n+1 = sqrt(a_n*b_n) t_n+1 = t_n - p_n(a_n - a_n+1)^2
	// p_n+1 = 2p_n

	// iterate until difference between a_n and b_n is "small enough" then calculate
	// pi ~~ (a + b)^2/(4*t)

	// the number of correct digits doubles each iteration

	public static void gaussLegendre(int iters) {
		double a = 1;
		double b = 1/Math.sqrt(2);
		double t = 1.0/4.0;
		double p = 1;
		//System.out.println(Math.pow(a + b, 2)/(4*t));

		// iterate
		for (int i = 0; i < iters; i++) {
			double a_next = (a + b)/2;
			double b_next = Math.sqrt(a*b);
			double t_next = t - p * Math.pow((a - a_next), 2);
			double p_next = 2 * p;

			a = a_next;
			b = b_next;
			t = t_next;
			p = p_next;
		}

		double pi = Math.pow((a + b), 2)/(4*t);
		System.out.println("Gauss-Legendre algorithm:");
		System.out.println("After " + iters + " iterations, pi = " + pi);

	}


}
