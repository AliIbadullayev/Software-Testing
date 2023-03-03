package test.company.lab1.model;

public class Floor extends AbstractInterierObject implements InterierObject{
    Floor (int x, int y, int height){
        super(x, y, height, true);
    }
    public String isTouch(BodyPart bodyPart) {
            if (bodyPart.getHeight() <= height) {
                return bodyPart.getName() + " is touching the floor";
            }
        return bodyPart.getName() + " cannot find the floor";
    }

}
