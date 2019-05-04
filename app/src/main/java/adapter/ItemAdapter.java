package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.ushan_mini_third.DescriptionActivity;
import com.example.ushan_mini_third.R;

import java.util.ArrayList;
import java.util.List;
import model.Item;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    Context mContext;
    List<Item> itemList;


    public ItemAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgItem;
        TextView tvName, tvPrice;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvName = itemView.findViewById(R.id.itemName);
            tvPrice = itemView.findViewById(R.id.itemPrice);

        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        final Item item = itemList.get(i);

        itemViewHolder.imgItem.setImageResource(item.getItemImageName());
        itemViewHolder.tvName.setText(item.getItemName());
        itemViewHolder.tvPrice.setText(Integer.toString(item.getItemPrice()));

        itemViewHolder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent descriptionIntent = new Intent(mContext, DescriptionActivity.class);
                descriptionIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                descriptionIntent.putExtra("name", item.getItemName());
                descriptionIntent.putExtra("price", item.getItemPrice());
                descriptionIntent.putExtra("description", item.getItemDescription());
                descriptionIntent.putExtra("image", item.getItemImageName());

                mContext.startActivity(descriptionIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }




}
