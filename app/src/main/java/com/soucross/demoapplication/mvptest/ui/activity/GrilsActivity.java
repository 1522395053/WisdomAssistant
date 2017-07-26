package com.soucross.demoapplication.mvptest.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.soucross.demoapplication.R;
import com.soucross.demoapplication.mvptest.entity.Gril;
import com.soucross.demoapplication.mvptest.ui.IGrilView;

import com.soucross.demoapplication.mvptest.presenter.GrilPresenter;
import java.util.List;

/**
 * Activity 属于View层（ui层），所以要实现IGrilView
 */
public class GrilsActivity extends AppCompatActivity implements IGrilView{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grils);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //通过构造方法传入了 Activity，即 IGrilView 的实现类 this
        //中间者 让 fetch 方法 触发加载数据
        new GrilPresenter(this).fetch();

    }

    @Override
    public void showLoading() {

        Toast.makeText(this,"正在拼命加载...",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void hideLoading() {
        Toast.makeText(this,"加载完成",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showGrils(List<Gril> grils) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,grils));


    }

    class GrilAdapter  extends RecyclerView.Adapter<GrilAdapter.GirlHolder>{
        private List<Gril> grils;

        public GrilAdapter(List<Gril> grils) {
            this.grils = grils;
        }

        @Override
        public GirlHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(GirlHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return grils.size();
        }

        class GirlHolder extends RecyclerView.ViewHolder{

            public GirlHolder(View itemView) {
                super(itemView);
            }
        }

    }
}
