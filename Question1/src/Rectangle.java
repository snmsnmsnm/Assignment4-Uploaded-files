
public class Rectangle extends Shape {

    double side1;
    double side2;

    public Rectangle(double side1, double side2, String color) {
        super(color);
        this.side1=side1;
        this.side2=side2;
    }
    
    @Override
    public String toString(){
        return "Side1: " + side1 + "\tSide2; " + side2 + "\tColor: " +
                super.toString();
    }
    
    @Override
    public double getArea(){
        return side1*side2;
    }
}    
