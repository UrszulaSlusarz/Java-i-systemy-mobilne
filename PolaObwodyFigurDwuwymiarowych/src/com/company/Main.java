package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

 boolean correct=false;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Wybierz figure: ");
        System.out.println("1.Trojkat");
        System.out.println("2.Kwadrat");
        System.out.println("3.Kolo");
        System.out.println("4.Koniec programu");

           int n = scanner.nextInt();

        switch (n){
            case 1:
                System.out.println("Podaj wartosci bokow trojkata.");
                while(!correct) {
                    try {
                        double triangle_first = scanner.nextDouble();
                        double triangle_second = scanner.nextDouble();
                        double triangle_third = scanner.nextDouble();

                        double tab[]=new double[3];
                        tab[0]=triangle_first;
                        tab[1]=triangle_second;
                        tab[2]=triangle_third;
                        for(int i=0; i<tab.length;i++)
                        {
                            if (tab[i]>0)
                            {
                                correct=true;
                            }
                            else throw new ArithmeticException();
                        }

                        Triangle triangle = new Triangle(triangle_first, triangle_second, triangle_third);
                        triangle.calculatePerimeter();
                        triangle.calculateArea();
                        triangle.print();
                    } catch (InputMismatchException e) {
                        System.out.println("Nie wprowadziles cyfry.");
                    } catch (ArithmeticException e) {
                        System.out.println("Wprowadz liczbe dodatnia.");
                    }
                }
                    break;

            case 2:
                System.out.println("Podaj wartosc boku kwadratu.");
                while(!correct) {
                    try {
                        double squarefirst = scanner.nextDouble();
                        if (squarefirst>0 ) correct=true;
                        else throw new ArithmeticException();

                        Square square = new Square(squarefirst);
                        square.calculatePerimeter();
                        square.calculateArea();
                        square.print();
                    } catch (InputMismatchException e) {
                        System.out.println("Nie wprowadziles cyfry.");
                    } catch (ArithmeticException e) {
                        System.out.println("Wprowadz liczbe dodatnia.");
                    }
                }
                break;

            case 3:
                System.out.println("Podaj wartosc promienia kola.");
                while(!correct) {
                    try {
                        double circle_radius = scanner.nextDouble();
                        if (circle_radius>0 ) correct=true;
                        else throw new ArithmeticException();
                        Circle circle = new Circle(circle_radius);
                        circle.calculatePerimeter();
                        circle.calculateArea();
                        circle.print();
                    } catch (InputMismatchException e) {
                        System.out.println("Nie wprowadziles cyfry.");
                    }catch (ArithmeticException e) {
                        System.out.println("Wprowadz liczbe dodatnia.");
                    }
                }
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Wybrano niepoprawna liczbe.");
                break;
        }
    }
}
