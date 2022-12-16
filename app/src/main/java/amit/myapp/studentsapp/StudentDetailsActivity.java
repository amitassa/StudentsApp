package amit.myapp.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import amit.myapp.studentsapp.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        TextView nameTv = findViewById(R.id.student_details_name_tv);
        TextView idTv = findViewById(R.id.student_details_id_tv);
        TextView phoneTv = findViewById(R.id.student_details_phone_tv);
        CheckBox checkedCb = findViewById(R.id.student_details_checked_cb);
        ImageView imgView = findViewById(R.id.student_details_image);
        Button editBtn = findViewById(R.id.student_details_edit_btn);

        Student student = (Student) getIntent().getExtras().getSerializable("student");
        nameTv.setText(student.Name());
        idTv.setText(student.ID());
        phoneTv.setText(student.Phone());
        checkedCb.setChecked(student.CheckBox());
    }
}