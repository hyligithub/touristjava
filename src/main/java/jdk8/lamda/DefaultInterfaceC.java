package jdk8.lamda;

/**
 * Created by lihuiyan on 2017/4/22.
 */
public class DefaultInterfaceC implements DefaultInterfaceA{

    @Override
    public void methodA(){
            DefaultInterfaceA.super.methodA();
    }
    public static void main(String[] args){
        DefaultInterfaceC dc = new DefaultInterfaceC();
        dc.methodA();
    }
}
