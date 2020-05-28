package com.example.assingment.dbconnection;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.example.assingment.db.DataBaseClient;
import com.example.assingment.model.Product;

public class CreateProduct extends AsyncTask<Void, Void, Void> {

    private Context mContext;
    private Product product;

    // constructor
    public CreateProduct (Context mContext,Product product){
        this.mContext = mContext;
        this.product = product;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        //adding to database
        DataBaseClient.getInstance(mContext).getAppDatabase()
                .productDao()
                .insert(product);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "Saved", Toast.LENGTH_LONG).show();
    }

}

