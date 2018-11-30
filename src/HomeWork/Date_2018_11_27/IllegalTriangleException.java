package HomeWork.Date_2018_11_27;
/**
 * 这个注释之前的别抄
 * P488 12.5
 */
public class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}

class Triangle {
    private double size1, size2, size3;

    public Triangle(double size1, double size2, double size3) throws IllegalTriangleException {
        if (size1 + size2 < size3){
            throw new IllegalTriangleException(size1 + " + " + size2 + " < " + size3);
        }else if (size2 + size3 < size1){
            throw new IllegalTriangleException(size2 + " + " + size3 + " < " + size1);
        }else if (size3 + size1 < size2){
            throw new IllegalTriangleException(size3 + " + " + size1 + " < " + size2);
        }else {
            this.size1 = size1;
            this.size2 = size2;
            this.size3 = size3;
        }
    }
}
