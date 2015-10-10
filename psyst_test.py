import unittest
from planets import Planet, PlanetarySystem
import math


class PlanetTest(unittest.TestCase):
    def testSimple(self):
        p1 = Planet(5.0, 0.0, 0.1)
        self.assertAlmostEqual(p1.rho(), 5.0)
        self.assertAlmostEqual(p1.theta(), 0.0)
        p1.tick()
        self.assertAlmostEqual(p1.rho(), 5.0)
        self.assertAlmostEqual(p1.theta(), 0.1)


class PSTest(unittest.TestCase):
    def testSimple(self):
        ps = PlanetarySystem()
        ps.append(Planet(1.0, 1.0, 0.1))
        ps.append(Planet(-1.0, 1.0, 0.2))
        ps.append(Planet(1.2, 3.4, math.pi / 10))
        ps.tick()
        self.assertAlmostEqual(ps[0].theta(), math.pi / 4 + 0.1)
        self.assertAlmostEqual(ps[1].theta(), 3 * math.pi / 4 + 0.2)
        for i in range(19): ps.tick()
        self.assertAlmostEqual(ps[2].x(), 1.2)
        self.assertAlmostEqual(ps[2].y(), 3.4)


if __name__ == "__main__":
    unittest.main()
