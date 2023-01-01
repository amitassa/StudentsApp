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
    BlueFragment frag1;
    BlueFragment frag2;
    BlueFragment frag3;
    BlueFragment frag4;
    BlueFragment inDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlueFragment frag1 = BlueFragment.newInstance("1");
        BlueFragment frag2 = BlueFragment.newInstance("2");
        BlueFragment frag3 = BlueFragment.newInstance("3");
        BlueFragment frag4 = BlueFragment.newInstance("4");

        Button btn1 = findViewById(R.id.main_btn_1);
        Button btn2 = findViewById(R.id.main_btn_2);
        Button btn3 = findViewById(R.id.main_btn_3);
        Button btn4 = findViewById(R.id.main_btn_4);

        btn1.setOnClickListener((view -> {
            displayFragment(frag1);
        }));

        btn2.setOnClickListener((view -> {
            displayFragment(frag2);
        }));

        btn3.setOnClickListener((view -> {
            displayFragment(frag3);
        }));

        btn4.setOnClickListener((view -> {
            displayFragment(frag4);
        }));
        displayFragment(frag1);
    }

    private void displayFragment(BlueFragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.main_frag_container, frag);
        if (inDisplay != null){
            tran.remove((inDisplay));
        }
        tran.addToBackStack("someTAG");
        tran.commit();
        inDisplay = frag;
    }

}