package amit.myapp.studentsapp.model;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amit.myapp.studentsapp.R;


public class BlueFragment extends Fragment {
    TextView titleTv;
    String title;

    // Factory to automatically create the Fragment when android needed (like screen rotation)
    public static BlueFragment newInstance(String title){
        BlueFragment frag = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);
        frag.setArguments(bundle);
        return frag;
    }

    // Overriding onCreate to allow android to create new instance
    // of the Fragment using previously added (bundle) data
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            this.title = bundle.getString("TITLE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blue, container, false);
        TextView titleTv = view.findViewById(R.id.bluefragmet_title_tv);

        if (title != null){
            titleTv.setText(title);
        }
        return view;
    }

    public void setTitle (String title){
        this.title = title;
        if (titleTv != null){
            titleTv.setText(title);
        }
    }
}