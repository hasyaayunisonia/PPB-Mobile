package com.example.nugasyuk;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTask;


    TaskRepository(Application application){
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTask = mTaskDao.getAlphabetizedWords();
    }

    LiveData<List<Task>> getAllTugas(){
        return mAllTask;
    }

    void insert(Task tugas){
        TaskRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTaskDao.insert(tugas);
        });
    }

}
