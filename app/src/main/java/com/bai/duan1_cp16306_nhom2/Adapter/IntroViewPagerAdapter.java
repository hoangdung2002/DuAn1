package com.bai.duan1_cp16306_nhom2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bai.duan1_cp16306_nhom2.Model.ScreenItem;
import com.bai.duan1_cp16306_nhom2.R;

import java.util.List;

public class IntroViewPagerAdapter extends RecyclerView.Adapter<IntroViewPagerAdapter.ViewHolder>{
    private List<ScreenItem> list;

    public IntroViewPagerAdapter(List<ScreenItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_screen,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setOnboardingData(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_Title, tv_Description;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Title = itemView.findViewById(R.id.intro_title);
            tv_Description = itemView.findViewById(R.id.intro_description);
            img = itemView.findViewById(R.id.intro_img);
        }
        public void setOnboardingData(ScreenItem screenItem){
            tv_Title.setText(screenItem.getTitle());
            tv_Description.setText(screenItem.getDescription());
            img.setImageResource(screenItem.getScreenImg());
        }
    }
}
