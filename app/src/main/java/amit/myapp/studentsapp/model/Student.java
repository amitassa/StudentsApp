package amit.myapp.studentsapp.model;

import java.security.PublicKey;

public class Student {
    private String _name;
    private String _id;
    private String _avatarUrl;
    private Boolean _checkBox;

    public Student(String name, String id, String avatarUrl, Boolean cb){
        _name = name; _id = id; _avatarUrl = avatarUrl; _checkBox = cb;
    }

    public String Name(){
        return _name;
    }

    public String ID(){
        return _id;
    }

    public Boolean CheckBox() {
        return _checkBox;
    }

    public String AvatarURL() {
        return _avatarUrl;
    }
}
