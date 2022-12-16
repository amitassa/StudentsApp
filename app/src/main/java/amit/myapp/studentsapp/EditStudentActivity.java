package amit.myapp.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import amit.myapp.studentsapp.model.Model;
import amit.myapp.studentsapp.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    private Model studentsModel;
    private String currentStudentId;
    private EditText nameEt; private EditText idEt; private EditText phoneEt; private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Student student = (Student) getIntent().getSerializableExtra("student");

        studentsModel =  Model.instance();

        nameEt = findViewById(R.id.edit_student_name_et);
        idEt = findViewById(R.id.edit_student_id_et);
        phoneEt = findViewById(R.id.edit_student_phone_et);
        cb = findViewById(R.id.edit_student_checked_cb);
        Button cancleBtn = findViewById(R.id.edit_student_cancel_btn);
        Button saveBtn = findViewById(R.id.edit_student_save_btn);
        Button deleteBtn = findViewById(R.id.edit_student_delete_btn);

        currentStudentId = student.ID();

        nameEt.setText(student.Name());
        idEt.setText(student.ID());
        phoneEt.setText(student.Phone());
        cb.setChecked(student.CheckBox());


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateSaveData()){
                    setErrorMessage("Please check that all data is set");
                    return;
                }
                String name = nameEt.getText().toString();
                String id = idEt.getText().toString();
                String phone = phoneEt.getText().toString();
                Boolean checked = cb.isChecked();

                Boolean studentEdited = studentsModel.editStudent(currentStudentId, name, id, phone, checked);
                Log.d("b", "onClick: " + studentEdited);
                if (studentEdited){finish();}
                else {setErrorMessage("");}
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentsModel.deleteStudent(currentStudentId);
                finish();
            }
        });



    }

    private Boolean validateSaveData(){
        if (nameEt.getText().toString() == ""){
            return false;
        }
        if (idEt.getText().toString() == ""){
            return false;
        }
        if (phoneEt.getText().toString() == ""){
            return false;
        }
        return true;
    }

    private void setErrorMessage(String msg){

    }
}