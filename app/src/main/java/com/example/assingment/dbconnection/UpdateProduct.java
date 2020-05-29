package com.example.assingment.dbconnection;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.assingment.db.DataBaseClient;
import com.example.assingment.model.Product;

public class UpdateProduct extends AsyncTask<Void, Void, Void> {

    private Context mContext;
    private Product product;


      // constructor
       public UpdateProduct (Context mContext, Product product){
        this.mContext = mContext;
        this.product = product;
       }

       @Override
       protected Void doInBackground(Void... voids) {
           product.setRegularPrice(product.getRegularPrice());
           product.setSalePrice(product.getSalePrice());
           product.setProductPhoto(product.getProductPhoto());
           product.setDescription("Product Description");
           product.setName(product.getName() + " updated");
           DataBaseClient.getInstance(mContext).getAppDatabase()
          .productDao()
          .update(product);
         return null;
        }

       @Override
       protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "Updated", Toast.LENGTH_LONG).show();

        }
}
