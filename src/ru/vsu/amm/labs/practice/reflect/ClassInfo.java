package ru.vsu.amm.labs.practice.reflect;

public class ClassInfo {

    /**
     * Определяет, является ли данный объект интерфейсом
     * @param cls объект для проверки
     * @return {@code true} если объект является интерфейсом, иначе {@code false}
     */
    public static boolean isInterface(Class<?> cls){
        return cls.isInterface();
    }

    /**
     * Определяет, является ли данный объект интерфейсом
     * @param cls имя класса, котрый нужно проверить
     * @return {@code true} если объект является интерфейсом, иначе {@code false}
     * @throws ClassNotFoundException
     */
    public static boolean isInterface(String cls) throws ClassNotFoundException {
        return Class.forName(cls).isInterface();
    }

    /**
     * Определяет, является ли {@code marker} интерфейсом, и если да, реализует ли
     * данный класс {@code cls} интерфейс  {@code marker}
     * @param cls класс для проверки
     * @param marker интерфейс, который мог бы реализовывать данный класс {@code cls}
     * @return {@code true} если {@code marker} является интерфейсом и {@code cls} реализует этот интерфейс,
     * иначе {@code false}
     */
    public static boolean isInterfaceImplemented(Class<?> cls, Class<?> marker){
        return isInterface(marker) && marker.isAssignableFrom(cls);
    }

    /**
     * Определяет, является ли {@code marker} интерфейсом, и если да, реализует ли
     * данный класс {@code cls} интерфейс  {@code marker}
     * @param cls имя класса для проверки
     * @param marker имя интерфейса, который мог бы реализовывать данный класс {@code cls}
     * @return
     * @throws ClassNotFoundException
     */
    public static boolean isInterfaceImplemented(String cls, String marker) throws ClassNotFoundException {
        Class<?> cls1 = Class.forName(cls);
        Class<?> aClass = Class.forName(marker);
        return isInterfaceImplemented(cls1, aClass);
    }



}
