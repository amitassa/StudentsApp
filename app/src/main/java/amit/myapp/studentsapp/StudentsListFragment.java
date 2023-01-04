package amit.myapp.studentsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import amit.myapp.studentsapp.model.Model;
import amit.myapp.studentsapp.model.Student;

public class StudentsListFragment extends Fragment {
List<Student> data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_students_list, container, false);

        RecyclerView studentsList = view.findViewById(R.id.studentslistfrag_list);
        studentsList.setHasFixedSize(true);
        data = Model.instance().getAllStudents();
        // The linearLayoutManager receives getContext because context is an activity, and the fragment is not activity,
        // so it gets the context of the fragment
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        studentsList.setLayoutManager(layoutManager);
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(), data);
        studentsList.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int pos){
//                Student student = data.get(pos);
//                Intent studentDetailsIntent = new Intent(getContext(), StudentDetailsActivity.class);
//                studentDetailsIntent.putExtra("student", student);
//                startActivity(studentDetailsIntent);

                // Navigate to the next fragment (without tabs)
                Navigation.findNavController(view).navigate(R.id.action_studentsListFragment_to_blueFragment);
            }
        });

        View button = view.findViewById(R.id.studentslistfrag_add_btn);

        // Navigate to the next fragment (without tabs), instead of anonymous function
        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_studentsListFragment_to_blueFragment));

        return view;
    }
}