package com.example.tungdthe130860_test2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAddCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAddCourse extends Fragment {

    private EditText etCourseCode;
    private EditText etCourseName;
    private Button btnSave;
    private MyDatabase myDatabase;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAddCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAddCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAddCourse newInstance(String param1, String param2) {
        FragmentAddCourse fragment = new FragmentAddCourse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etCourseCode = view.findViewById(R.id.etCourseCode);
        etCourseName = view.findViewById(R.id.etCourseName);
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = etCourseCode.getText().toString();
                String name = etCourseName.getText().toString();
                myDatabase = Room.databaseBuilder(getContext(),MyDatabase.class,"mydatabase.db").allowMainThreadQueries().build();
                CourseDAO courseDAO = myDatabase.createCourseDAO();
                courseDAO.insert(new Course(code,name));
                Toast.makeText(getContext(),"Add success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}