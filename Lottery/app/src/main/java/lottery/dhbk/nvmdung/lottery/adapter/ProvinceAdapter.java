package lottery.dhbk.nvmdung.lottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import lottery.dhbk.nvmdung.lottery.R;
import lottery.dhbk.nvmdung.lottery.listitem.Province;

/**
 * Created by nhockaito1995 on 29/04/2017.
 */

public class ProvinceAdapter extends BaseAdapter {

    public Context myContext;
    public int myLayout;
    public List<Province> arrayProvince;

    public ProvinceAdapter(Context context, int layout, List<Province> provinceList){
        myContext = context;
        myLayout = layout;
        arrayProvince = provinceList;
    }

    @Override
    public int getCount() {
        return arrayProvince.size();
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

        TextView txtProvinceCode = (TextView) convertView.findViewById(R.id.textViewProvinceCode);
        txtProvinceCode.setText(arrayProvince.get(position).ProvinceCode);

        TextView txtProvinceName = (TextView) convertView.findViewById(R.id.textViewProvinceName);
        txtProvinceName.setText(arrayProvince.get(position).ProvinceName);

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        imgIcon.setImageResource(arrayProvince.get(position).IconNext);

        return convertView;
    }
}
