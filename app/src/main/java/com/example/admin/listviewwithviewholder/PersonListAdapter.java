package com.example.admin.listviewwithviewholder;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 10/2/2017.
 */

public class PersonListAdapter extends ArrayAdapter<Person> {

    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, List<Person> personList) {
        super(context, resource, personList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if( convertView == null ) {
            //inflate the view with custom layout xml
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null);

            //bind the views
            holder = new ViewHolder( convertView );
            holder.nameTextView = convertView.findViewById( R.id.tvPersonName );
            holder.surnameTextView = convertView.findViewById( R.id.tvPersonSurName );

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        //set the values
        Person person = getItem( position );

        holder.nameTextView.setText( person.getName() );
        holder.surnameTextView.setText( person.getSurname() );

        return convertView;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
