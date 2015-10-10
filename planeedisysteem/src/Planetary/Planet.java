package Planetary;


public class Planet extends PointSimulationElement{
	
	private double omega;
	
	public Planet(double x, double y, double omega){
		super(x, y);
		this.omega = omega;
	}

	public double getomega(){
		return omega;
	}
	
	public void tick() {
		centre_rotate(omega);		
	}
}
