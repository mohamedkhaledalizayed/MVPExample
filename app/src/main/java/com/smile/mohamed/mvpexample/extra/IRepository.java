package com.smile.mohamed.mvpexample.extra;

import com.smile.mohamed.mvpexample.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */

public interface IRepository {
    void getAllStudent(onGetALLStudentCallback callback);

    interface onGetALLStudentCallback{
        void onSuccess(ArrayList<Student> success);
        void onError(String error);
    }

}
