package com.hensen.easyutils.junjunjun1.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hensen.easyutils.R;

import java.util.List;

public class StringAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public StringAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
    }
}
