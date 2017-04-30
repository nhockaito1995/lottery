package lottery.dhbk.nvmdung.lottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lottery.dhbk.nvmdung.lottery.R;
import lottery.dhbk.nvmdung.lottery.listitem.Date;

/**
 * Created by nhockaito1995 on 30/04/2017.
 */

public class DateAdapter extends BaseAdapter {

    public Context myContext;
    public int myLayout;
    public List<Date> arrayDate;

    public DateAdapter(Context myContext, int myLayout, List<Date> arrayDate) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayDate = arrayDate;
    }

    @Override
    public int getCount() {
        return arrayDate.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(myLayout, null);

        TextView txtDate = (TextView) convertView.findViewById(R.id.textViewDate);
        txtDate.setText(arrayDate.get(position).date);

        return convertView;
    }
}
