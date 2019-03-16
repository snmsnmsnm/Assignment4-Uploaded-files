
public class TestShape {

    public static void main(String[] args) {

        Shape object1 = new Triangle(2, 3, "Red");
        Shape object2 = new Rectangle(1, 4, "White");

        System.out.println(object1.toString());
        System.out.println("Area: " + object1.getArea());
        System.out.println();
        System.out.println(object2.toString());
        System.out.println("Area: " + object2.getArea());
    }
}
