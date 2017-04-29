package lottery.dhbk.nvmdung.lottery.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lottery.dhbk.nvmdung.lottery.R;

/**
 * Created by nhockaito1995 on 29/04/2017.
 */

public class FragmentAward extends android.app.Fragment {

    ListView lvAward;
    ArrayList<Award> arrayAward;

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
}
