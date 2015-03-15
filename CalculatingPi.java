public class CalculatingPi {
	
	public static void main(String[] args) {
		polygonApprox(101);

		gaussLegendre(1);
		gaussLegendre(2);
		gaussLegendre(3);


		gregoryLeibniz(1000);
	}	


	// polygon approximation: as the number of sides of a regular polygon increases
	// the perimeter approaches the length of a circle
	// using a unit circle, n * sin(180/n) -> pi as n -> infinity

	public static void polygonApprox(double sides) {
		System.out.println("Polygon approximation:");
		for (double n = 5; n < sides; n+=5) {
			double pi = n*Math.sin(Math.toRadians(180/n)); // but this is silly because you need pi to convert from degrees to radians
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
		System.out.println(iters + " iterations: pi = " + pi);

	}
	// solid page http://mathworld.wolfram.com/PiFormulas.html
	// Gregory and Leibniz: slow converging
	// pi/4 = sum from k = 1 to infinity of (-1)^k+1/(2*k-1) = 1-1/3+1/5-...

	public static void gregoryLeibniz(int iters) {
		System.out.println("Gregory Leibniz method:");
		double quarterPi = 0.0;
		for (int k = 1; k <= iters; k++) {
			quarterPi += ( Math.pow(-1, k+1) / (2*k - 1) );
		}
		System.out.println(iters + " iterations: " + quarterPi*4);
	}



	// Sum of squares: https://www.math.hmc.edu/funfacts/ffiles/20001.2-5.shtml
	// let A(N) be the average number of ways the first N numbers 
	// can be written as the sum of two squares
	// take the limit of A(N) as N -> infinity, which represents the average
	// number of ways to write a number as the sum of two squares over all positive integers
	// this limit is pi ... WAT!!!

	// proof: think of every solution (x,y) to x^2+y^2 = N as a lattice point on the plane.
	// each of these points lies on a circle of radius sqrt(N) (because of the eqn of a circle)
	// as N -> infinity the number of lattice points inside the circle is approximately the area
	// of the circle
	public static void sumOfSquares() {
		// turns out calculating A(N) is non-trivial
		// not happening right now
	}


}
