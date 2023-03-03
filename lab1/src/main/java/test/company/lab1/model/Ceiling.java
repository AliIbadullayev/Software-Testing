package test.company.lab1.model;

public class Ceiling extends AbstractInterierObject implements InterierObject{
    Ceiling (int x, int y, int height){
        super(x, y, height, true);
    }
    public String isTouch(BodyPart bodyPart) {
        if (bodyPart.getName().equals("Голова") && bodyPart.getHeight() >= height) {
            return bodyPart.getName() + " is touching the ceiling";
        }
        return bodyPart.getName() + " cannot find ceiling";
    }
}
