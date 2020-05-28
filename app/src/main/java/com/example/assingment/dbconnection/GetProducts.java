package com.example.assingment.dbconnection;

import android.content.Context;
import android.os.AsyncTask;
import com.example.assingment.db.DataBaseClient;
import com.example.assingment.model.Product;
import java.util.List;

public class GetProducts extends AsyncTask<Void, Void, List<Product>> {

    private Context mContext;

    // constructor
    public GetProducts (Context mContext){
        this.mContext = mContext;
    }

    @Override
    protected List<Product> doInBackground(Void... voids) {
        List<Product> productList = DataBaseClient
                .getInstance(mContext)
                .getAppDatabase()
                .productDao()
                .getAll();
        return productList;
    }

    @Override
    protected void onPostExecute(List<Product> products) {
        super.onPostExecute(products);
          /*  TasksAdapter adapter = new TasksAdapter(MainActivity.this, tasks);
            recyclerView.setAdapter(adapter);*/
    }
}
