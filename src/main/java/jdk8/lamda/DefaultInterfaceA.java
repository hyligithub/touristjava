package jdk8.lamda;

/**
 * Created by lihuiyan on 2017/4/22.
 */
public interface DefaultInterfaceA {

    default void methodA(){
        System.out.println("this is methodA");
    }
}
