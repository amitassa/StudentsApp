package amit.myapp.studentsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import amit.myapp.studentsapp.model.Student;

 class StudentViewHolder extends RecyclerView.ViewHolder {

    TextView nameTv; TextView idTv; CheckBox cb; List<Student> data;

    public StudentViewHolder(@NonNull View view, StudentRecyclerAdapter.OnItemClickListener onClickListener, List<Student> data) {
        super(view);
        this.data = data;
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
                onClickListener.onItemClick(pos);
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


public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    OnItemClickListener listener;
    List<Student> data;
    LayoutInflater inflater;


    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public StudentRecyclerAdapter(LayoutInflater inflater, List<Student> data){
        super();
        this.data = data; this.inflater = inflater;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_list_row, parent, false);

        return new StudentViewHolder(view, listener, data);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int pos) {
        Student student = data.get(pos);
        holder.bind(student, pos);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static interface OnItemClickListener{
        void onItemClick(int pos);
    }



}


