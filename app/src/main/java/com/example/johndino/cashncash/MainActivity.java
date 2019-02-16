package com.example.johndino.cashncash;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private DatabaseReference reference;
private RecyclerView recyclerView;
private String statusa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = FirebaseDatabase.getInstance().getReference();
        reference.keepSynced(true);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //textView = (TextView)findViewById(R.id.status);




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<AtmListModel,AtmViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<AtmListModel, AtmViewHolder>(
                AtmListModel.class,R.layout.card,AtmViewHolder.class,reference
        ) {
            @Override
            protected void populateViewHolder(AtmViewHolder viewHolder, AtmListModel model, int position) {
                  viewHolder.setName(model.getName());
                  viewHolder.setStatus(model.getStatus());
                  statusa = model.getStatus();
                if (statusa.equals("cash")){
                 viewHolder.textView.setTextColor(Color.GREEN);
                 viewHolder.imageView.setImageResource(R.drawable.ic_local_atmgreen_black_24dp);
                }
                else{
                    viewHolder.textView.setTextColor(Color.RED);
                    viewHolder.imageView.setImageResource(R.drawable.ic_local_atm_black_24dp);

                }



            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
    public static class AtmViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView textView;
        ImageView imageView;

        public AtmViewHolder(View itemView){
            super(itemView);
            mView=itemView;
            textView = (TextView)mView.findViewById(R.id.status);
            imageView =(ImageView)mView.findViewById(R.id.imageview);



        }
        public void setName(String name){
            TextView post_name = (TextView) mView.findViewById(R.id.name);
            post_name.setText(name);
        }
        public void setAddress(String address){
            TextView post_add = (TextView) mView.findViewById(R.id.address);
            post_add.setText(address);
        }
        public void setStatus(String status){
            TextView post_status = (TextView) mView.findViewById(R.id.status);
            post_status.setText(status);
        }



    }

}
