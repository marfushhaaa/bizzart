package prosperity.best.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import prosperity.best.game.R;

public class ViewerPageAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mPictureIDs;

    public ViewerPageAdapter(Context context, int[] resids) {
        this.mContext = context;

        this.mPictureIDs = resids;
    }

    @Override
    public int getCount() {
        return mPictureIDs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView avatarImageView;

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.pager, container,
                false);

        avatarImageView = itemView.findViewById(R.id.imageView);
        avatarImageView.setImageResource(mPictureIDs[position]);

        container.addView(itemView);

        return itemView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
