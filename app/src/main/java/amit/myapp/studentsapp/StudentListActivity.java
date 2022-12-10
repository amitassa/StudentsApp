package amit.myapp.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        ListView studentsList = findViewById(R.id.studentlist_list);
        studentsList.setAdapter(new StudentListAdapter());
    }

    class StudentListAdapter extends BaseAdapter{

//        public StudentListAdapter(Context ctx, )
        @Override
        public int getCount() {
            return 10;
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
            }
            TextView nameTv = view.findViewById(R.id.studentlistrow_name_textView);
            nameTv.setText("Name "+ pos);
            return view;
        }
    }
}
