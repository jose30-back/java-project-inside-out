package dev.equipo3.insideout_java.models;

public enum Emotions {
    Joy, Sadness, Anger, Disgust, Fear, Anxiety, Envy, Shame, Boredom, Nostalgia;

    public static Emotions getByIndex(int index) {
        if (index < 1||index > values().length)
        return null;
        return values()[index -1];
    }
}