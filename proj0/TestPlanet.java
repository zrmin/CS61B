public class TestPlanet {
	public static void main(String[] args) {
		testBody();
	}

	private static void checkEquals(double actual, double expected, String label, double eps) {
		if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
			System.out.println("PASS: " + label + ": Excepted " + expected + " and you gave " + actual);
		} else {
			System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
		}
	}

	private static void testBody() {
		System.out.println("Checking class Planet...");

		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
		Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");

		checkEquals(p1.calcForceExertedBy(p2), 133.4, "calcForceExertedBy()", 0.01);
	}
}
