package com.example.admin.listviewwithviewholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById( R.id.listView );

        /*
        String[] arr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_view_item, arr));
        */

        personList = new ArrayList<>();

        personList.add( new Person( "Jarrett", "Adkins" ));
        personList.add( new Person( "Mac", "Myers" ));
        personList.add( new Person( "Jason", "Gomez" ));
        personList.add( new Person( "Joseph", "Casal" ));
        personList.add( new Person( "Ryen", "Greene" ));

        PersonListAdapter psa = new PersonListAdapter( this, R.layout.list_view_item, personList);

        listView.setAdapter( psa );

    }

    public void goToSecond(View view) {
        Intent intent = new Intent( this, RecycleActivity.class );
        startActivity( intent );
    }
}

/*
X 1. Create a list view that uses a view holder pattern.
2. Create a recycler view that use the item touch helper class to drag and swipe items

-Use different view types for items in the listView and the RecyclerView

we used list view in:
Navigation Drawer
Saving Data
 */