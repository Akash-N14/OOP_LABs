import java.util.Scanner;

abstract class Figure {
    protected int dimension1;
    protected int dimension2;

    public Figure(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public abstract double area();
}

class Rectangle extends Figure {

    public Rectangle(int width, int height) {
        super(width, height);
    }

    @Override
    public double area() {
        return dimension1 * dimension2;
    }
}

class Triangle extends Figure {

    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public double area() {
        return 0.5 * dimension1 * dimension2;
    }
}

class Square extends Figure {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public double area() {
        return dimension1 * dimension2;
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter width and height for Rectangle: ");
        int rectWidth = scanner.nextInt();
        int rectHeight = scanner.nextInt();
        Figure rectangle = new Rectangle(rectWidth, rectHeight);

        System.out.print("Enter base and height for Triangle: ");
        int triBase = scanner.nextInt();
        int triHeight = scanner.nextInt();
        Figure triangle = new Triangle(triBase, triHeight);

        System.out.print("Enter side length for Square: ");
        int side = scanner.nextInt();
        Figure square = new Square(side);

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Square Area: " + square.area());

        scanner.close();
    }
}