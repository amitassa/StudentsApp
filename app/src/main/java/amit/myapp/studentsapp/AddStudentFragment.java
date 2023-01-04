package amit.myapp.studentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        EditText nameEt = view.findViewById(R.id.addstudent_name_et);
        EditText idEt = view.findViewById(R.id.addstudent_id_et);
        Button saveBtn = view.findViewById(R.id.addstudent_save_btn);
        Button cancelBtn = view.findViewById(R.id.addstudent_cancel_btn);

        saveBtn.setOnClickListener(view1 -> {
            String name = nameEt.getText().toString();
            Log.d("name:", name);
        });

        cancelBtn.setOnClickListener(view1 ->{
            Navigation.findNavController(view1).popBackStack();
        });
        return view;
    }
}