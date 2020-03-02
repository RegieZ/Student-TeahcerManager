import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //学生集合
        ArrayList<Student> stuList = new ArrayList<>();
        //教师集合
        ArrayList<Teacher> teaList = new ArrayList<>();
        //主菜单
        while (true) {
            System.out.println("1.学员信息管理 2.教师信息管理 3.退出");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    studentManage(stuList, sc);
                    break;
                case 2:
                    teacherManage(teaList, sc);
                    break;
                case 3:
                    System.out.println("谢谢使用，拜拜！！");
                    System.exit(0);
                default:
                    System.out.println("你的输入有误，请重新输入！");
                    break;
            }
        }
    }

    //教师信息管理
    private static void teacherManage(ArrayList<Teacher> teaList, Scanner sc) {
        //二级菜单
        while (true) {
            System.out.println("------------------------------------------------------ ");
            System.out.println("【教师信息管理】");
            System.out.println("1.添加教师 2.修改教师 3.删除教师 4.查询教师 5.返回");
            System.out.println();
            System.out.println("请输入功能序号：");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    addTeacher(teaList, sc);
                    break;
                case 2:
                    updateTeacher(teaList, sc);
                    break;
                case 3:
                    deleteTeacher(teaList, sc);
                    break;
                case 4:
                    selectAllTeacher(teaList, sc);
                    break;
                case 5:
                    return;//结束方法
                default:
                    System.out.println("你的输入有误，请重新输入！");
                    break;
            }
        }
    }

    //学员信息管理
    private static void studentManage(ArrayList<Student> stuList, Scanner sc) {
        //二级菜单
        while (true) {
            System.out.println("------------------------------------------------------ ");
            System.out.println("【学员信息管理】");
            System.out.println("1.添加学员 2.修改学员 3.删除学员 4.查询学员 5.返回");
            System.out.println();
            System.out.println("请输入功能序号：");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    addStudent(stuList, sc);
                    break;
                case 2:
                    updateStudent(stuList, sc);
                    break;
                case 3:
                    deleteStudent(stuList, sc);
                    break;
                case 4:
                    selectAllStudent(stuList, sc);
                    break;
                case 5:
                    return;//结束方法
                default:
                    System.out.println("你的输入有误，请重新输入！");
                    break;
            }
        }
    }

    //添加学员
    private static void addStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入学员姓名：");
        String name = sc.next();
        System.out.println("请输入性别：");
        String sex = sc.next();
        System.out.println("请输入出生日期(yyyy-MM-dd)：");
        String birthday = sc.next();
        stuList.add(new Student(++Utils.stuId, name, sex, birthday));
        System.out.println("【成功】学员信息添加成功！");
    }

    //添加教师
    private static void addTeacher(ArrayList<Teacher> teaList, Scanner sc) {
        System.out.println("请输入教师姓名：");
        String name = sc.next();
        System.out.println("请输入性别：");
        String sex = sc.next();
        System.out.println("请输入出生日期(yyyy-MM-dd)：");
        String birthday = sc.next();
        teaList.add(new Teacher(++Utils.teaId, name, sex, birthday));
        System.out.println("【成功】教师信息添加成功！");
    }

    //修改学员
    private static void updateStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入要修改的学员ID：");
        int stuId = sc.nextInt();
        //查询
        for (int i = 0; i < stuList.size(); i++) {
            Student stu = stuList.get(i);
            if (stu.getId() == stuId) {
                System.out.println("【查询结果】要修改的学员信息：");
                //打印
                Utils.printPerson(stu);
                //执行修改
                System.out.println("请输入学员新姓名(保留原值输入0)：");
                String newName = sc.next();
                System.out.println("请输入学员新性别(保留原值输入0)：");
                String newSex = sc.next();
                System.out.println("请输入学员新出生日期(yyyy-MM-dd)(保留原值输入0)：");
                String newBirthday = sc.next();
                if (!"0".equals(newName)) {
                    stu.setName(newName);
                }
                if (!"0".equals(newSex)) {
                    stu.setSex(newSex);
                }
                if (!"0".equals(newBirthday)) {
                    stu.setBirthday(newBirthday);
                }
                System.out.println("【成功】学员信息修改成功！");
                return;
            }
        }
        System.out.println("【错误】学员ID：" + stuId + " 没找到！");
    }

    //修改教师
    private static void updateTeacher(ArrayList<Teacher> teaList, Scanner sc) {
        System.out.println("请输入要修改的教师ID：");
        int teaId = sc.nextInt();
        //查询
        for (int i = 0; i < teaList.size(); i++) {
            Teacher tea = teaList.get(i);
            if (tea.getId() == teaId) {
                System.out.println("【查询结果】要修改的教师信息：");
                //打印
                Utils.printPerson(tea);
                //执行修改
                System.out.println("请输入教师新姓名(保留原值输入0)：");
                String newName = sc.next();
                System.out.println("请输入教师新性别(保留原值输入0)：");
                String newSex = sc.next();
                System.out.println("请输入教师新出生日期(yyyy-MM-dd)(保留原值输入0)：");
                String newBirthday = sc.next();
                if (!"0".equals(newName)) {
                    tea.setName(newName);
                }
                if (!"0".equals(newSex)) {
                    tea.setSex(newSex);
                }
                if (!"0".equals(newBirthday)) {
                    tea.setBirthday(newBirthday);
                }
                System.out.println("【成功】教师信息修改成功！");
                return;
            }
        }
        System.out.println("【错误】教师ID：" + teaId + " 没找到！");
    }

    //删除学员
    private static void deleteStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入要删除的学员ID：");
        int stuId = sc.nextInt();
        //查询
        for (int i = 0; i < stuList.size(); i++) {
            Student stu = stuList.get(i);
            if (stu.getId() == stuId) {
                System.out.println("【查询结果】要删除的学员信息：");
                Utils.printPerson(stu);
                System.out.println("【确认】您确定要删除这条信息吗(y/n)？");
                String str = sc.next();
                if ("y".equals(str)) {
                    stuList.remove(i);
                    System.out.println("【成功】数据已被删除！");
                    return;//结束方法
                } else {
                    System.out.println("【取消】操作被取消！");
                    return;
                }
            }
        }
        System.out.println("【错误】学员ID：" + stuId + " 未找到！");
    }

    //删除教师
    private static void deleteTeacher(ArrayList<Teacher> teaList, Scanner sc) {
        System.out.println("请输入要删除的教师ID：");
        int teaId = sc.nextInt();
        //查询
        for (int i = 0; i < teaList.size(); i++) {
            Teacher tea = teaList.get(i);
            if (tea.getId() == teaId) {
                System.out.println("【查询结果】要删除的教师信息：");
                Utils.printPerson(tea);
                System.out.println("【确认】您确定要删除这条信息吗(y/n)？");
                String str = sc.next();
                if ("y".equals(str)) {
                    teaList.remove(i);
                    System.out.println("【成功】数据已被删除！");
                    return;//结束方法
                } else {
                    System.out.println("【取消】操作被取消！");
                    return;
                }
            }
        }
        System.out.println("【错误】学员ID：" + teaId + " 未找到！");
    }

    //查询所有学员
    private static void selectAllStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("【查询结果】");
        if (stuList.size() == 0) {
            System.out.println("无数据");
            return;
        }
        Utils.printPersonList(stuList);//调用工具类打印
    }

    //查询所有教师
    private static void selectAllTeacher(ArrayList<Teacher> teaList, Scanner sc) {
        System.out.println("【查询结果】");
        if (teaList.size() == 0) {
            System.out.println("无数据");
            return;
        }
        Utils.printPersonList(teaList);//调用工具类打印
    }
}
