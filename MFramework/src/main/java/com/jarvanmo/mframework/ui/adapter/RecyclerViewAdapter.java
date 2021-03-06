package com.jarvanmo.mframework.ui.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jarvanmo.mframework.ui.viewholder.BaseViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * My goal is to make creating adapter  easier.
 * So,this adapter is based on {@link android.databinding.DataBindingUtil} and reflection.
 * I never test performance of this adapter
 * if you really concern about performance, you'd better not use this adapter.
 */
public abstract class RecyclerViewAdapter<VDB extends ViewDataBinding, I, VH extends BaseViewHolder<VDB>> extends RecyclerView.Adapter<VH> {


    Constructor<VH> constructor = null;
    private List<I> data;
    private Context mContext;

    @SuppressWarnings("unchecked")
    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();

//        Class<VH> clazz = getViewHolderType();
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<VH> clazz = (Class) params[2];
        try {
            constructor = clazz.getDeclaredConstructor(View.class);
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    public I getItem(int position) {
        if (position < data.size()) {
            return data.get(position);
        } else {
            return null;
        }
    }

    public Context getContext() {
        return mContext;
    }

    public List<I> getData() {
        return data;
    }

    /**
     * reset the data used by adapter
     */
    public void setData(List<I> newData) {
        data.clear();
        addAll(newData);
    }

    /**
     * @return return the last one of  data
     * if the size of data is 0 or data is null
     * it will return null
     **/
    public I getLastItem() {

        I result = null;
        if (data != null) {
            int size = data.size();

            if (size > 0) {
                result = data.get(size - 1);
            }
        }

        return result;

    }

    /**
     * add an item to data
     * this will change part of RecyclerView
     *
     * @param item a piece of data
     */
    public void add(I item) {
        add(item, false);
    }

    /**
     * add a piece of data to the adapter
     *
     * @param item        a piece of data
     * @param isNotifyAll call {@link #notifyDataSetChanged()} or {@link #notifyItemChanged(int)} <br/>
     *                    to refresh adapter
     */
    public void add(I item, boolean isNotifyAll) {
        if (data != null) {

            data.add(item);

            if (isNotifyAll) {
                notifyDataSetChanged();
            } else {
                notifyItemInserted(data.size() - 1);
            }

        }
    }


    /**
     * add more add to adapter
     *
     * @param moreData the data need to show together
     */
    public void addAll(List<I> moreData) {

        if (data != null) {
            data.addAll(moreData);
            notifyDataSetChanged();
        }
    }

    /**
     * add a item to the data at index
     * this will change part of RecyclerView
     **/
    public void insert(int position, I item) {

        insert(position, item, false);

    }


    /**
     * insert an item into the data at a particular position
     *
     * @param position    the position
     * @param item        a piece of data
     * @param isNotifyAll call {@link #notifyDataSetChanged()} or {@link #notifyItemChanged(int)} <br/>
     *                    to refresh adapter
     **/
    public void insert(int position, I item, boolean isNotifyAll) {

        if (data != null) {
            data.add(position, item);
            if (isNotifyAll) {
                notifyDataSetChanged();
            } else {
                notifyItemInserted(position);
            }
        }

    }


    /**
     * add a item to the data at the first position
     **/
    public void addToFirst(I item) {
        addToFirst(item, false);
    }

    /**
     * add a item to the data at the first position
     **/
    public void addToFirst(I item, boolean isNotifyAll) {
        insert(0, item);
    }


    public void set(int position, I item) {
        set(position, item, false);
    }

    public void set(int position, I item, boolean isNotifyAll) {

        if (data != null) {
            data.set(position, item);

            if (isNotifyAll) {
                notifyDataSetChanged();
            } else {
                notifyItemChanged(position);
            }
        }
    }


    public void removeItem(int position) {

        int size = data.size();
        if (position < size) {
            data.remove(position);
            notifyDataSetChanged();
        } else {
            throw new IndexOutOfBoundsException("Invalid index " + position + ", size is " + size);
        }
    }

    public void removeItem(int position, boolean isNotifyAll) {

        int size = data.size();
        if (position < size) {
            data.remove(position);
            if (isNotifyAll) {
                notifyDataSetChanged();
            } else {
                notifyItemRemoved(position);
            }

        } else {
            throw new IndexOutOfBoundsException("Invalid index " + position + ", size is " + size);
        }
    }

    public void removeItem(I item) {

        removeItem(item, false);
    }

    public void removeItem(I item, boolean isNotifyAll) {

        if (data.contains(item)) {
            removeItem(data.indexOf(item), isNotifyAll);
        }
    }

    public void clear() {

        if (data != null) {
            data.clear();
            notifyDataSetChanged();
        }

    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressWarnings("unchecked")
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH vh = null;

        VDB binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), getLayoutId(), parent, false);

        try {
            vh = constructor.newInstance(binding.getRoot());
            constructor.setAccessible(false);
            vh.setBinding(binding);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return vh;

    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(VH holder, int position) {


        VDB binding = holder.getBinding();
        I item = getItem(position);
//        try {
//            Method method = binding.getClass().getMethod("set" + item.getClass().getSimpleName(), item.getClass());
//            method.invoke(binding, item);
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//        }


        onControlView(item, binding, position);
    }

    /***
     * @param item     data
     * @param binding  your binding object
     * @param position current item position
     *                 In this method you must bing your data with binding
     */
    public abstract void onControlView(I item, VDB binding, int position);


    public
    @LayoutRes
    abstract int getLayoutId();


}
