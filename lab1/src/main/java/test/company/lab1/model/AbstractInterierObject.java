package test.company.lab1.model;

public abstract class AbstractInterierObject {
    int x;
    int y;
    int height;
    boolean isHorizontal;

    AbstractInterierObject (int x, int y, int height, boolean isHorizontal){
        this.x = x;
        this.y = y;
        this.height = height;
        this.isHorizontal = isHorizontal;
    }
}
