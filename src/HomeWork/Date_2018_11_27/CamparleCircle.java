package HomeWork.Date_2018_11_27;
/**
 * 这个注释之前的别抄
 * P530 13.6
 */
public abstract class CamparleCircle extends Circle implements Comparable{

    @Override
    public int compareTo(Object o) {
        try {
            int rtn = 0;
            CamparleCircle obj = (CamparleCircle) o;
            if (this.getArea() > obj.getArea())
                rtn = 1;
            else if (this.getArea() < obj.getArea())
                rtn = -1;
            return rtn;
        }catch (Error e){
            throw e;
        }
    }
}

abstract class  Circle{
    public abstract double getArea();
}
