package amit.myapp.studentsapp.model;

import android.util.Log;

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

    public void addStudent(String name, String id, String phone, Boolean isChecked) {
        Student st = new Student(name, id, phone, "", isChecked);
        data.add(st);
    }

    public void deleteStudent(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).ID().equals(id)) {
                data.remove(i);
                break;
            }
        }
    }

    public Boolean editStudent(String id, String newName, String newId, String newPhone, Boolean newIsChecked ){
        Student st = getStudentById(id);
        if (st == null){
            return false;
        }
        st.setName(newName);
        st.setID(newId);
        st.setPhone(newPhone);
        st.set_CheckBox(newIsChecked);
        return true;
    }

    private Student getStudentById(String id) {
        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).ID().equals(id)) {
                return data.get(i);
            }
        }
        return null;
    }


}
