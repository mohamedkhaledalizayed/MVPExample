package com.smile.mohamed.mvpexample.extra;

import com.smile.mohamed.mvpexample.model.Student;

import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public interface IAddRepository {

    void addStudent(List<Student> students,IAddRepository.onAddStudentCallback callback);

    interface onAddStudentCallback{
        void onSuccess(String success);
        void onError(String error);
    }
}
