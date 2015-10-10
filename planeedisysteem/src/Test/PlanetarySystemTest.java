package Test;

import Planetary.Planet;
import Planetary.PlanetarySystem;
import Planetary.PointPlanetarySystem;
import Planetary.PointSimulationElement;
import Planetary.SimulationElement;
import junit.framework.TestCase;


public class PlanetarySystemTest extends TestCase {
	
	public void testSimple(){
		PlanetarySystem<SimulationElement> ps = new PlanetarySystem<SimulationElement>();
		Planet p1 = new Planet(1.0, 0.0, 0.1);
		ps.append(p1);
		PointPlanetarySystem<Planet> ps_komponent = new PointPlanetarySystem<Planet>();
		Planet p2 = new Planet(1.0, 1.0, 0.1);
		ps_komponent.append(p2);
		ps_komponent.append(new Planet(2.0, 1.0, 0.1));
		assertEquals(1.0, ps_komponent.distance(0, 1), 0.0001);
		ps.append(ps_komponent);
		ps.tick();
		assertEquals(0.1, p1.gettheta(), 0.0001);
		//assertEquals(0.1, ps.getElement(0).gettheta(), 0.0001);
		assertEquals((Math.PI/4)+0.1, ps_komponent.getElement(0).gettheta(), 0.0001);
		assertEquals(0.1, ps_komponent.getElement(0).getomega(), 0.0001);
		ps_komponent.append(new Planet(2.0, 1.0, 0.1));
	}

}
