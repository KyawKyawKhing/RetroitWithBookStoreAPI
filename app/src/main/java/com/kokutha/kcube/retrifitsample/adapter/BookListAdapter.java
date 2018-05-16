package com.kokutha.kcube.retrifitsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kokutha.kcube.retrifitsample.R;
import com.kokutha.kcube.retrifitsample.model.BookModel;

import java.util.ArrayList;

/**
 * Created by K Cube on 5/15/2018.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.MyViewHolder> {

    private ArrayList<BookModel> mBookModels;

    public BookListAdapter() {
        mBookModels = new ArrayList<>();
    }

    public void addList(ArrayList<BookModel> bookModels) {
        mBookModels = bookModels;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mBookModels.get(position).getName());
        holder.tv_description.setText(mBookModels.get(position).getDescription());
        Glide.get(holder.imageView.getContext()).clearDiskCache();
        String photo_url = "http://192.168.43.32/BookStore/public/backend/upload/";
        Glide.with(holder.itemView.getContext())
                .load(photo_url)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mBookModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_description;
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.name);
            tv_description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.book_image);
        }
    }
}
