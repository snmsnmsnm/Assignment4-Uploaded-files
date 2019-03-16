
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;

public class TestBigRational extends BigRational {

    public static void main(String[] args) {
        BigRational br1 = new BigRational(BigInteger.ONE, BigInteger.TEN);
        System.out.println(br1.toString());
        
        //Object br2 is created for testing denominator with value of zero
        BigRational br2 = new BigRational("3/0");
        System.out.println(br2.toString());

        //Object br3 is created for testing denominator with value of zero and negative numerator 
        BigRational br3 = new BigRational("-1/0");
        System.out.println(br3.toString());

        /*Object br4 and br5 is created for testing negate, absolut, reciprocal, add, subtract,
        multiply, divide and equal methods.*/
        BigRational br4 = new BigRational("2/3");
        BigRational br5 = new BigRational("5/-7");

        System.out.println("First rational number: " + br4.toString());

        System.out.println("Negation of fisrt rational number: " + br4.negate());

        System.out.println("Second rational number: " + br5.toString());

        System.out.println("Absolut of second rational number: " + br5.abs());

        System.out.println("Reciprocal of second rational number: " + br5.reciprocal());

        System.out.println(br4.toString() + " + " + "(" + br5.toString() + ")" + " = "
                + br4.add(br5));

        System.out.println(br4.toString() + " - " + "(" + br5.toString() + ")" + " = "
                + br4.subtract(br5));

        System.out.println(br4.toString() + " * " + "(" + br5.toString() + ")" + " = "
                + br4.multiply(br5));

        System.out.println("(" + br4.toString() + ")" + " / " + "(" + br5.toString() + ")"
                + " = " + br4.divide(br5));

        System.out.println(br4.toString() + " = " + "(" + br5.toString() + ")" + " : "
                + br4.equals(br5));
        
        //Testing pow method for br5
        try {
            System.out.println("(" + br5.toString() + ")" + " to power of 6 " + " = " + br5.pow(-6));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }

        System.out.println("");

        //br7 is created for testing toBigInteger method.
        try {
            BigRational br7 = new BigRational("6/4");
            System.out.println("Converting rational number to BigInteger: "
                    + br7.toBigInteger());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        
        //br8 is created for testing toInteger method.
        try {
            BigRational br8 = new BigRational("7/1");
            System.out.println("Converting rational number to integer: "
                    + br8.toInteger());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        
        //An ArrayList is created for sorting the rational numbers and displaying them.
        ArrayList<BigRational> list = new ArrayList<>();
        list.add(new BigRational("1/3"));
        list.add(new BigRational("1/5"));
        list.add(new BigRational("1/8"));
        list.add(new BigRational("2/8"));
        list.add(new BigRational("3/8"));

        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        Collections.sort(list);

        System.out.println("");
        System.out.print("Sorted list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
    }
}
