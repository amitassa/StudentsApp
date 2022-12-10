package amit.myapp.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import amit.myapp.studentsapp.model.Model;
import amit.myapp.studentsapp.model.Student;

public class StudentListActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance().getAllStudents();
        ListView studentsList = findViewById(R.id.studentlist_list);
        studentsList.setAdapter(new StudentListAdapter());

        studentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Log.d("tag", "onItemClick: " + pos);
            }
        });
    }

    class StudentListAdapter extends BaseAdapter{

//        public StudentListAdapter(Context ctx, )
        @Override
        public int getCount() {

            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {

            if (view == null){
                view = getLayoutInflater().inflate(R.layout.student_list_row, null);
                CheckBox cb = view.findViewById(R.id.studentlistrow_checkBox);
                cb.setOnClickListener(view1 -> {
                    // The view is recycled, and the anonymous func uses the state of the views
                    // on creation moment. So, we`ll use TAG to access the relevant checkbox
                    int pos1 = (Integer) cb.getTag();
                    Student st = data.get(pos1);
                    st.set_CheckBox(cb.isChecked());
                });
            }
            TextView nameTv = view.findViewById(R.id.studentlistrow_name_textView);
            TextView idTv = view.findViewById(R.id.studentlistrow_id_textView);
            CheckBox cb = view.findViewById(R.id.studentlistrow_checkBox);

            Student student = data.get(pos);
            nameTv.setText(student.Name());
            idTv.setText(student.ID());
            cb.setChecked(student.CheckBox());
            cb.setTag(pos);
            return view;
        }
    }
}
