package com.example.standard;


import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

public class CpAdapter extends RecyclerView.Adapter<CpAdapter.CpViewHolder> {
    Cursor mcCursor;
    int bodyColIndex;
    int addressColIndex;
    public CpAdapter(@Nullable Cursor dataCursor) {
        mcCursor = dataCursor;
        bodyColIndex = mcCursor.getColumnIndexOrThrow("body");
        addressColIndex = mcCursor.getColumnIndexOrThrow("address");
    }

    @NonNull
    @Override
    public CpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View plank = LayoutInflater.from(parent.getContext()).inflate(R.layout.cp_row,parent,false);

        return new CpViewHolder(plank);
    }

    @Override
    public void onBindViewHolder(@NonNull CpViewHolder holder, int position) {
        mcCursor.moveToPosition(position);
        String body = mcCursor.getString(bodyColIndex);
        String phno = mcCursor.getString(addressColIndex);
        holder.tvHeader.setText(phno);
        holder.tvSummary.setText(body);
    }

    @Override
    public int getItemCount() {
        return mcCursor.getCount();
    }

    class CpViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeader;
        TextView tvSummary;
        public CpViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeader);
            tvSummary = itemView.findViewById(R.id.tvSummary);
        }
    }
}
