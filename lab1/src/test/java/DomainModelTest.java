import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.company.lab1.model.*;

import java.util.ArrayList;
import java.util.Optional;

public class DomainModelTest {

    @BeforeAll
    static void init(){

    }

    @Test
    @DisplayName("Тест для проверки инициализации человека без координат")
    void fordWithoutCoordinatesTest(){
        Person person = new Person("Форд");
        Assertions.assertEquals(person.getX(), 0);
        Assertions.assertEquals(person.getX(), 0);
        Assertions.assertEquals(person.getEmotions(), new ArrayList<Emotion>());
        Optional<BodyPart> head = person.getBodyParts().stream().filter((a)->a.getName().equals("Голова")).findFirst();
        Assertions.assertTrue(head.isPresent());
        Assertions.assertEquals(head.get().getHeight(), 180);
    }

    @Test
    @DisplayName("Тест для проверки инициализации человека без координат с объектами интерьера")
    void fordWithoutCoordinatesWithInterierObjectsTest() throws Exception {
        Person person = new Person("Форд");
        Floor floor = new Floor(10, 20, 0);
        Assertions.assertEquals(person.moveBodyPart("Левая Нога", 10, 0, 10), "Body part \"Левая Нога\" moved into: x=10 y=0 height=10");
        Optional<BodyPart> leftLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Нога")).findFirst();
        Assertions.assertTrue(leftLeg.isPresent());
        Assertions.assertEquals(floor.isTouch(leftLeg.get()), "Левая Нога cannot find the floor");
    }

    @Test
    @DisplayName("Тест для проверки эмоций человека")
    void fordWithEmotions() throws Exception {
        Person person = new Person("Форд");
        person.setEmotions(Event.createEmotions("Нечто"));
        Assertions.assertEquals(person.emotionAnalyze(), "Emotions mixed up in porridge");
        Assertions.assertThrows(Exception.class, () -> Event.createEmotions("Уля-ля!"));
    }

    @Test
    @DisplayName("Тест для проверки присутствия всех конечностей у человека")
    void fordAllBodyParts() {
        Person person = new Person("Форд");
        Optional<BodyPart> leftLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Нога")).findFirst();
        Optional<BodyPart> rightLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Нога")).findFirst();
        Optional<BodyPart> leftArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Рука")).findFirst();
        Optional<BodyPart> rightArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Рука")).findFirst();
        Optional<BodyPart> head = person.getBodyParts().stream().filter((a)->a.getName().equals("Голова")).findFirst();

        Assertions.assertTrue(leftLeg.isPresent(), "Левая нога отсутствует!");
        Assertions.assertTrue(rightLeg.isPresent(), "Правая нога отсутствует!");
        Assertions.assertTrue(leftArm.isPresent(), "Левая рука отсутствует!");
        Assertions.assertTrue(rightArm.isPresent(), "Правая рука отсутствует!");
        Assertions.assertTrue(head.isPresent(), "Голова отсутствует!");

    }

    @Test
    @DisplayName("Тест для проверки касания потолка до и после телодвижений")
    void fordIsTouchingCelling() throws Exception {
        Person person = new Person("Форд");
        Optional<BodyPart> leftLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Нога")).findFirst();
        Optional<BodyPart> rightLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Нога")).findFirst();
        Optional<BodyPart> leftArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Рука")).findFirst();
        Optional<BodyPart> rightArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Рука")).findFirst();
        Optional<BodyPart> head = person.getBodyParts().stream().filter((a)->a.getName().equals("Голова")).findFirst();


        InterierObject celling = new Ceiling(30,30,300);

        Assertions.assertEquals(celling.isTouch(leftLeg.get()), leftLeg.get().getName() + " cannot find ceiling");
        Assertions.assertEquals(celling.isTouch(rightLeg.get()), rightLeg.get().getName() + " cannot find ceiling");
        Assertions.assertEquals(celling.isTouch(leftArm.get()), leftArm.get().getName() + " cannot find ceiling");
        Assertions.assertEquals(celling.isTouch(rightArm.get()), rightArm.get().getName() + " cannot find ceiling");
        Assertions.assertEquals(celling.isTouch(head.get()), head.get().getName() + " cannot find ceiling");

        person.moveBodyPart(leftLeg.get().getName(),10,10,300);
        person.moveBodyPart(rightLeg.get().getName(),20,10,300);
        person.moveBodyPart(leftArm.get().getName(),10,10,530);
        person.moveBodyPart(rightArm.get().getName(),20,10,530);
        person.moveBodyPart(head.get().getName(),15,10,480);

        Assertions.assertEquals(celling.isTouch(leftLeg.get()), leftLeg.get().getName() + " is touching the ceiling");
        Assertions.assertEquals(celling.isTouch(rightLeg.get()), rightLeg.get().getName() + " is touching the ceiling");
        Assertions.assertEquals(celling.isTouch(leftArm.get()), leftArm.get().getName() + " is touching the ceiling");
        Assertions.assertEquals(celling.isTouch(rightArm.get()), rightArm.get().getName() + " is touching the ceiling");
        Assertions.assertEquals(celling.isTouch(head.get()), head.get().getName() + " is touching the ceiling");

    }


    @Test
    @DisplayName("Тест для проверки касания пола до и после телодвижений")
    void fordIsTouchingFloor() throws Exception {
        Person person = new Person("Форд");
        Optional<BodyPart> leftLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Нога")).findFirst();
        Optional<BodyPart> rightLeg = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Нога")).findFirst();
        Optional<BodyPart> leftArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Левая Рука")).findFirst();
        Optional<BodyPart> rightArm = person.getBodyParts().stream().filter((a)->a.getName().equals("Правая Рука")).findFirst();
        Optional<BodyPart> head = person.getBodyParts().stream().filter((a)->a.getName().equals("Голова")).findFirst();

        InterierObject floor = new Floor(30,30,0);

        Assertions.assertEquals(floor.isTouch(leftLeg.get()), leftLeg.get().getName() + " is touching the floor");
        Assertions.assertEquals(floor.isTouch(rightLeg.get()), rightLeg.get().getName() + " is touching the floor");
        Assertions.assertEquals(floor.isTouch(leftArm.get()), leftArm.get().getName() + " cannot find the floor");
        Assertions.assertEquals(floor.isTouch(rightArm.get()), rightArm.get().getName() + " cannot find the floor");
        Assertions.assertEquals(floor.isTouch(head.get()), head.get().getName() + " cannot find the floor");


        person.moveBodyPart(leftLeg.get().getName(),10,10,20);
        person.moveBodyPart(rightLeg.get().getName(),20,10,20);
        person.moveBodyPart(leftArm.get().getName(),10,10,-220);
        person.moveBodyPart(rightArm.get().getName(),20,10,-220);
        person.moveBodyPart(head.get().getName(),15,10,-160);


        Assertions.assertEquals(floor.isTouch(leftLeg.get()), leftLeg.get().getName() + " cannot find the floor");
        Assertions.assertEquals(floor.isTouch(rightLeg.get()), rightLeg.get().getName() + " cannot find the floor");
        Assertions.assertEquals(floor.isTouch(leftArm.get()), leftArm.get().getName() + " is touching the floor");
        Assertions.assertEquals(floor.isTouch(rightArm.get()), rightArm.get().getName() + " is touching the floor");
        Assertions.assertEquals(floor.isTouch(head.get()), head.get().getName() + " is touching the floor");
    }


}
