package jdk8.lamda;

import org.junit.Test;

import java.io.*;
import java.util.function.Predicate;

/**
 * Created by lihuiyan on 2017/4/20.
 */
public class SerializablePredicateFilterTest {

    private String VALUE = "Bob";

    public interface SerializablePredicate<T> extends Predicate<T>, Serializable {
    }

    public <T> void filer(SerializablePredicate<T> sp, T value) throws IOException, ClassNotFoundException {
        sp.getClass().isLocalClass();

        File tempFile = File.createTempFile("lamda", "set");

        try (ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            oo.writeObject(sp);
        }

        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(tempFile))) {
            SerializablePredicate<T> p = (SerializablePredicate<T>) oi.readObject();
            System.out.println(p.test(value));
        }
    }

    @Test(expected = NotSerializableException.class)
    public void testAnonymousDirect() throws IOException, ClassNotFoundException {
        final String value = VALUE;

        filer(new SerializablePredicate<String>() {
            public boolean test(String s) {
                return value.length() > s.length();
            }
        }, "Bob");
    }

    public static void main(String[] args) {
    }
}
