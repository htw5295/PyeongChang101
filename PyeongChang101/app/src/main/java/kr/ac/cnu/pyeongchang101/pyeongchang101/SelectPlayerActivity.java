package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HwangTaeWook on 2017-08-23.
 */

public class SelectPlayerActivity extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    View prevView;

    ArrayList<Item> items = new ArrayList<Item>();
    boolean check[] = new boolean[5];
    int count = 0;
    int mode;

    private View 	decorView;
    private int	uiOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selectplayer);

        Intent intent = getIntent();
        mode = intent.getIntExtra("mode", 2);

        mContext = getApplicationContext();

        prevView = (View) findViewById(R.id.woman_btn);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        items.add(new Item("김선수(21)", 0, 0));
        items.add(new Item("이선수(22)", 0, 0));
        items.add(new Item("최선수(27)", 0, 0));
        items.add(new Item("박선수(23)", 0, 0));
        items.add(new Item("전선수(25)", 0, 0));

        layoutManager = new LinearLayoutManager(this, 0, true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CardAdapter(items, mContext);
        recyclerView.setAdapter(adapter);

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        // super.onWindowFocusChanged(hasFocus);

        if( hasFocus ) {
            decorView.setSystemUiVisibility( uiOption );
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView stamina;
        public TextView strength;
        public TextView speed;
        public TextView mental;
        public ImageView image;

        public Holder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.card);
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
        public int getItemViewType(int position) {
            if (mItems.get(position).getCheck() == 0) {
                return position;
            } else {
                return position + 10;
            }
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType < 10) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_small, parent, false);
                view.setTag((Object)viewType);
            } else {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_big, parent, false);
                view.setTag((Object)(viewType - 10));
            }
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.name.setText(mItems.get(position).getName());
            if (mItems.get(position).getGender() == 0) {
                if (mItems.get(position).getCheck() == 0) {
                    holder.image.setImageResource(R.drawable.card_woman_small);
                } else {
                    holder.image.setImageResource(R.drawable.card_woman_big);
                }
            } else {
                if (mItems.get(position).getCheck() == 0) {
                    holder.image.setImageResource(R.drawable.card_man_small);
                } else {
                    holder.image.setImageResource(R.drawable.card_man_big);
                }
            }
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    public void onClickPlayer(View view) {
        int i = (int) view.getTag();
        if (check[i]) {
            check[i] = false;
            items.set(i, new Item(items.get(i).getName(), items.get(i).getGender(), 0));
            count--;
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        } else if (count < mode) {
            check[i] = true;
            items.set(i, new Item(items.get(i).getName(), items.get(i).getGender(), 1));
            count++;
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "선수를 모두 선택하였습니다.", Toast.LENGTH_LONG);
        }
    }

    public void onClickGameStart(View view) {
        if (count == mode) {
            findViewById(R.id.start_btn).setBackgroundResource(R.drawable.selected_start_btn);
            Intent nextIntent = new Intent(this, MainActivity.class);
            startActivity(nextIntent);
            finish();
        }else {
            Toast.makeText(this, "선수를 모두 선택해 주세요.", Toast.LENGTH_LONG);
        }
    }

    public void onClickGender(View view) {
        if (!(view.equals(prevView))) {
            if (((String)view.getTag()).equals("0")) {
                items.clear();
                items.add(new Item("김선수(21)", 0, 0));
                items.add(new Item("이선수(22)", 0, 0));
                items.add(new Item("최선수(27)", 0, 0));
                items.add(new Item("박선수(23)", 0, 0));
                items.add(new Item("전선수(25)", 0, 0));
                view.setBackgroundResource(R.drawable.selected_woman_btn);
                prevView.setBackgroundResource(R.drawable.unselected_man_btn);
            } else {
                items.clear();
                items.add(new Item("김선수(21)", 1, 0));
                items.add(new Item("이선수(22)", 1, 0));
                items.add(new Item("최선수(27)", 1, 0));
                items.add(new Item("박선수(23)", 1, 0));
                items.add(new Item("전선수(25)", 1, 0));
                view.setBackgroundResource(R.drawable.selected_man_btn);
                prevView.setBackgroundResource(R.drawable.unselected_woman_btn);
            }
            for (int i = 0; i < 5; i++) {
                check[i] = false;
            }
            prevView = view;
            count = 0;
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }
    }
}
