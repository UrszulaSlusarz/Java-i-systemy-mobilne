package com.company;
import static java.lang.Math.*;

public class Triangle extends Figure implements Print {
   private double sidefirst;
   private double sidesecond;
   private double sidethird;

    public Triangle(double sidefirst, double sidesecond, double sidethird) {
        this.sidefirst = sidefirst;
        this.sidesecond = sidesecond;
        this.sidethird = sidethird;
    }

    @Override
    double calculateArea() {
     double d=0.5*(sidefirst+sidesecond+sidethird); //polowa obowdu
     double areaheron= sqrt(d*(d-sidefirst)*(d-sidesecond)*(d-sidethird)); //wzor Herona
        return areaheron;
    }

    @Override
    double calculatePerimeter() {
       double perimeter=sidefirst+sidesecond+sidethird; //obwod trojkata
        return perimeter;
    }

    @Override
    public void print() {
        System.out.println("Boki trojkata to:"+' '+sidefirst+',' +sidesecond+',' +sidethird);
        System.out.println("Obwod trojkata wynosi:"+calculatePerimeter());
        System.out.println("Pole trojkata wynosi:"+calculateArea());

    }
}
