/**
 * Author: zrmin
 * Date: 2023.4.10
 * Description: A Planet class
 * The Body class should not have a main method, because we'll never run the Body class directly
 * Also, all methods should be non-static
 * All of the numbers for this project will be doubles
 * All instance variables and menthods will be declared using the public keyword
*/

public class Planet {
	public double xxPos; // Its current x position
	public double yyPos; // Its current y position
	public double xxVel; // Its current velocity in the x direction
	public double yyVel; // Its current velocity in the y direction
	public double mass; // Its mass
	public String imgFileName; // The name of the file that corresponds to the image that depicts the body

	public final double G = 6.67 * 1e-11;

	/**
	 * Constructor1
	*/
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	/*
	 * Constructor2
	 */
	public Planet(Planet b) {
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	/**
	 * calcDistance
	 * @Parm p: the instance of the Planet class
	 * @ret distance: the distance between p and the caller
	 */
	public double calcDistance(Planet p) {
		double dx = Math.abs(this.xxPos - p.xxPos),
		       dy = Math.abs(this.yyPos - p.yyPos);

		double distance = Math.sqrt(dx * dx + dy * dy);
		
		return distance;
	}

	/**
	 * calcForceExertedBy
	 * @para p: the instance of the Planet class
	 * @ret force: the force that the caller exerted on p
	 */
	public double calcForceExertedBy(Planet p) {
		double r = this.calcDistance(p);
		double force = G * this.mass * p.mass / (r * r);
		
		return force;
	}

	/**
	 * calcForceExertedByX
	 * @para p: the instance of the Planet class
	 * @ret: return the force that exerted by the x axies
	 */
	public double calcForceExertedByX(Planet p) {
		return calcForceExertedBy(p) * ((p.xxPos - this.xxPos) / calcDistance(p));
	}

	/**
	 * calcForceExertedByY
	 * @para p: the instance of the Planet class
	 * @ret: return the force that exerted by the y axies
	 */
	public double calcForceExertedByY(Planet p) {
		return calcForceExertedBy(p) * ((p.yyPos - this.yyPos) / calcDistance(p));
	}

	/**
	 * calcNetForceExertedByX
	 * @param allPlanets: the array of planets
	 */
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double Fx = 0.0;

		for (Planet p : allPlanets) {
			if (this.xxPos == p.xxPos && this.yyPos == p.yyPos && this.xxVel == p.xxVel && this.yyVel == p.yyVel && this.mass == p.mass) continue; // if the comparations returns true, 
							// that means allPlanets[i] == this, 
							// this should be skipped, because a 
							// planet have no Force to itself.
			else Fx += this.calcForceExertedByX(p);
		}

		return Fx;
	}

        /**
	 * calcNetForceExertedByY
	 * @param allPlanets: the array of planets
	 */
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double Fy = 0.0;
		
		for (int i = 0; i < allPlanets.length; ++i) {
			if (this.xxPos == allPlanets[i].xxPos && this.yyPos == allPlanets[i].yyPos && this.xxVel == allPlanets[i].xxVel && this.yyVel == allPlanets[i].yyVel && this.mass == allPlanets[i].mass) continue;
			else Fy += allPlanets[i].calcForceExertedByY(this);
		}
		return Fy;
	}

	/**
	 * update
	 * @param dt: the time the force used
	 * @param fx: the force on the x axies
	 * @param fx: the force on the y axies
	 */
	public void update(double dt, double fx, double fy) {
		// Calculate the acceleration using the provided x- and y- forces
		double ax = fx / this.mass,
		       ay = fy / this.mass;

		// Calculate the new velocity by using the acceleartion and current velocity
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;

		// Calculate the new position by using the velocity computed in step2 and 
		// the current position
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	/**
	 * draw : A planet to be able to draw itself at its appropriat position.
	 * @param none
	 */
	public void draw() {
		String imgPath = "images/";
		imgPath += imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imgPath);
	//	StdDraw.show(); // invoke show() in file NBody.java
	}

}
