package lottery.dhbk.nvmdung.lottery.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import lottery.dhbk.nvmdung.lottery.R;
import lottery.dhbk.nvmdung.lottery.activity.ResultActivity;
import lottery.dhbk.nvmdung.lottery.adapter.AwardAdapter;
import lottery.dhbk.nvmdung.lottery.adapter.DateAdapter;
import lottery.dhbk.nvmdung.lottery.listitem.Award;
import lottery.dhbk.nvmdung.lottery.listitem.Date;

/**
 * Created by nhockaito1995 on 29/04/2017.
 */

public class FragmentAward extends android.app.Fragment {

    ListView lvAward;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.flagment_data, container, true);

        lvAward = (ListView) fragmentView.findViewById(R.id.ListViewFragment);

        return fragmentView;
    }

    public String getElement(String str){
        String result = "";
        String s = str.replace("[","").replace("]","");
        String[] a = s.split(",");
        for (int i=0; i < a.length; i++){
            if (i == 0) result += a[i];
            else result += "-"+a[i];
        }
        return result;
    }

    public void showAwards(JSONObject s) throws JSONException {

        ArrayList<Award> arrayAward;
        arrayAward = new ArrayList<Award>();

        arrayAward.add(new Award("Giải nhất",getElement(s.getString("1"))));
        arrayAward.add(new Award("Giải nhì",getElement(s.getString("2"))));
        arrayAward.add(new Award("Giải ba",getElement(s.getString("3"))));
        arrayAward.add(new Award("Giải bốn",getElement(s.getString("4"))));
        arrayAward.add(new Award("Giải năm",getElement(s.getString("5"))));
        arrayAward.add(new Award("Giải sáu",getElement(s.getString("6"))));
        arrayAward.add(new Award("Giải bảy",getElement(s.getString("7"))));
        arrayAward.add(new Award("Giải tám",getElement(s.getString("8"))));
        arrayAward.add(new Award("Giải đặc biệt",getElement(s.getString("DB"))));

        AwardAdapter adapter = new AwardAdapter(
                getActivity(),
                R.layout.award_list,
                arrayAward
        );

        lvAward.setAdapter(adapter);
    }

    public void showDates(JSONObject s) throws JSONException {

        final ArrayList<Date> arrayDate = new ArrayList<Date>();

        Iterator<String> iter = s.keys(); //This should be the iterator you want.

        while(iter.hasNext()){
            String key = iter.next();
            arrayDate.add(new Date(key));
        }

        DateAdapter adapter = new DateAdapter(
                getActivity(),
                R.layout.date_list,
                arrayDate
        );

        lvAward.setAdapter(adapter);

        lvAward.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((ResultActivity) getActivity()).changedates(arrayDate.get(position).date);
            }
        });
    }
}
