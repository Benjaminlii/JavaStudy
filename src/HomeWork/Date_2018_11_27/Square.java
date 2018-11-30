package HomeWork.Date_2018_11_27;
/**
 * 这个注释之前的别抄
 * P530 13.7
 */
public class Square extends GeometricObject implements Colorable{
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public void howToColor() {
        System.out.println("how to color");
    }

    @Override
    public double getArea() {
        return Math.pow(this.size, 2);
    }

    public static void main(String[] args) {
        GeometricObject[] array = new GeometricObject[4];
        for(GeometricObject obj : array){
            if(obj instanceof Colorable)
                ((Colorable) obj).howToColor();
        }
    }
}

interface Colorable{
    void howToColor();
}
