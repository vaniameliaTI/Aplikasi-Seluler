package com.example.project_input_nama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    private List<NameModel> nameList;

    public NameAdapter(List<NameModel> nameList) {
        this.nameList = nameList;
    }

    @Override
    public NameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameAdapter.ViewHolder holder, int position) {
        holder.nameTextView.setText(nameList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}
