package com.smile.mohamed.mvpexample.presenter;

import com.smile.mohamed.mvpexample.extra.IPresenter;
import com.smile.mohamed.mvpexample.extra.IRepository;
import com.smile.mohamed.mvpexample.model.MainRepository;
import com.smile.mohamed.mvpexample.model.Student;
import com.smile.mohamed.mvpexample.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public class MainPresenter implements IPresenter {
    private MainActivity activity;
    private MainRepository repository;
    public MainPresenter(MainActivity activity){
        this.activity=activity;
        repository=new MainRepository();
    }

    @Override
    public void getAllStudent() {
        repository.getAllStudent(new IRepository.onGetALLStudentCallback() {
            @Override
            public void onSuccess(ArrayList<Student> students) {
                activity.getAllStudent(students);
            }

            @Override
            public void onError(String error) {
                activity.error(error);
            }
        });
    }
}
