package JavaSE.textObject;

/**
 * ���ڲ�����дobject.equals()����
 * author Benjamin
 *
 */

public class TextEquals {
    public static void main(String[] args) {
	    User one = new User("Benjamin", "123456123", 1);
	    User two = new User("Benjamin", "123456123", 1);
	    System.out.println(two.equals(one));
    }
}



class User{
    private String userName;
    private String pwd;
    private int id;

    User(String userName, String pwd, int id) {
        super();
        this.userName = userName;
        this.pwd = pwd;
        this.id = id;
    }

    public boolean equals(Object obj) {
        if(this == obj)//���жϵ�ַ�Ƿ�һ��
            return true;
        if(obj == null)//�жϲ����Ƿ������ö���
            return false;
        if(this.getClass() != obj.getClass())//�ж��Ƿ�������ͬ
            return false;
        if(!(obj instanceof User))//�ж��Ƿ��������
            return false;
        else {
            User one = (User)obj;//���ͣ�����һ�Ƚϸ���ʵ����
            return this.userName.equals(one.userName) && this.pwd.equals(one.pwd) && this.id == one.id;
        }
    }
}
