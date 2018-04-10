package com.rsalas.lab7.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rsalas.lab7.R;
import com.rsalas.lab7.models.Company;
import com.rsalas.lab7.activities.InfoActivity;
import java.util.List;

/**
 * Created by USUARIO on 9/04/2018.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder>{

    private List<Company> company;

    public void setCompany(List<Company> company) {
        this.company = company;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView address;
        TextView phone;
        TextView email;
        TextView info;
        ImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            info = itemView.findViewById(R.id.info);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.companies, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Company company;
        company = this.company.get(position);
        int resId = holder.itemView.getContext().getResources().getIdentifier(company.getLogo(), "drawable", holder.itemView.getContext().getPackageName());
        holder.logo.setImageResource(resId);

        holder.name.setText(company.getName());
        holder.address.setText(company.getAddress());
        holder.phone.setText(company.getPhone());
        holder.info.setText(company.getInfo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(holder.itemView.getContext(), InfoActivity.class);
                Context ctx = holder.itemView.getContext();
                i.putExtra("foto",company.getLogo());
                i.putExtra("descripcion",company.getInfo());
                i.putExtra("numero",company.getPhone());
                ctx.startActivity(i);
            }
        });

    }
    @Override
    public int getItemCount() {
        return company.size();
    }
}