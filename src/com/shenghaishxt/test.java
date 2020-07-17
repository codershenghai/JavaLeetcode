package com.shenghaishxt;

public class test {
    // 时针走一格是360/12=30°，且每过一分钟走的角度是0.5°
    // 分针每过一分钟走的角度是360/60=6°
    public double getAngle(int hour, int minute) {
        double minuteAngle = minute * 6;
        double hourAngle = hour * 30 + minute * 0.5;
        return Math.abs(minuteAngle - hourAngle);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new test().getAngle(7, 55));
        System.out.println(new test().getAngle(7, 15));
    }
}
