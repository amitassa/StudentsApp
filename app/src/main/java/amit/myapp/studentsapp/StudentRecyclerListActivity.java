package amit.myapp.studentsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import amit.myapp.studentsapp.model.Model;
import amit.myapp.studentsapp.model.Student;

public class StudentRecyclerListActivity extends AppCompatActivity {
    List<Student> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        RecyclerView studentsList = findViewById(R.id.students_recycler_list);
        studentsList.setHasFixedSize(true);

        data = Model.instance().getAllStudents();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        studentsList.setLayoutManager(layoutManager);
        studentsList.setAdapter(new StudentRecyclerAdapter());

    }

    class StudentViewHolder extends RecyclerView.ViewHolder {


        TextView nameTv; TextView idTv; CheckBox cb;

        public StudentViewHolder(@NonNull View view) {
            super(view);
            nameTv = view.findViewById(R.id.studentlistrow_name_textView);
            idTv = view.findViewById(R.id.studentlistrow_id_textView);
            cb = view.findViewById(R.id.studentlistrow_checkBox);
            cb.setOnClickListener(view1 -> {
                // The view is recycled, and the anonymous func uses the state of the views
                // on creation moment. So, we`ll use TAG to access the relevant checkbox
                int pos = (Integer) cb.getTag();
                Student st = data.get(pos);
                st.set_CheckBox(cb.isChecked());
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });
        }

        public void bind(Student student, int pos) {
            nameTv.setText(student.Name());
            idTv.setText(student.ID());
            cb.setChecked(student.CheckBox());
            cb.setTag(pos);
        }
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerListActivity.StudentViewHolder> {

        public StudentRecyclerAdapter(){
            super();
        }
        @NonNull
        @Override
        public StudentRecyclerListActivity.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);

            return new StudentRecyclerListActivity.StudentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentRecyclerListActivity.StudentViewHolder holder, int pos) {
            Student student = data.get(pos);
            holder.bind(student, pos);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


}
