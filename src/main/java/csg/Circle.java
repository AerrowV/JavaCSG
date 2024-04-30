package csg;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Circle {

    private final double brickSize;
    private final double diameter;
    private final double height;

    public Circle(double brickSize, double diameter, double height) {
        this.brickSize = brickSize;
        this.diameter = diameter;
        this.height = height;
    }

    public Geometry3D getGeometry3D(JavaCSG csg) {

        Geometry2D circle2D = getFinalCircle2D(csg);
        Geometry3D res = csg.linearExtrude(height, false, circle2D);

        return res;

    }

    private Geometry2D getCircle2D(JavaCSG csg) {

        double circleLength = Math.sqrt(diameter);
        Geometry2D circle = csg.circle2D(circleLength, 512);
        return circle;

    }
    private Geometry2D getCircleTwo2D(JavaCSG csg){

        Geometry2D circle = getCircle2D(csg);
        Geometry2D circle2 = getCircle2D(csg);
        Geometry2D intersected = csg.intersection2D(circle2, circle);
        return intersected;

    }

    private Geometry2D getFinalCircle2D(JavaCSG csg) {


        Geometry2D circle = getCircleTwo2D(csg);
        Geometry2D bound = csg.circle2D(diameter, 512);
        circle = csg.intersection2D(circle, bound);

        return circle;
    }

}



