package Planetary;


public class PointPlanetarySystem<T extends PointSimulationElement> extends PlanetarySystem<T>{

	
	public double distance(int i1, int i2){
		PointSimulationElement p1 = getElement(i1);
		PointSimulationElement p2 = getElement(i2);
		return p1.distance(p2);
	}

	
}
