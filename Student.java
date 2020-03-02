public class Student extends Person {
    public Student() {
    }

    public Student(int id, String name, String sex, String birthday) {
        super(id, name, sex, birthday);
    }

    @Override
    public String getWork() {
        return "学习";
    }

    @Override
    public String getType() {
        return "学生";
    }
}