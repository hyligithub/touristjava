package jdk8.lamda;

/**
 * Created by lihuiyan on 2017/4/22.
 */
public class Testlamda {
    /**
     * @param args (parameter)-> expression 或者(paramter)->{statments;}
     */
    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("this is a Runnable lamda")
        ).start();
    }
}
