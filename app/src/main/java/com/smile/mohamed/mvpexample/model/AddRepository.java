package com.smile.mohamed.mvpexample.model;

import com.smile.mohamed.mvpexample.app.App;
import com.smile.mohamed.mvpexample.extra.Database;
import com.smile.mohamed.mvpexample.extra.IAddRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public class AddRepository implements IAddRepository{
    private Database MyDb;
    @Override
    public void addStudent(List<Student> students,onAddStudentCallback callback) {
        if (callback!=null){
            if (addData(students)){
                callback.onSuccess("Success");
            }
            else
                callback.onError("Failed");
        }
    }

    public boolean addData(List<Student> list){
        MyDb=new Database(App.getInstance());
        Student item=list.get(0);

        boolean inserted = MyDb.insertStudent(
                item.getId(),
                item.getName(),
                item.getPhone(),
                item.getAddress(),
                item.getGrade(),
                item.getEmail());

        return inserted;
    }
}
