package com.awei.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] func;
    private IconAdapter adapter;

    class IconAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int position) {
            return func[position];
        }

        @Override
        public long getItemId(int position) {
            return icons[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if(row == null){
                row = getLayoutInflater().inflate(R.layout.item_row,null);
                ImageView image = (ImageView)row.findViewById(R.id.item_image);
                TextView text = (TextView)row.findViewById(R.id.item_text);
                image.setImageResource(icons[position]);
                text.setText(func[position]);
            }
            return row;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.listView);
        func = new String[]{"查詢餘額","交易明細","最新消息","投資理財","離開"};
        //adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, func);
        GridView grid = (GridView)findViewById(R.id.grid);
        IconAdapter adapter = new IconAdapter();
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
        final Spinner notify = (Spinner)findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this,R.array.notify_array,
                android.R.layout.simple_spinner_item);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notify.setAdapter(nAdapter);
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,nAdapter.getItem(position),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch ((int)id){
                case R.drawable.func_balance:
                    break;
                case R.drawable.func_history:
                    break;
                case R.drawable.func_news:
                    break;
                case  R.drawable.func_finance:
                    break;
                case  R.drawable.func_exit:
                    finish();
                    break;
            }
    }
    int[] icons = {R.drawable.func_exit,
            R.drawable.func_finance,
            R.drawable.func_history,
            R.drawable.func_news,
            R.drawable.func_balance};
}
