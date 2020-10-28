package com.example.assignment1;

        import android.os.Bundle;

        import androidx.fragment.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentQuestion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentQuestion extends Fragment {

    TextView textView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNum";

    // TODO: Rename and change types of parameters
    private String text;
    private int number;

    public FragmentQuestion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param number Parameter 1.
     * @param text Parameter 2.
     * @return A new instance of fragment FragmentQuestion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentQuestion newInstance(String text, int number) {
        FragmentQuestion fragment = new FragmentQuestion();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_question, container, false);
        textView = v.findViewById(R.id.textInFrag);

        if(getArguments() != null){
            text = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);
            textView.setText(text + number);
        }else{

        }



        return v;
        // Inflate the layout for this fragment
    }
}