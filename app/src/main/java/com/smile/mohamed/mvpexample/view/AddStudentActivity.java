package com.smile.mohamed.mvpexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.smile.mohamed.mvpexample.R;
import com.smile.mohamed.mvpexample.model.Student;
import com.smile.mohamed.mvpexample.presenter.AddPresenter;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    private AddPresenter presenter;
    EditText id,name,phone,address,grade,email;
    List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();
    }

    public void addStudent(View view) {
        Student student=new Student();
        student.setId(id.getText().toString());
        student.setName(name.getText().toString());
        student.setPhone(phone.getText().toString());
        student.setAddress(address.getText().toString());
        student.setGrade(grade.getText().toString());
        student.setEmail(email.getText().toString());

        students.add(student);
        presenter.addStudent(students);
    }

    public void onAddStudent(String s){
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
    }

    public void init(){
        presenter=new AddPresenter(this);
        students=new ArrayList<>();
        id=(EditText)findViewById(R.id.id);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        grade=(EditText)findViewById(R.id.grade);
        email=(EditText)findViewById(R.id.email);
    }
}
