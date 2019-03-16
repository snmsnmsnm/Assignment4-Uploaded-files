
public abstract class Shape {
    
    private String color;
    
    protected Shape(String color){
        this.color = color;
    }
    
    public String toString(){
        return color;
    }
    
    public abstract double getArea();
    
}
