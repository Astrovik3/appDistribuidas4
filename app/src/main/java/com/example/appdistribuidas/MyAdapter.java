package com.example.appdistribuidas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String titles[], dates[], states[];


    public MyAdapter (Context ct, String[] ttls, String[] dts, String[] stts){
        context = ct;
        titles = ttls;
        dates = dts;
        states = stts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_lists, parent, false);
        return new MyViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textTitle.setText(titles[position]);
        holder.textDate.setText(dates[position]);
        holder.textStatus.setText(states[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textDate, textStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textView3);
            textDate = itemView.findViewById(R.id.textView4);
            textStatus = itemView.findViewById(R.id.textView5);
        }
    }
}
