package com.example.dong.apigit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataOfGitAdapter extends RecyclerView.Adapter<DataOfGitAdapter.ViewHolderDataOfGit> {

    private List<DataOfGit> mItemGits;
    private Context mContext;

    public DataOfGitAdapter(Context context, List<DataOfGit> itemGits) {
        this.mContext = context;
        this.mItemGits = itemGits;
    }

    @NonNull
    @Override
    public ViewHolderDataOfGit onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_data, viewGroup, false);
        return new ViewHolderDataOfGit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDataOfGit viewHolderData, int position) {
        DataOfGit itemGit = mItemGits.get(position);
        viewHolderData.mTextName.setText(itemGit.getName());
        viewHolderData.mTextFullName.setText(itemGit.getFullName());
        viewHolderData.mTextUrl.setText(itemGit.getUrl());
    }

    @Override
    public int getItemCount() {
        return mItemGits == null ? 0 : mItemGits.size();
    }

    public class ViewHolderDataOfGit extends RecyclerView.ViewHolder {

        private TextView mTextName;
        private TextView mTextFullName;
        private TextView mTextUrl;

        public ViewHolderDataOfGit(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextFullName = itemView.findViewById(R.id.text_full_name);
            mTextUrl = itemView.findViewById(R.id.text_uri);
        }

    }

}
