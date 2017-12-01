package com.smile.mohamed.mvpexample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.smile.mohamed.mvpexample.R;
import com.smile.mohamed.mvpexample.extra.Adapter;
import com.smile.mohamed.mvpexample.model.Student;
import com.smile.mohamed.mvpexample.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MainPresenter presenter;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        listView=(ListView)findViewById(R.id.list);
        presenter=new MainPresenter(this);
        presenter.getAllStudent();
    }

    public void getAllStudent(ArrayList<Student> students){
        if (students == null) {
            Toast.makeText(getBaseContext(),"No Student",Toast.LENGTH_LONG).show();
        }else {
            System.out.println(students);
            adapter=new Adapter(this,students);
            listView.setAdapter(adapter);
        }
    }

    public void error(String s){
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add) {
            startActivity(new Intent(MainActivity.this,AddStudentActivity.class));
        }
        return true;
    }
}
