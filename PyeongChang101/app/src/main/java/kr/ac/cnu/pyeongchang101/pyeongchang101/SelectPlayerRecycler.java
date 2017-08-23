package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HwangTaeWook on 2017-08-23.
 */

public class SelectPlayerRecycler extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selectplayer);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("김선수(21)"));
        items.add(new Item("이선수(22)"));
        items.add(new Item("최선수(27)"));
        items.add(new Item("박선수(23)"));
        items.add(new Item("전선수(25)"));

        layoutManager = new LinearLayoutManager(this, 0, true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CardAdapter(items, mContext);
        recyclerView.setAdapter(adapter);
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView stamina;
        public TextView strength;
        public TextView speed;
        public TextView mental;

        public Holder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            stamina = (TextView) view.findViewById(R.id.stamina);
            strength = (TextView) view.findViewById(R.id.strength);
            speed = (TextView) view.findViewById(R.id.speed);
            mental = (TextView) view.findViewById(R.id.mental);
            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/TmonMonsori.ttf");

            name.setTypeface(face);
            stamina.setTypeface(face);
            strength.setTypeface(face);
            speed.setTypeface(face);
            mental.setTypeface(face);
        }
    }

    class CardAdapter extends RecyclerView.Adapter<Holder> {
        private Context context;
        private ArrayList<Item> mItems;

        public CardAdapter(ArrayList<Item> items, Context mContext) {
            mItems = items;
            context = mContext;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.name.setText(mItems.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}
