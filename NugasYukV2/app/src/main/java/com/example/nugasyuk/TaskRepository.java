package com.example.nugasyuk;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTask;


    TaskRepository(Application application){
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTask = mTaskDao.getAll();
    }

    LiveData<List<Task>> getAllTugas(){
        return mAllTask;
    }

    void insert(Task tugas){
        TaskRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTaskDao.insert(tugas);
        });
    }

    void deleteTask(Task task) {

    }
}

//        TaskRoomDatabase.databaseWriteExecutor.execute(() -> {
//            mTaskDao.deleteTask(task);
//        });
//        new DeleteCourseAsyncTask(mTaskDao).execute(model);