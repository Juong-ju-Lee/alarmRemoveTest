package com.example.testa;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testa.AlarmList;
import com.example.testa.MainActivity;
import com.example.testa.R;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.CustomViewHolder> {


    //수정코드
   // MainActivity m = new MainActivity();
    //수정코드



    private ArrayList<AlarmList>arrayList;

    public AlarmAdapter(ArrayList<AlarmList>arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AlarmAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmAdapter.CustomViewHolder holder, int position) {
        holder.alarmImg.setImageResource(arrayList.get(position).getAlarmImg());
        holder.alarmName.setText(arrayList.get(position).getAlarmName());
        holder.alarmContent.setText(arrayList.get(position).getAlarmContent());

        holder.itemView.setTag(position);








        /*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.alarmName.getText().toString();
                Toast.makeText(v.getContext(),curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

               remove(holder.getAdapterPosition());
                return true;
            }
        });
*/


    }




    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() :0);
    }


        public void remove(int position){
            try{
                arrayList.remove(position);
                notifyItemRemoved(position);
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public static int position;
        protected ImageView alarmImg;
        protected TextView alarmName;
        protected TextView alarmContent;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.alarmImg=(ImageView) itemView.findViewById(R.id.alarmImg);
            this.alarmName=(TextView) itemView.findViewById(R.id.alarmName);
            this.alarmContent=(TextView) itemView.findViewById(R.id.alarmContent);
        }
    }
}