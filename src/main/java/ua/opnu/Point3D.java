package ua.opnu;

import ua.opnu.java.inheritance.geometry.Point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        this(0, 0, 0);
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return this.z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public double distance(Point3D p) {
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = z - p.z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(this.getX()*this.getX() + this.getY()*this.getY() + z*z);
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + z + ")";
    }
}
