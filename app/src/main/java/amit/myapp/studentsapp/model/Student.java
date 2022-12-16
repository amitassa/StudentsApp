package amit.myapp.studentsapp.model;

import java.io.Serializable;
import java.security.PublicKey;

public class Student implements Serializable {
    private String _name;
    private String _id;
    private String _phone;
    private String _avatarUrl;
    private Boolean _checkBox;

    public Student(String name, String id, String phone, String avatarUrl, Boolean cb){
        _name = name; _id = id; _phone = phone; _avatarUrl = avatarUrl; _checkBox = cb;
    }

    public String Name(){
        return _name;
    }

    public String ID(){
        return _id;
    }

    public String Phone(){
        return _phone;
    }

    public Boolean CheckBox() {
        return _checkBox;
    }

    public void set_CheckBox(Boolean cb){
        _checkBox = cb;
    }

    public String AvatarURL() {
        return _avatarUrl;
    }

}
