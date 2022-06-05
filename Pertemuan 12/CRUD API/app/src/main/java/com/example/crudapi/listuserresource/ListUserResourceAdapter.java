package com.example.crudapi.listuserresource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListUserResourceAdapter extends RecyclerView.Adapter<ListUserResourceAdapter.ViewHolder>{
    private List<DataItemListResource> dataUserResource;
    private Context mContext;

    public ListUserResourceAdapter(List<DataItemListResource> dataUserResource, Context mContext) {
        this.dataUserResource = dataUserResource;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_resource, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(dataUserResource.get(i).getName());
        viewHolder.tvColor.setText(dataUserResource.get(i).getColor());
        viewHolder.tvPantoneValue.setText(dataUserResource.get(i).getPantoneValue());
    }

    @Override
    public int getItemCount() {
        return dataUserResource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nameResource)
        TextView tvName;
        @BindView(R.id.tv_colorResource)
        TextView tvColor;
        @BindView(R.id.tv_pantoneResource)
        TextView tvPantoneValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
