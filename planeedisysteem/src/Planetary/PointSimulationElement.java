package Planetary;
import Geometry.Point;


public abstract class PointSimulationElement extends Point implements SimulationElement {
	PointSimulationElement(double x, double y){
		super(x, y);
	}
}
