
import java.math.*;
import java.util.*;

public class BigRational implements Comparable<BigRational> {

    public static final BigRational ZERO = new BigRational("0");
    public static final BigRational ONE = new BigRational("1");

    private BigInteger numerator;
    private BigInteger denominator;
    private boolean indeterminate = false;

    public BigRational() {
        this(BigInteger.ZERO);
    }

    public BigRational(BigInteger num) {
        this(num, BigInteger.ONE);
    }

    public BigRational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        checkZero();
        assignSigns();
        devideBygcd();
    }

    public BigRational(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int indexOfSlash = s.indexOf('/');
        if (indexOfSlash == -1) {
            numerator = new BigInteger(s.trim());
            denominator = BigInteger.ONE;
        } else {
            numerator = new BigInteger(s.substring(0, indexOfSlash).trim());
            denominator = new BigInteger(s.substring(indexOfSlash + 1).trim());
            checkZero();
            assignSigns();
            devideBygcd();
        }
    }

    private void checkZero() {
        if (numerator.equals(BigInteger.ZERO) && denominator.equals(BigInteger.ZERO)) {
            indeterminate = true;
            throw new ArithmeticException("division by zero");
        }
    }

    private void assignSigns() {
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
    }

    private void devideBygcd() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

    }

    public BigRational abs() {
        return new BigRational(numerator.abs(), denominator);
    }

    public BigRational negate() {
        return new BigRational(numerator.negate(), denominator);
    }

    public BigRational add(BigRational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new BigRational(newNumerator, newDenominator);
    }

    public BigRational subtract(BigRational other) {
        return add(other.negate());
    }

    public BigRational multiply(BigRational other) {
        BigInteger newNum = this.numerator.multiply(other.numerator);
        BigInteger newDen = this.denominator.multiply(other.denominator);
        return new BigRational(newNum, newDen);
    }

    public BigRational divide(BigRational other) {
        BigInteger newNum = this.numerator.multiply(other.denominator);
        BigInteger newDen = this.denominator.multiply(other.numerator);
        return new BigRational(newNum, newDen);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BigRational) {
            BigRational BR = ((BigRational) other);
            return numerator.equals(BR.numerator) && denominator.equals(((BigRational) other).denominator);
        }
        return false;
    }

    public BigRational pow(int num) {
        if (num < 0) {
            throw new NumberFormatException("Error, the power is less than 0.");
        }
        return new BigRational(this.numerator.pow(num), this.denominator.pow(num));
    }

    public BigRational reciprocal() {
        return new BigRational(denominator, numerator);
    }

    public BigInteger toBigInteger() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator;
        } else {
            throw new NumberFormatException("denominator is not one");
        }
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ZERO)) {
            if (numerator.compareTo(BigInteger.ZERO) < 0) {
                return "-Infinity";
            } else {
                return "Infinity";
            }
        }

        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + " / " + denominator;
        }
    }

    public int toInteger() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.intValue();
        }
        throw new NumberFormatException("denominator is not one");

    }

    @Override
    public int compareTo(BigRational other) {
        BigInteger num1 = this.numerator.multiply(other.denominator);
        BigInteger num2 = this.denominator.multiply(other.numerator);

        if (num1.intValue() > num2.intValue()) {
            return 1;
        } else if (num1.intValue() < num2.intValue()) {
            return -1;
        } else {
            return 0;
        }

    }

}
