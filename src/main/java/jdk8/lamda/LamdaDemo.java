package jdk8.lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lihuiyan on 2017/4/24.
 */
public class LamdaDemo {

    public static void main(String[] args) {
//        threadByLamda();
        actionByLamda();

    }

    /**
     * lamda 实现 Runnable
     */
    public static void threadByLamda() {
        //prio 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a annoymous Runnale");
            }
        }).start();

        //jdk 8
        new Thread(() -> System.out.println("this is lamda Runnable")).start();
    }

    /**
     * lamda进行事件处理，应用中暂时想不出事件的好例子，用comparator来代替
     */
    public static void actionByLamda() {
        Integer[] arrays = {4, 2, 5, 7, 9};
        Arrays.sort(arrays, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("before jdk 8: " + Arrays.asList(arrays).toString());


        Arrays.sort(arrays, (n1, n2) -> n1 - n2);
        System.out.println("in jdk 8" + Arrays.asList(arrays).toString());


        Employee[] employees = new Employee[3];
        employees[0] = new Employee(3, "Ranaldo", 33);
        employees[1] = new Employee(1, "kaka", 31);
        employees[2] = new Employee(2, "jordan", 40);

        Arrays.sort(employees, Employee.comparatorById);
        System.out.println("comparatorById==" + Arrays.toString(employees));
        Arrays.sort(employees, Employee.comparatorByName);
        System.out.println("comparatorByName==" + Arrays.toString(employees));
        Arrays.sort(employees, Employee.comparatorByAge);
        System.out.println("comparatorByAge==" + Arrays.toString(employees));

        Arrays.sort(employees, (o1, o2) -> o1.getId() - o2.getId());
        System.out.println("comparatorById==" + Arrays.toString(employees));
        Arrays.sort(employees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("comparatorByName==" + Arrays.toString(employees));
        Arrays.sort(employees, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("comparatorByAge==" + Arrays.toString(employees));
    }

    /**
     * lamda实现迭代
     */
    @Test
    public void iteratorByLamda() {
        List<String> list = Arrays.asList("张三", "李四", "王五");
        System.out.println("before 8---------");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("in 8 -----");
        list.forEach(s -> System.out.println(s));

        Employee[] employees = new Employee[3];
        employees[0] = new Employee(3, "Ranaldo", 33);
        employees[1] = new Employee(1, "kaka", 31);
        employees[2] = new Employee(2, "jordan", 40);
        List<Employee> le = Arrays.asList(employees);
        le.forEach(System.out::println);//方法引用
    }

    /**
     * 函数式接口：只有一个抽象方法的接口
     * e.g：Runnable,1.8中的Predicate是新增的函数式接口，适合做过滤
     */
    @Test
    public void functionInterface() {
        List<String> names = Arrays.asList("java", "c++", "python", "guava", "groovy");
        filter(names, n -> n.startsWith("g"));
        filter(names, n -> n.endsWith("n"));
        filter(names, n -> true);
        filter(names, n -> false);
        System.out.println("length  >  3-----------");
        filter(names, n -> n.length() > 3);
    }

    private void filter(List<String> names, Predicate<String> predicate) {
        names.forEach(n -> {
            if (predicate.test(n)) System.out.println(n);
        });

        names.stream().filter(name -> predicate.test(name)).forEach(name -> System.out.println(name));
//        for (String name : names) {
//            if (predicate.test(name)) {
//                System.out.println(name);
//            }
//        }
    }
}

class Employee {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "id:" + id + ",name:" + name + ",age:" + age;
    }

    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    static Comparator<Employee> comparatorById = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getId() - o2.getId();
        }
    };

    static Comparator<Employee> comparatorByName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    static Comparator<Employee> comparatorByAge = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };
}
