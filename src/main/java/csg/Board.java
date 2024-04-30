package csg;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Board {
    private final double size;
    private final double wallHeight;
    private final double wallThickness;

    public Board(double size, double wallHeight, double wallThickness) {
        this.size = size;
        this.wallHeight = wallHeight;
        this.wallThickness = wallThickness;
    }

    public Geometry3D getBoardGeometry(JavaCSG csg) {
        Geometry3D base = createBase(csg);
        Geometry3D walls = createWalls(csg);
        Geometry3D grid = createGrid(csg);

        return csg.union3D(base, walls, grid);
    }

    private Geometry3D createBase(JavaCSG csg) {
        Geometry3D base = csg.box3D(size, size, 1, true);
        return csg.translate3D(0, 0, 0.5).transform(base);
    }

    private Geometry3D createWalls(JavaCSG csg) {
        Geometry3D leftWall = csg.box3D(wallThickness, size + 2 * wallThickness, wallHeight, true);
        Geometry3D translatedLeftWall = csg.translate3D(-size / 2 - wallThickness / 2, 0, wallHeight / 2).transform(leftWall);

        Geometry3D rightWall = csg.box3D(wallThickness, size + 2 * wallThickness, wallHeight, true);
        Geometry3D translatedRightWall = csg.translate3D(size / 2 + wallThickness / 2, 0, wallHeight / 2).transform(rightWall);

        Geometry3D topWall = csg.box3D(size, wallThickness, wallHeight, true);
        Geometry3D translatedTopWall = csg.translate3D(0, size / 2 + wallThickness / 2, wallHeight / 2).transform(topWall);

        Geometry3D bottomWall = csg.box3D(size, wallThickness, wallHeight, true);
        Geometry3D translatedBottomWall = csg.translate3D(0, -size / 2 - wallThickness / 2, wallHeight / 2).transform(bottomWall);

        return csg.union3D(translatedLeftWall, translatedRightWall, translatedTopWall, translatedBottomWall);
    }

    private Geometry3D createGrid(JavaCSG csg) {
        double gridThickness = 0.1;
        double gridHeight = 5;
        double gridZPosition = 1;

        Geometry3D gridLine1 = csg.box3D(size, gridThickness, gridHeight, true);
        Geometry3D gl1 = csg.translate3D(0, -size / 6, gridZPosition + gridHeight / 2).transform(gridLine1);

        Geometry3D gridLine2 = csg.box3D(size, gridThickness, gridHeight, true);
        Geometry3D gl2 = csg.translate3D(0, size / 6, gridZPosition + gridHeight / 2).transform(gridLine2);

        Geometry3D gridLine3 = csg.box3D(gridThickness, size, gridHeight, true);
        Geometry3D gl3 = csg.translate3D(-size / 6, 0, gridZPosition + gridHeight / 2).transform(gridLine3);

        Geometry3D gridLine4 = csg.box3D(gridThickness, size, gridHeight, true);
        Geometry3D gl4 = csg.translate3D(size / 6, 0, gridZPosition + gridHeight / 2).transform(gridLine4);

        return csg.union3D(gl1, gl2, gl3, gl4);
    }
}
