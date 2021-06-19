package com.pucpr.medtime_ra2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView mImgeView;
    TextView mTitle, mDes;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImgeView = itemView.findViewById(R.id.imageTv);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        this.mDes= itemView.findViewById(R.id.descricaoTv);
    }
}
