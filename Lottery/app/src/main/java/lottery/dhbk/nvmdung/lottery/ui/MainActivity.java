package lottery.dhbk.nvmdung.lottery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import lottery.dhbk.nvmdung.lottery.R;

public class MainActivity extends AppCompatActivity {

    ListView lvProvince;
    ArrayList<Province> arrayProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProvince = (ListView) findViewById(R.id.ListViewProvince);
        arrayProvince = new ArrayList<Province>();

        arrayProvince.add(new Province("AG","AN GIANG",R.drawable.nexticon));
        arrayProvince.add(new Province("BD","BÌNH DƯƠNG",R.drawable.nexticon));
        arrayProvince.add(new Province("BL","BẠC LIÊU",R.drawable.nexticon));
        arrayProvince.add(new Province("BP","BÌNH PHƯỚC",R.drawable.nexticon));
        arrayProvince.add(new Province("BTH","BÌNH THUẬN",R.drawable.nexticon));
        arrayProvince.add(new Province("CM","CÀ MAU",R.drawable.nexticon));
        arrayProvince.add(new Province("CT","CẦN THƠ",R.drawable.nexticon));
        arrayProvince.add(new Province("HCM","HỒ CHÍ MINH",R.drawable.nexticon));

        ProvinceAdapter adapter = new ProvinceAdapter(
                MainActivity.this,
                R.layout.province_list,
                arrayProvince
        );

        lvProvince.setAdapter(adapter);

        lvProvince.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent resultPage = new Intent(MainActivity.this,ResultActivity.class);
                resultPage.putExtra("provinceCode",arrayProvince.get(position).ProvinceCode);
                resultPage.putExtra("provinceName",arrayProvince.get(position).ProvinceName);
                startActivity(resultPage);
            }
        });
    }
}
