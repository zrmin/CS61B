/**
 * Use the class name 'NBody' just as the project paper says
 * the function name 'readPlanets' is not as the paper said 'readBodies'
 */
public class NBody {
	public static double readRadius(String path) {
		In in = new In(path);
		
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);

		int n = in.readInt();

		Planet[] arr = new Planet[n];

		double radius = in.readDouble();

		for (int i = 0; i < n; ++i) {
			Planet p = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
			arr[i] = p;
		}

		return arr;
	}

	public static void main(String[] args) {
		// /*
		if (args.length < 3) {
			System.out.println("the number of args not satisfied!");
			return ;
		}

		// Collecting All Needed Input
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		double radius = readRadius(filename);
		Planet[] arr = readPlanets(filename);
		int numberOfPlanets = arr.length;

		// Enable double buffering
		StdDraw.enableDoubleBuffering();

		double time = 0.0;
		while (time <= T) {
			double[] xForcesArr = new double[numberOfPlanets]; // 不把数组长度写死，写死的话扩展性不好
			double[] yForcesArr = new double[numberOfPlanets];
			
			// Calculate the net x and y forces for each Body
			for (int i = 0; i < numberOfPlanets; ++i) {
				xForcesArr[i] = arr[i].calcNetForceExertedByX(arr);
				yForcesArr[i] = arr[i].calcNetForceExertedByY(arr);
			}

			/**
			 * Do not make any calls to 'update' until forces have been calculated
			 * and safely stored in xForcesArr and yForcesArr
			 * if xForcesArr[i] be updated, the calculation on xForcesArr[j] will be 
			 * influenced.
			 */

			// call update on each of the Planets
			for (int i = 0; i < numberOfPlanets; ++i) {
				arr[i].update(dt, xForcesArr[i], yForcesArr[i]);
			}



			// Drawing the Background
			// Sets up the universe so it goes from -100, -100 up to 100, 100
			StdDraw.setScale(-radius, radius); // 我之前用-100, 100，导致只能加载出来sun，其他的都
							// 加载不出来，我应该用radius，因为这才是宇宙的半径
							// 结合data/planets.txt就知道为什么只能加载出sun了
							// 因为sun的坐标为(0, 0)，而其他的坐标都超过100的范围了。
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			StdDraw.show();
	
			// Drawing More than one Planet
	/*		for (Planet P : arr) {  报错说找不到符号p，我知道了，我这行是P，下面是p，大小写不一致
				p.draw();
			}
	*/
			// Draw all the planets
			for (int i = 0; i < arr.length; ++i)  {
				arr[i].draw(); // Show the picture of the planet
			}

			// Show the offscreen buffer
			StdDraw.show();
			StdDraw.pause(10);
			// Increase the time variable ty 'dt'
			time += dt;
		}

		StdOut.printf("%d\n", arr.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < numberOfPlanets; ++i) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					arr[i].xxPos, arr[i].yyPos, arr[i].xxVel,
					arr[i].yyVel, arr[i].mass, arr[i].imgFileName);
		}
	}
}
