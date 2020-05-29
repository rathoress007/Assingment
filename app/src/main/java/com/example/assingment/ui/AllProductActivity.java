package com.example.assingment.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.assingment.adapter.ProductRecycleView;
import com.example.assingment.dbconnection.CreateProduct;
import com.example.assingment.dbconnection.DeleteProduct;
import com.example.assingment.dbconnection.GetProducts;
import com.example.assingment.dbconnection.UpdateProduct;
import com.example.assingment.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assingment.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class AllProductActivity extends AppCompatActivity {

    private ProductRecycleView productRecycleView;

    public AllProductActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        RecyclerView list_recycler_view = findViewById(R.id.list_recycler_view);

        // get data from bundle
        List<Product> products = new ArrayList<>();

        // set recycleView into adapter
        int numberOfColumns = 2;
        list_recycler_view.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

         productRecycleView = new ProductRecycleView(products, this, new ProductRecycleView.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, final int position, final Product product) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(AllProductActivity.this,view);

                //inflating menu from xml resource
                popup.inflate(R.menu.optional_menu);

                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            // update item
                            case R.id.update:

                                UpdateProduct updateProduct = new UpdateProduct(AllProductActivity.this,product);
                                updateProduct.execute();
                                getProducts();
                                break;

                             // delete item
                            case R.id.delete:

                                DeleteProduct deleteProduct = new DeleteProduct(AllProductActivity.this,product);
                                deleteProduct.execute();
                                getProducts();

                                break;

                        }

                        return false;
                    }
                });

                //displaying the popup
                popup.show();
            }
        });

        list_recycler_view.setAdapter(productRecycleView);

        //get all products
        getProducts();
    }


    private void getProducts(){
        GetProducts products = new GetProducts(AllProductActivity.this);
        try {
            List<Product>  productList = products.execute().get();
            productRecycleView.addItems(productList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
