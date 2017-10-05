package com.example.admin.listviewwithviewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/4/2017.
 */

public class RecyclerViewPersonListAdapter extends RecyclerView.Adapter<RecyclerViewPersonListAdapter.RecyclerViewHolder> {

    public static final String TAG = "PersonListAdapter";
    List<Person> personList = new ArrayList<>();

    public RecyclerViewPersonListAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.recycler_view_list, parent, false );

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewPersonListAdapter.RecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Person p = personList.get( position );
        holder.personFirstName.setText( p.getName() );
        holder.personSurname.setText( p.getSurname() );
    }


    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: ");

        return personList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView personFirstName, personSurname;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            personFirstName = itemView.findViewById( R.id.tvrcPersonFirstName );
            personSurname =  itemView.findViewById( R.id.tvrcPersonSurname );
        }
    }
}