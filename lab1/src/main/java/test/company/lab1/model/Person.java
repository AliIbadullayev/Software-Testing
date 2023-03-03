package test.company.lab1.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Emotion> emotions;
    private final List<BodyPart> bodyParts;
    private String name;
    private int x;
    private int y;
    private int height;

    public Person(String name){
        this.name = name;
        bodyParts = new ArrayList<BodyPart>();
        emotions = new ArrayList<Emotion>();
        x=0;
        y=0;
        height=180;
        initBodyPart("Голова", 0, 0, 180);
        initBodyPart("Правая Рука", 10, 0, (180-20)/2);
        initBodyPart("Левая Рука", -10, 0, (180-20)/2);
        initBodyPart("Правая Нога", 10, 0, 0);
        initBodyPart("Левая Нога", -10, 0, 0);
    }

    Person (String name, int x, int y, int height){
        this.name = name;
        bodyParts = new ArrayList<BodyPart>();
        emotions = new ArrayList<Emotion>();
        this.x=x;
        this.y=y;
        this.height=height;
        initBodyPart("Голова", x, y, height);
        initBodyPart("Правая Рука", x+10, y, (height-20)/2);
        initBodyPart("Левая Рука", x-10, y, (height-20)/2);
        initBodyPart("Правая Нога", x+10, y, 0);
        initBodyPart("Левая Нога", x-10, y, 0);
        emotionAnalyze();
    }

    Person (String name, int x, int y, int height, String event) throws Exception {
        this.name = name;
        bodyParts = new ArrayList<BodyPart>();
        emotions = new ArrayList<Emotion>();
        this.x=x;
        this.y=y;
        this.height=height;
        initBodyPart("Голова", x, y, height);
        initBodyPart("Правая Рука", x+10, y, (height-20)/2);
        initBodyPart("Левая Рука", x-10, y, (height-20)/2);
        initBodyPart("Правая Нога", x+10, y, 0);
        initBodyPart("Левая Нога", x-10, y, 0);
        Event.createEmotions(event);
        emotionAnalyze();
    }

    public String moveBodyPart(String name, int x, int y, int height) throws Exception {
//        TODO add logic to move body parts inside the room if (height = )
        for (int i = 0; i < bodyParts.size(); i++){
            BodyPart bodyPart;
            if ((bodyPart = bodyParts.get(i)).getName().equals(name)){
                bodyPart.setX(x);
                bodyPart.setY(y);
                bodyPart.setHeight(height);
                return "Body part \"" + name + "\" moved into: x=" + x + " y=" + y + " height=" + height;
            }
        }
        throw new Exception("Cannot found body part \""+name+"\"");
    }

    private String initBodyPart(String name, int x, int y, int height){
        BodyPart bodyPart = new BodyPart(name, x, y, height);
        bodyParts.add(bodyPart);
        return "Body part \"" + name + "\" initialized in: x=" + x + " y=" + y + " height=" + height;
    }

    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public String emotionAnalyze(){
        int count = 0;
        for (Emotion emotion: emotions){
            if (emotion.getExpression().equals("ПОТРЯСЕНИЕ")||emotion.getExpression().equals("УДИВЛЕНИЕ")){
                count++;
            }
        }
        if (count >= 5) return "Emotions mixed up in porridge";
        else return "Count of emotions of shock and surprise: " + count;
    }


    public List<Emotion> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<Emotion> emotions) {
        this.emotions = emotions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
