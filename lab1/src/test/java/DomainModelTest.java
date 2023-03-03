import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.company.lab1.model.BodyPart;
import test.company.lab1.model.Emotion;
import test.company.lab1.model.Person;

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

}
