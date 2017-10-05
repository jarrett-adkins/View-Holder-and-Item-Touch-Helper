package com.example.admin.listviewwithviewholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_DRAG;
import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;
import static android.support.v7.widget.helper.ItemTouchHelper.DOWN;
import static android.support.v7.widget.helper.ItemTouchHelper.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.UP;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private List<Person> personList;
    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recyclerView = findViewById(R.id.rvPersonList);

        personList = new ArrayList<>();
        personList.add(new Person("Jarett", "Adkins"));
        personList.add(new Person("Mac", "Myers"));
        personList.add(new Person("Jason", "Gomez"));
        personList.add(new Person("Joseph", "Casal"));
        personList.add(new Person("Ryen", "Greene"));

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        RecyclerViewPersonListAdapter adapter = new RecyclerViewPersonListAdapter(personList);

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ACTION_STATE_SWIPE, LEFT ) | makeFlag(ACTION_STATE_DRAG, UP | DOWN);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                if( viewHolder.getAdapterPosition() == target.getAdapterPosition() )
                    return true;

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setItemAnimator( itemAnimator );
        recyclerView.setAdapter( adapter );

        itemTouchHelper.attachToRecyclerView( recyclerView );
    }
}
