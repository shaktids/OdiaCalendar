package ennovic.example.dasshak.odiacalendar;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dasshak.odiacalendar.R;

/**
 * Created by dasshak on 3/11/2018.
 */

public class ImageAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImageIds=new int[]{R.drawable.jan,R.drawable.feb,R.drawable.mar, R.drawable.apr,R.drawable.may,R.drawable.jun,R.drawable.july,R.drawable.aug,R.drawable.sept,R.drawable.oct,R.drawable.nov,R.drawable.dec};
    ImageAdapter(Context context){
        mContext=context;
    }
    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView,0);
        return imageView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
