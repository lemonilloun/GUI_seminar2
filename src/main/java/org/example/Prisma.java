package org.example;

public class Prisma {
    private double a;
    private double b;
    private double c;
    private double height;

    public Prisma(double a, double b, double c, double height) {
        if (a > 0.0 && b > 0 && c > 0 && height > 0) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.height = height;
        }else {throw new RuntimeException();}
    }

    public void surf_are(){
        System.out.println((a * height) + (b * height) + (c * height));
    }

    public void volume(){
        double p = (a + b + c)/2;
        System.out.println((Math.sqrt(p * (p - a)*(p-b)*(p-c)))*height);
    }
}
