package HomeWork.Date_2018_11_27;
/**
 * 这个注释之前的别抄
 * P530 13.5
 */
public abstract class GeometricObject implements Comparable {
    @Override
    public int compareTo(Object o) throws java.lang.NumberFormatException {
        int rtn = 0;
        try{
            GeometricObject obj = (GeometricObject)o;
            if(this.getArea() > obj.getArea()){
                rtn = 1;
            }else if(this.getArea() < obj.getArea())
                rtn = -1;
            return rtn;
        }catch (Error e){
            throw e;
        }
    }

    public abstract double getArea();
}
