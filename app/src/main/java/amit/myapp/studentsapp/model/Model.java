package amit.myapp.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    private Model(){
        for (int i = 0; i < 10; i++) {
            addStudent(new Student("name " + i, "id" + i, "", false));
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
