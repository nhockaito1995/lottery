package lottery.dhbk.nvmdung.lottery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lottery.dhbk.nvmdung.lottery.R;

/**
 * Created by nhockaito1995 on 29/04/2017.
 */

public class AwardAdapter extends BaseAdapter {

    public Context myContext;
    public int myLayout;
    public List<Award> arrayAward;

    public AwardAdapter(Context context, int layout, List<Award> awardList){
        myContext = context;
        myLayout = layout;
        arrayAward = awardList;
    }

    @Override
    public int getCount() {
        return arrayAward.size();
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

        TextView txtType = (TextView) convertView.findViewById(R.id.textViewType);
        txtType.setText(arrayAward.get(position).type);

        TextView txtResults = (TextView) convertView.findViewById(R.id.textViewResults);
        txtResults.setText(arrayAward.get(position).results);

        return convertView;
    }
}
