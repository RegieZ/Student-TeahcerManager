public abstract class Person {
    private int id;//编号
    private String name;//姓名
    private String sex;//性别
    private String birthday;//出生日期
    private int age;//年龄--通过出生日期换算

    //构造方法
    public Person() {
    }

    public Person(int id, String name, String sex, String birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    //getter/setter
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        //通过生日计算年龄
        age = Utils.birthdayToAge(this.getBirthday());
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString，同时作为模板
    @Override
    public String toString() {
        return id + "\t\t" +
                name + "\t\t" +
                sex + "\t\t" +
                birthday + "\t\t" +
                this.getAge() + "\t\t" +
                " 我是一名：" + getType() + " 我的工作是：" + getWork();
    }

    //模板用到的两个方法，由子类重写
    public abstract String getWork();

    public abstract String getType();
}