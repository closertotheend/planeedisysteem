package Planetary;


public class SpaceShip extends PointSimulationElement {

    private double dx;
    private double dy;

    public SpaceShip(double x, double y, double dx, double dy) {
        super(x, y);
        this.dx = dx;
        this.dy = dy;
    }

    public void tick() {
        translate(dx, dy);
    }
}
