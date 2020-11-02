package com.example.tungdthe130860_test2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAddStudent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAddStudent extends Fragment {
    private EditText etStudentRoll;
    private EditText etStudentName;
    private EditText etStudentPhone;
    private EditText etStudentEmail;
    private Spinner spCourse;
    private Button btnSave;
    private MyDatabase myDatabase;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAddStudent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAddStudent.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAddStudent newInstance(String param1, String param2) {
        FragmentAddStudent fragment = new FragmentAddStudent();
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
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etStudentRoll = view.findViewById(R.id.etStudentRoll);
        etStudentName = view.findViewById(R.id.etStudentName);
        etStudentPhone = view.findViewById(R.id.etStudentPhone);
        etStudentEmail = view.findViewById(R.id.etStudentEmail);
        spCourse = view.findViewById(R.id.spCourse);
        btnSave = view.findViewById(R.id.btnSave);

        myDatabase = Room.databaseBuilder(getContext(),MyDatabase.class,"mydatabase.db").allowMainThreadQueries().build();

        CourseDAO courseDAO = myDatabase.createCourseDAO();
        List<Course> courses = courseDAO.getCourses();
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,courses);
        spCourse.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDAO studentDAO = myDatabase.createStudentDAO();
                Course course = (Course) spCourse.getSelectedItem();
                Student student = new Student(etStudentRoll.getText().toString(),
                        etStudentName.getText().toString(),
                        etStudentPhone.getText().toString(),
                        etStudentEmail.getText().toString(),
                        course.getCourseId());
                studentDAO.insert(student);
                Toast.makeText(getContext(),"Add success",Toast.LENGTH_SHORT).show();
            }
        });

    }
}