package test.company.lab1.model;

public class BodyPart {
    private int x;
    private int y;
    private int height;
    private String name;

    BodyPart (String name, int x, int y, int height){
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
