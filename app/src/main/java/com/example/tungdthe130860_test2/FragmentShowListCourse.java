package com.example.tungdthe130860_test2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentShowListCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShowListCourse extends Fragment{
    private ListView listView;
    private MyDatabase myDatabase;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentShowListCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentShowListCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentShowListCourse newInstance(String param1, String param2) {
        FragmentShowListCourse fragment = new FragmentShowListCourse();
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
        return inflater.inflate(R.layout.fragment_show_list_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        myDatabase = Room.databaseBuilder(getContext(),MyDatabase.class,"mydatabase.db").allowMainThreadQueries().build();
        CourseDAO courseDAO = myDatabase.createCourseDAO();
        List<Course> courses = courseDAO.getCourses();
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,courses);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentShowListStudents fragmentShowListStudents = new FragmentShowListStudents();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.MainFrameLayout,fragmentShowListStudents);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }




}