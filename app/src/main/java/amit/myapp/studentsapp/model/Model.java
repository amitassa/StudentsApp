package amit.myapp.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    private Model(){
        addStudent(new Student("Amit", "123456" , "0501234567", "", false));
        addStudent(new Student("Omer" , "654321", "0527654321", "", false));
        addStudent(new Student("Afek", "77777" , "0508787878", "", false));
        addStudent(new Student("Lior" , "11111", "050111222", "", false));
        addStudent(new Student("Eliav" , "101010", "0501010101", "", false));

        for (int i = 0; i < 5; i++) {
            addStudent(new Student("Name " + i, "id"+ i , "050000000"+i, "", false));
        }
    }

    public static Model instance(){
        return _instance;
    }

    List<Student> data = new LinkedList<>();
    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }
}
