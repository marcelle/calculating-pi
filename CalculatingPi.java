public class CalculatingPi {
	
	public static void main(String[] args) {
		polygonApprox(101);
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


}
