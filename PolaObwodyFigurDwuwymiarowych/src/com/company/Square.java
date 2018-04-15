package com.company;

public class Square extends Figure implements Print {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double calculateArea() {
        return side*side;
    }

    @Override
    double calculatePerimeter() {

        return 4*side;
    }

    @Override
    public void print() {
        System.out.println("Bok kwadratu to:"+side);
        System.out.println("Obwod trojkata wynosi:"+calculatePerimeter());
        System.out.println("Pole trojkata wynosi:"+calculateArea());
    }
}
