package com.example.assingment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assingment.R;
import com.example.assingment.dialog.ZoomImageDialog;
import com.example.assingment.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductRecycleView extends RecyclerView.Adapter<ProductRecycleView.ViewHolder> {

    private List<Product> products;
    private Context mContext;
    private RecyclerViewClickListener mListener;

    public interface RecyclerViewClickListener {

        void onClick(View view, int position,Product product);

    }

    public ProductRecycleView(List<Product> products, Context mContext, RecyclerViewClickListener mListener) {
        this.mContext = mContext;
        this.products = products;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

             // set product data into view
             holder.txt_pname.setText(products.get(position).getName() + " Id: " +products.get(position).getId());
             holder.productImage.setImageResource(products.get(position).getProductPhoto());
             holder.txt_rate.setText("Sale Price: "+products.get(position).getSalePrice().toString());
             holder.txt_discription.setText(products.get(position).getDescription());
             holder.txt_reg_rate.setText("Regular Price :" +products.get(position).getRegularPrice().toString());

        // menu button clicked
        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.onClick(view,position,products.get(position));

            }
        }); // button closed


        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm =((FragmentActivity)mContext).getSupportFragmentManager();
                ZoomImageDialog zoomImageDialog= ZoomImageDialog.newInstance(products.get(position).getProductPhoto());
                zoomImageDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                zoomImageDialog.show(fm,"ZoomImageDialog");
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView productImage;
        private TextView txt_pname, txt_discription;
        private TextView txt_rate,txt_reg_rate;
        private TextView buttonViewOption;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.img_product);
            txt_pname = itemView.findViewById(R.id.txt_pname);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            txt_discription = itemView.findViewById(R.id.txt_discription);
            txt_reg_rate = itemView.findViewById(R.id.txt_reg_rate);
            buttonViewOption =  itemView.findViewById(R.id.textViewOptions);

        }

        @Override
        public void onClick(View view) {

            mListener.onClick(view,getAdapterPosition(),null);
        }


    }


    // add item
    public void addItems(List<Product> productItems) {

        if(products == null){

            products = new ArrayList<>();
        }

        products = productItems;

        notifyDataSetChanged();
    }


    // add productImage
    private void addProductImage(Product product,int position, ImageView imageView){

    }

}
