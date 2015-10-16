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

	public void testCoordinates(){
		SpaceShip ship = new SpaceShip(5.0, 5.0, 2,3);
		Planet planet = new Planet(5.0, 5.0, 0);

		assertEquals(5, ship.getx(), 0.0001);
		assertEquals(5, ship.gety(), 0.0001);

		ship.tick();
		planet.tick();

		assertEquals(7, ship.getx(), 0.0001);
		assertEquals(8, ship.gety(), 0.0001);

		ship.tick();
		planet.tick();

		assertEquals(9, ship.getx(), 0.0001);
		assertEquals(11, ship.gety(), 0.0001);

	}
}
