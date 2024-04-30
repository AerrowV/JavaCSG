package csg;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JavaCSG csg = JavaCSGFactory.createNoCaching();

        Cross cross = new Cross(30,5,3);
        Circle circle = new Circle(20,10, 3);
        Board board = new Board(90, 10, 3);

        Geometry3D bor = board.getBoardGeometry(csg);
        Geometry3D res = cross.getGeometry3D(csg);
        Geometry3D circleRes = circle.getGeometry3D(csg);

        csg.view(bor);
        // csg.view(res);
        // csg.view(circleRes);

        /*

        List<Vector2D> vertices = new ArrayList<Vector2D>();
        vertices.add(csg.vector2D(0,0));
        vertices.add(csg.vector2D(2,0));
        vertices.add(csg.vector2D(2,3));
        vertices.add(csg.vector2D(1,2));
        vertices.add(csg.vector2D(0,3));

        Geometry2D thing = csg.polygon2D(vertices);
        thing = csg.scale2D(10,10).transform(thing);
        thing = csg.translate2DX(10).transform(thing);

        Geometry3D thing3D = csg.linearExtrude(5,false, thing);
        Geometry3D thingRotated = csg.rotateExtrude(csg.degrees(360), 32, thing);

        csg.view(thingRotated);

        */

        /*

        Geometry3D box = csg.box3D(10, 20, 30, true);
        Geometry3D sphere = csg.sphere3D(20, 512, true);
        Geometry3D cone = csg.cone3D(10,20,30, 256, true);
        box = csg.union3D(box, sphere, cone);
        csg.view(box);

        */


    }
}