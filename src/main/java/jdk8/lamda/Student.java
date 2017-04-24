package jdk8.lamda;

/**
 * Created by lihuiyan on 2017/4/21.
 */
public class Student {

    private String name;
    private double grade;
    public double feeDiscount = 0.0;
    private double baseFee = 20000.0;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public void setFeeDiscount(double feeDiscount) {
        this.feeDiscount = feeDiscount;
    }

    public double getFeeDiscount() {
        return feeDiscount;
    }

    public void printFee() {
        Double newFee = baseFee - (feeDiscount * baseFee / 100);
        System.out.println("after discount fee:" + newFee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
