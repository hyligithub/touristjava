package jdk8.lamda;

/**
 * Created by lihuiyan on 2017/4/22.
 */
public interface DefaultInterfaceB extends DefaultInterfaceA {

    @Override
    default void methodA() {
        System.out.println("this is methodB ");
    }
}
