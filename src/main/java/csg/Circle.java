package csg;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Circle {

    private final double outerDiameter;
    private final double innerDiameter;
    private final double height;

    public Circle(double outerDiameter, double innerDiameter, double height) {
        this.outerDiameter = outerDiameter;
        this.innerDiameter = innerDiameter;
        this.height = height;
    }

    public Geometry3D getGeometry3D(JavaCSG csg) {
        Geometry2D outerCircle = csg.circle2D(outerDiameter / 2, 512);
        Geometry2D innerCircle = csg.circle2D(innerDiameter / 2, 512);
        Geometry2D ring = csg.difference2D(outerCircle, innerCircle);
        return csg.linearExtrude(height, false, ring);
    }
}




