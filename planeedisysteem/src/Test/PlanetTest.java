package Test;
import Planetary.Planet;
import junit.framework.TestCase;


public class PlanetTest extends TestCase {
	public void testSimple(){
		Planet p = new Planet(1.0, 1.0, 0.1);
		Planet p2 = new Planet(4.0, 5.0, 0.2);
		assertEquals(5.0, p.distance(p2), 0.0001);
		p.tick();
		assertEquals(Math.PI/4 + 0.1, p.gettheta(), 0.0001);
	}
}
