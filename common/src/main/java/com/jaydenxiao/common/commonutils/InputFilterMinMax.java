package com.jaydenxiao.common.commonutils;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

/**
 * Created by liushu on 2017/9/21.
 * 数字输入限定工具类，用来限定输入的最大值，保留小数位数
 */

public class InputFilterMinMax implements InputFilter {
    private int decimal_digits;
    private double min, max;

    public InputFilterMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max, int decimal_digits) {
        this.min = Double.parseDouble(min);
        this.max = Double.parseDouble(max);
        this.decimal_digits = decimal_digits;
    }

    /**
     * @param source 新输入的字符串
     * @param start  新输入的字符串起始下标，一般为0
     * @param end    新输入的字符串终点下标，一般为source长度-1
     * @param dest   输入之前文本框内容
     * @param dstart 原内容起始坐标，一般为0
     * @param dend   原内容终点坐标，一般为dest长度-1
     * @return 输入内容
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String dValue = dest.toString();
        String[] splitArray = dValue.split("\\.");
        Log.e("666source", source.toString());
        Log.e("666dest", dest.toString());
        Log.e("666", "start:" + start);
        Log.e("666", "end:" + end);
        Log.e("666", "dstart:" + dstart);
        Log.e("666", "dend:" + dend);


        if ("".equals(source.toString())) {
            return null;
        }
        try {
            //消除多个0输入
            if ("0".equals(dValue)) {
                if ("0".equals(source.toString())) {
                    return "";
                } else if (!".".equals(source.toString()) && dstart != 0) {
                    return "";
                }
            }
            if (splitArray.length > 1) {
                String dotValue = splitArray[1];
                int diff = dotValue.length() + 1 - decimal_digits;
                if (diff > 0) {
                    if ((dend > dest.toString().length() - decimal_digits - 1)) {
                        return source.subSequence(start, end - diff);
                    }
                }
            }
            double input = Double.parseDouble(dest.toString().replace(",", "") + source.toString().replace(",", ""));
            if (dstart > 0 && dstart < dest.length()) {
                //当有千分符动态格式化时用该注释内容
               /* String s1 = dest.toString().substring(0, dstart - 1).replace(",", "");
                String s2 = dest.toString().substring(dstart - 1, dest.length()).replace(",", "");*/
                String s1 = dest.toString().substring(0, dstart - 1);
                String s2 = dest.toString().substring(dstart - 1, dest.length());
                input = Double.parseDouble(s1 + source + s2);
            }
            if (isInRange(min, max, input)) {
                return null;
            } else {
                return "";
            }
        } catch (NumberFormatException nfe) {
        }

        // 删除等特殊字符，直接返回
        return "";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}