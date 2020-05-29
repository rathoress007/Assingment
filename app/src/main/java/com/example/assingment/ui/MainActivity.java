package com.example.assingment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.assingment.R;
import com.example.assingment.dbconnection.CreateProduct;
import com.example.assingment.dbconnection.GetProducts;
import com.example.assingment.model.Product;

import org.parceler.Parcels;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Integer[] images = {R.drawable.img_one, R.drawable.img_two, R.drawable.img_three, R.drawable.img_four, R.drawable.img_four};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id's
        Button btn_show = findViewById(R.id.btn_show);
        Button btn_create = findViewById(R.id.btn_create);


        // show product button clicked
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(MainActivity.this,AllProductActivity.class);
                   startActivity(intent);
            }
        }); // button closed


        // create  product button clicked
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int size = 0;

                GetProducts products = new GetProducts(MainActivity.this);
                try {

                    List<Product>  productList = products.execute().get();
                    size = productList.size();

                }catch (Exception e){
                    e.printStackTrace();
                }

                //creating a task
                Product product = new Product();
                product.setName("Product  "+(size+1));
                product.setRegularPrice(size+150.0);
                product.setSalePrice(size+100.0);
                product.setProductPhoto(images[0]);
                product.setDescription("Product Description");

                CreateProduct createProduct = new CreateProduct(MainActivity.this,product);
                createProduct.execute();
            }
        });// button closed

    }


}
