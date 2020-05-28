package com.example.assingment.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.assingment.adapter.ProductRecycleView;
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

import java.util.List;

public class AllProductActivity extends AppCompatActivity {

    public AllProductActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        RecyclerView list_recycler_view = findViewById(R.id.list_recycler_view);

        // get data from bundle
        Parcelable parcelable = getIntent().getParcelableExtra("product");
        List<Product> products = Parcels.unwrap(parcelable);

        // set recycleView into adapter
        int numberOfColumns = 2;
        list_recycler_view.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        ProductRecycleView productRecycleView = new ProductRecycleView(products, this, new ProductRecycleView.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, final int position) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(AllProductActivity.this,view);

                //inflating menu from xml resource
                popup.inflate(R.menu.optional_menu);

                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.update:


                                break;

                            case R.id.delete:


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
        list_recycler_view.setHasFixedSize(true);

    }

}
