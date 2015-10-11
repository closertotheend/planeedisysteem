package Test;
import Geometry.Point;
import Planetary.Planet;
import Planetary.SpaceShip;
import junit.framework.TestCase;


public class ShapeShipTest extends TestCase {
	public void testSimple(){
		SpaceShip ship = new SpaceShip(5.0, 5.0, 2,2);
		Planet planet = new Planet(5.0, 5.0, 0);
		assertEquals(0.0, ship.distance(planet), 0.0001);
		ship.tick();
		planet.tick();
		assertEquals(Math.sqrt(8), ship.distance(planet), 0.0001);
	}
}
