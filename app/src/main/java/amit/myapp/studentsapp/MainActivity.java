package amit.myapp.studentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import amit.myapp.studentsapp.model.BlueFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.main_add_button);
        Button removeBtn = (Button) findViewById(R.id.main_remove_button);

        BlueFragment myFrag = new BlueFragment();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFrag(myFrag);
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFrag(myFrag);
            }
        });


    }

    void addFrag(Fragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.main_frag_container, frag);
        tran.addToBackStack("someTAG");
        tran.commit();
    }

    void removeFrag(Fragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.remove(frag);
        tran.addToBackStack("someTAG1");
        tran.commit();
    }
}