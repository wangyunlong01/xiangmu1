package com.example.bw.xiangmu1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bawei.jane.mxlistview.view.XListView;
import com.example.bw.bean.Goods;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  XListView.IXListViewListener {

    private XListView xlv;
    private List<Goods.ResultBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        xlv.setAdapter(adapter);
        initdata();


    }

    private void initView(){

        xlv = findViewById(R.id.xlv);
        xlv.setPullLoadEnable(true);
        xlv.setXListViewListener(this);

    }

    class  Adapter extends BaseAdapter{

        public  Adapter(){
            super();
        }
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    class MyAsyncTaskString extends AsyncTask<String, Void, String>{


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Goods goods = gson.fromJson(s, Goods.class);

            List<Goods.ResultBean.DataBean> data = goods.getResult().getData();
            Log.e("www",  "onPostExecute:tempList "+tempList.size());



        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }



    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
