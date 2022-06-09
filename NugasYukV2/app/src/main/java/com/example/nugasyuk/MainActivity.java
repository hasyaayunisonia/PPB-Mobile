package com.example.nugasyuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private TaskViewModel mWordViewModel;
    List<Task> list;
    FloatingActionButton addbutton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        addbutton = findViewById(R.id.fab);
        addbutton.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        recyclerView = findViewById(R.id.mytask);
        final TaskListAdapter taskListAdapter = new TaskListAdapter(new TaskListAdapter.TaskDiff(), this);
        recyclerView.setAdapter(taskListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TaskViewModel.class);
        mWordViewModel.getAllTask().observe(this, task -> {
            taskListAdapter.submitList(task);
        });

//        mWordViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TugasViewModel.class);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
//        NavController navController = Navigation.findNavController(this,R.id.nav_graph);
//        NavigationUI.setupWithNavController(navigationView,navController);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Task task = data.getParcelableExtra("task");

            mWordViewModel.insert(task);

            Toast.makeText(this,"Tugas tersimpan",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Tugas gagal tersimpan",Toast.LENGTH_SHORT).show();
        }
    }
}