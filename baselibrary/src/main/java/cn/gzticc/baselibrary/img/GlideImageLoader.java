package cn.gzticc.baselibrary.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import cn.gzticc.baselibrary.R;
import cn.gzticc.baselibrary.utils.NetworkUitls;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author pin
 * @Description:
 * @date 2017/12/20 14:30
 */

public class GlideImageLoader {
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    public static void setSrc(ImageView view, @DrawableRes int resId) {
        view.setImageResource(resId);
    }

    public static void setSrc(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)//占位图
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public static void setCircleSrc(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
//                .bitmapTransform(new GlideCircleTransform(imageView.getContext()))
//                .bitmapTransform(
//                        new CropCircleTransformation(imageView.getContext()),
//                        new GrayscaleTransformation(imageView.getContext()))//灰色的圆
//                .bitmapTransform(
//                        new RoundedCornersTransformation(imageView.getContext(),20,0))//圆角
//                .bitmapTransform(
//                        new BlurTransformation(imageView.getContext())//模糊效果
//                )
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .placeholder(R.mipmap.ic_launcher)//占位图
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public static void setCircleAngleSrc(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
//                .bitmapTransform(new GlideRoundTransform(imageView.getContext(), 50))
                .bitmapTransform(new RoundedCornersTransformation(imageView.getContext(),50,0))
                .placeholder(R.mipmap.ic_launcher)//占位图
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public static void loadImge(ImageView imageView, String url) {
//        Glide.with(imageView.getContext())
//                .load(url)
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(imageView);
//
//        Glide.with(imageView.getContext()).load(url)
//                .into(imageView);

        if (NetworkUitls.isWifiConnected(imageView.getContext())) {
            loadNormal(imageView, url, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        } else {
            loadCache(imageView, url, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        }
    }

    public static void loadImge(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        if (NetworkUitls.isWifiConnected(imageView.getContext())) {
            loadNormal(imageView, url, holderDrawable, errorDrawable);
        } else {
            loadCache(imageView, url, holderDrawable, errorDrawable);
        }
    }

    private static void loadNormal(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .animate(R.anim.fade_in)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    private static void loadCache(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .using(new StreamModelLoader<String>() {
                    @Override
                    public DataFetcher<InputStream> getResourceFetcher(final String model, int i, int i1) {
                        return new DataFetcher<InputStream>() {
                            @Override
                            public InputStream loadData(Priority priority) throws Exception {
                                throw new IOException();
                            }

                            @Override
                            public void cleanup() {

                            }

                            @Override
                            public String getId() {
                                return model;
                            }

                            @Override
                            public void cancel() {

                            }
                        };
                    }
                })
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .animate(R.anim.fade_in)
                .into(imageView);
    }

    private static void loadNormal(ImageView imageView, String url, @DrawableRes int holderDrawable, @DrawableRes int errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .animate(R.anim.fade_in)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    private static void loadCache(ImageView imageView, String url, @DrawableRes int holderDrawable, @DrawableRes int errorDrawable) {
        Glide.with(imageView.getContext())
                .using(new StreamModelLoader<String>() {
                    @Override
                    public DataFetcher<InputStream> getResourceFetcher(final String model, int i, int i1) {
                        return new DataFetcher<InputStream>() {
                            @Override
                            public InputStream loadData(Priority priority) throws Exception {
                                throw new IOException();
                            }

                            @Override
                            public void cleanup() {

                            }

                            @Override
                            public String getId() {
                                return model;
                            }

                            @Override
                            public void cancel() {

                            }
                        };
                    }
                })
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .animate(R.anim.fade_in)
                .into(imageView);
    }


    // 清除Glide内存缓存
    public static boolean clearCacheMemory(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 清除Glide磁盘缓存
    public static boolean clearDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在子主线程执行
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
            }else{
                Glide.get(context).clearDiskCache();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 清除图片所有缓存
     */
    public static boolean clearImageAllCache(Context context) {
        try {
            clearCacheMemory(context);
            clearDiskCache(context);
            String ImageExternalCatchDir = context.getExternalCacheDir() + ExternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
//            deleteFolderFile(ImageExternalCatchDir, true);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除指定目录下的文件，这里用于缓存的删除
     *
     * @param filePath filePath
     * @param deleteThisPath deleteThisPath
     */
    private static void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if(!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    File files[] = file.listFiles();
                    for (File file1 : files) {
                        deleteFolderFile(file1.getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else {
                        if (file.listFiles().length == 0) {
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
