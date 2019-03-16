
public class Triangle extends Shape{
    
    private double base;
    private double height;
    
    public Triangle(double base, double height, String color){
        super(color);
        this.base = base;
        this.height = height;
        
    }
    
    @Override
    public String toString(){
        return "Base: " + base + "\tHieght: " + height + "\tColor: " +
                super.toString();
    }
    
    @Override
    public double getArea(){
        return (0.5*base*height);
    }
}
