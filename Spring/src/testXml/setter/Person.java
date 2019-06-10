package testXml.setter;

public class Person {
    private String name;
    private int age;

    private Address homeAddress;
    private Address companyAddress;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", homeAddress=" + homeAddress +
                ", companyAddress=" + companyAddress +
                '}';
    }
}
