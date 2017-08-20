package kr.ac.cnu.pyeongchang101.pyeongchang101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HwangTaeWook on 2017-08-21.
 */

public class EventListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Event> itemList;
    private int layout;

    public EventListAdapter(Context context, int layout, ArrayList<Event> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        EventViewHolder viewHolder;

        //캐시된 뷰가 없을 경우
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new EventViewHolder();
            viewHolder.icon = 
        }
        return null;
    }
}

class EventViewHolder {
    public Button icon;
    public TextView title;
}

class Event {
    int icon;
    String title;

    public Event(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }
}
