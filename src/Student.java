import java.io.Serializable;

public class Student implements Serializable {
    private static int count;
    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private double averagePoint;

    public Student(String name, int age, String sex, String address, double averagePoint) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.averagePoint = averagePoint;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", averagePoint=" + averagePoint +
                '}' + "\n";
    }
}
