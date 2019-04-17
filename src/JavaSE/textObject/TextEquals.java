package JavaSE.textObject;

/**
 * 用于测试重写object.equals()方法
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
        if(this == obj)//先判断地址是否一致
            return true;
        if(obj == null)//判断参数是否有引用对象
            return false;
        if(this.getClass() != obj.getClass())//判断是否类型相同
            return false;
        if(!(obj instanceof User))//判断是否可以造型
            return false;
        else {
            User one = (User)obj;//造型，并逐一比较各项实例域
            return this.userName.equals(one.userName) && this.pwd.equals(one.pwd) && this.id == one.id;
        }
    }
}
