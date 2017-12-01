package com.smile.mohamed.mvpexample.model;

import android.database.Cursor;

import com.smile.mohamed.mvpexample.app.App;
import com.smile.mohamed.mvpexample.extra.Database;
import com.smile.mohamed.mvpexample.extra.IRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public class MainRepository implements IRepository {
    private Database MyDb;
    private ArrayList list;
    @Override
    public void getAllStudent(onGetALLStudentCallback callback) {
        if (callback!=null){
            callback.onSuccess(getStudent());
        }
    }

    public ArrayList<Student> getStudent() {
        MyDb=new Database(App.getInstance());
        Cursor res = MyDb.getAll();
        if (res.getCount() != 0) {
            list = new ArrayList<Student>();

            while (res.moveToNext()) {

                Student student = new Student();
                student.setId(res.getString(0));
                student.setName(res.getString(1));
                //student.setPhone(res.getString(2));
                student.setAddress(res.getString(3));
                student.setGrade(res.getString(4));
                //student.setEmail(res.getString(5));

                list.add(student);
            }
        }
        return list;
    }
}
