package amit.myapp.studentsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import amit.myapp.studentsapp.model.Model;
import amit.myapp.studentsapp.model.Student;

public class StudentRecyclerListActivity extends AppCompatActivity {
    List<Student> data;
    StudentRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        RecyclerView studentsList = findViewById(R.id.students_recycler_list);
        studentsList.setHasFixedSize(true);

        data = Model.instance().getAllStudents();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        studentsList.setLayoutManager(layoutManager);
        adapter = new StudentRecyclerAdapter(getLayoutInflater(), data);
        studentsList.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int pos){
                Student student = data.get(pos);
                Intent studentDetailsIntent = new Intent(StudentRecyclerListActivity.this, StudentDetailsActivity.class);
                studentDetailsIntent.putExtra("student", student);
                startActivity(studentDetailsIntent);
            }
        });

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            data = Model.instance().getAllStudents();
            adapter.notifyDataSetChanged();
        }
    }



}
