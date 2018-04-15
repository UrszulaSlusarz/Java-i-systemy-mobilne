package com.company;
import static java.lang.Math.*;

public class Circle extends Figure implements Print{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return (Math.PI)*pow(radius,2);
    }

    @Override
    double calculatePerimeter() {
        return 2*(Math.PI)*radius;
    }

    @Override
    public void print() {
        System.out.println("Promien kola to:"+radius);
        System.out.println("Obwod trojkata wynosi:"+calculatePerimeter());
        System.out.println("Pole trojkata wynosi:"+calculateArea());
    }
}
