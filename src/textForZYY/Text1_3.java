package textForZYY;

/**
 * һ������� ˽����Ҳ�����ԣ������������ơ����͡�����������Ϊ��������ͨ������Ϊ˽�У�����Ϊ˽����
 *           ��������Ϊ���췽����get\set��������ͨ�������������и��Եķ������ơ�����ֵ��������
 *
 * ��дһ����
 * ����ΪRectangle�������Σ�
 * ��������˽�е�double����length��������width��������ʼ��Ϊ0
 *     һ����ʼ��length��width�Ĺ��캯��
 *     һ������������ΪgetArea������ֵΪdouble�����س����ε����
 *     һ������������ΪgetPerimeter������ֵΪdouble�����س����ε��ܳ�
 *
 * �ڹ������н��в���
 *
 * author:zyy
 * date:2019.3.13
 */

class Rectangle{
    /*--------------------------code------------------------------*/
    private double length;
    private double width;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    public double getArea(){
        return this.length * this.width;
    }
    public  double getPerimeter(){
        return 2*(this.width+this.length);
    }
}

public class Text1_3 {
    public static void main(String[] args) {
    Rectangle lt =new Rectangle(3,5);
        System.out.println(lt.getPerimeter());
        System.out.println(lt.getArea());
    }
}
