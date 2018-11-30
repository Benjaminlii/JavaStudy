package textObject;
/**
 * 用于测试static块
 * @author Benjamin
 *
 */
public class TextStatic {

	int id;
	String name;
	
	static {
		System.out.println("加载了类，运行了静态块。");
	}

	public TextStatic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static void main(String[] args) {
		TextStatic one = new TextStatic(1, "Benjamin");
		TextStatic two = new TextStatic(2, "Blue");
		System.out.println(one);
		System.out.println(two);
	}
}
