package test.company.lab1.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Event {

//    private Event (String event) throws Exception {
//        List<Emotion> emotions = createEmotions(event);
//    }

    public static List<Emotion> createEmotions(String event) throws Exception {
        List<Emotion> emotions = new ArrayList<Emotion>();
        if (event.equals("Нечто")) {
            emotions.add(Emotion.ВЕСЕЛЬЕ);
            emotions.add(Emotion.БОЛЬ);
            emotions.add(Emotion.ВОСХИЩЕНИЕ);
            emotions.add(Emotion.ОТВРАЩЕНИЕ);
            emotions.add(Emotion.СМУЩЕНИЕ);
            emotions.add(Emotion.СТРАХ);
            return emotions;
        } else if (event.equals("Упал с велосипеда")) {
            emotions.add(Emotion.СТРАХ);
            emotions.add(Emotion.БОЛЬ);
            emotions.add(Emotion.ОТВРАЩЕНИЕ);
            emotions.add(Emotion.ПЕЧАЛЬ);
            emotions.add(Emotion.ТРЕВОГА);
            emotions.add(Emotion.УДИВЛЕНИЕ);
            return emotions;
        }
        throw new Exception("Cannot find event \"" + event + "\"");
    }
}
