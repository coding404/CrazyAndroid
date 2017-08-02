package com.liushu.crazyandroid.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.OneChioceAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/8/2.
 */

public class OneChioceDialog extends Dialog {
    public OneChioceDialog(Context context) {
        super(context);
    }

    public OneChioceDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private View layout;
        private TextView mTvTitle;
        private TextView mTvDelete;
        private ListView mLvList;

        private String mTitle;
        private List<String> mList;
        private String mContact;

        public String getContact() {
            return mContact;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public void setList(List<String> list) {
            mList = list;
        }

        public Context getContext() {
            return context;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) context
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) context
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public OneChioceDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final OneChioceDialog dialog = new OneChioceDialog(context, R.style.Dialog);
            layout = inflater.inflate(R.layout.dialog_one_chioce, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            // 设置dialog的标题
            //((TextView) layout.findViewById(R.id.grab_title)).setText(title);
            // 设置确定按钮
            if (positiveButtonText != null) {
                ((Button) layout.findViewById(R.id.positiveButton))
                        .setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.positiveButton))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    positiveButtonClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_POSITIVE);
                                }
                            });
                }
            } else {
                layout.findViewById(R.id.positiveButton).setVisibility(
                        View.GONE);
            }
            // 设置取消按钮
            if (negativeButtonText != null) {
                ((Button) layout.findViewById(R.id.negativeButton))
                        .setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.negativeButton))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    negativeButtonClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEGATIVE);
                                }
                            });
                }
            } else {
                layout.findViewById(R.id.negativeButton).setVisibility(View.GONE);
            }
            mTvTitle = (TextView) layout.findViewById(R.id.tv_title);
            mTvDelete = (TextView) layout.findViewById(R.id.tv_delete);
            mTvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            mLvList = (ListView) layout.findViewById(R.id.lv_list);
            final List<Boolean> mSelects = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                mSelects.add(false);
            }

            final OneChioceAdapter adapter = new OneChioceAdapter(mList, mSelects);
            mLvList.setAdapter(adapter);
            mLvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mSelects.clear();
                    for (int i = 0; i < mList.size(); i++) {
                        mSelects.add(false);
                    }
                    mSelects.set(position, true);
                    mContact = mList.get(position);
                    adapter.notifyDataSetChanged();

                }
            });

            dialog.setContentView(layout);
            return dialog;
        }
    }
}
