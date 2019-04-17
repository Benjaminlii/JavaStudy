package JavaSE.textObject;

public class TextSuperAndExtends {

	public static void main(String[] args) {
		Persen one = new Persen("Ben", 18);
		Student two = new Student("Benjamin", 17, "04173130");
		System.out.println(one);
		System.out.println(two);
		System.out.println("#################################################");
		two.run();
		two.sleep();
		two.study();
	}
}

class Persen{
	private String name;
	private int age;
	
	public Persen(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void run() {
		System.out.println("Runing!!!");
	}
	
	public void sleep() {
		System.out.println("sleeping!!!");
	}

	@Override
	public String toString() {
		return "Persen [name=" + name + ", age=" + age + "]";
	}
}

class Student extends Persen{
	private String studentID;

	public Student(String name, int age, String studentID) {
		super(name, age);
		this.studentID = studentID;
	}
	
	public void study() {
		System.out.println("studing!!!");
	}

	@Override
	public String toString() {
		return  "Student [name=" + getName() + ", age=" + getAge() + "studentID=" + studentID + "]";
	}
	
}