package Geometry;

public class Point {
	
	private double rho;
	private double theta;
	
	public Point(){
		rho = 0.0;
		theta = 0.0;
	}
		
	public Point(double x,  double y){
		setfromxy(x, y);
	}
	
	private void setfromxy(double x, double y){
		rho = Math.sqrt(x*x + y*y);
		theta = Math.atan2(y, x);
	}
	
	public double getx(){
		return getrho() * Math.cos(gettheta());
	}
	
	public double gety(){
		return getrho() * Math.sin(gettheta());
	}
	
	public double getrho(){
		return rho; 
	}
	
	public double gettheta(){
		return theta;
	}
	
	public Point vectorTo(Point p){
		return new Point(p.getx() - getx(), p.gety() - gety());
	}
	
	public double distance(Point p) {
		return vectorTo(p).getrho(); 
	}
	
	public void translate(double dx, double dy){
		double x = getx() + dx;
		double y = gety() + dy;
		setfromxy(x, y);
	}
	
	public void scale(double factor){
		rho *= factor;
	}
	
	public void centre_rotate(double angle){
		theta += angle;
	}
	
	public void rotate(Point p, double angle){
		translate(-p.getx(), -p.gety());
		centre_rotate(angle);
		translate(p.getx(), p.gety());
	}
}