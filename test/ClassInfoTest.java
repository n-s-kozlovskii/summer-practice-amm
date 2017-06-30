import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static ru.vsu.amm.labs.practice.reflect.ClassInfo.*;
import static ru.vsu.amm.labs.practice.reflect.ClassInfo.isInterface;

public class ClassInfoTest {
    private Map<Class<?>, Boolean> testData = new HashMap<>();
    private Map<ArrayList<Class<?>>, Boolean> testData2 = new HashMap<>();


    @Before
    public void setUp(){
        //interface
        testData.put(List.class, true);
        //functional interface
        testData.put(Runnable.class, true);
        //abstract class
        testData.put(Number.class, false);
        //plain class
        testData.put(Object.class, false);

        ArrayList<Class<?>> classes;

        classes = new ArrayList<>(2);
        classes.add(ArrayList.class);
        classes.add(List.class);
        testData2.put(classes, true);

        classes = new ArrayList<>(2);
        classes.add(BigDecimal.class);
        classes.add(Number.class);
        testData2.put(classes, false);
    }

    @Test
    public void testIsInterfaceCls(){
        boolean actual;
        for (Map.Entry<Class<?>, Boolean> entry: testData.entrySet()){
            actual = isInterface(entry.getKey());
            assertEquals(entry.getValue(), actual);
        }
    }

    @Test
    public void testIsInterfaceStr() throws ClassNotFoundException {
        boolean actual;
        for (Map.Entry<Class<?>, Boolean> entry: testData.entrySet()){
            actual = isInterface(entry.getKey().getCanonicalName());
            assertEquals(entry.getValue(), actual);
        }
    }

    @Test(expected = ClassNotFoundException.class)
    public void testIsInterfaceException() throws ClassNotFoundException {
        isInterface("");
    }

    @Test
    public void testIsInterfaceImplemented(){
        boolean actual;
        for (Map.Entry<ArrayList<Class<?>>, Boolean> entry: testData2.entrySet()){
            actual = isInterfaceImplemented(entry.getKey().get(0),entry.getKey().get(1));
            assertEquals(entry.getValue(), actual);
        }
    }

    @Test
    public void testIsInterfaceImplementedStr() throws ClassNotFoundException {
        boolean actual;
        for (Map.Entry<ArrayList<Class<?>>, Boolean> entry: testData2.entrySet()){
            actual = isInterfaceImplemented(entry.getKey().get(0).getCanonicalName(),entry.getKey().get(1).getCanonicalName());
            assertEquals(entry.getValue(), actual);
        }
    }

    @Test(expected = ClassNotFoundException.class)
    public void testIsInterfaceImplemented5() throws ClassNotFoundException {
        boolean actual = isInterfaceImplemented(ArrayList.class.getCanonicalName(), "");
        assertEquals(true, actual);
    }
}
