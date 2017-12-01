package com.smile.mohamed.mvpexample.presenter;

import com.smile.mohamed.mvpexample.extra.IAddPresenter;
import com.smile.mohamed.mvpexample.extra.IAddRepository;
import com.smile.mohamed.mvpexample.model.AddRepository;
import com.smile.mohamed.mvpexample.model.Student;
import com.smile.mohamed.mvpexample.view.AddStudentActivity;

import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public class AddPresenter implements IAddPresenter {

    private AddStudentActivity activity;
    private AddRepository repository;
    public AddPresenter(AddStudentActivity activity) {
        this.activity=activity;
        repository=new AddRepository();
    }

    @Override
    public void addStudent(List<Student> students) {
        repository.addStudent(students,new IAddRepository.onAddStudentCallback() {
            @Override
            public void onSuccess(String success) {
                activity.onAddStudent(success);
            }

            @Override
            public void onError(String error) {
                activity.onAddStudent(error);
            }
        });
    }
}
