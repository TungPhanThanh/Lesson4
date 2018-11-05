package android.tungpt.lesson4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<String> mImages;

    public ImageAdapter(ArrayList<String> modelImages) {
        mImages = modelImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.model_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mImages.get(i));
    }

    @Override
    public int getItemCount() {
        return mImages != null ? mImages.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        public void bindData(String string) {
            Glide.with(itemView.getContext())
                    .load(string)
                    .into(mImageView);
        }
    }
}
