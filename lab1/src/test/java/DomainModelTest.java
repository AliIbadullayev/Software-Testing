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


}
