/***********************************************************************************
 * The MIT License (MIT)

 * Copyright (c) 2014 Robin Chutaux

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ***********************************************************************************/
package com.andexert.calendarlistview.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;

import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

class SimpleMonthView extends View {

    public static final String VIEW_PARAMS_HEIGHT = "height";
    public static final String VIEW_PARAMS_MONTH = "month";
    public static final String VIEW_PARAMS_YEAR = "year";
    public static final String VIEW_PARAMS_SELECTED_BEGIN_DAY = "selected_begin_day";
    public static final String VIEW_PARAMS_SELECTED_LAST_DAY = "selected_last_day";
    public static final String VIEW_PARAMS_SELECTED_BEGIN_MONTH = "selected_begin_month";
    public static final String VIEW_PARAMS_SELECTED_LAST_MONTH = "selected_last_month";
    public static final String VIEW_PARAMS_SELECTED_BEGIN_YEAR = "selected_begin_year";
    public static final String VIEW_PARAMS_SELECTED_LAST_YEAR = "selected_last_year";
    public static final String VIEW_PARAMS_SELECTED_LAST_HOUR = "selected_last_hour";
    public static final String VIEW_PARAMS_SELECTED_BEGIN_HOUR = "selected_begin_hour";
    public static final String VIEW_PARAMS_VISIABLE_BEGIN_HOUR = "visiable_begin_hour";
    public static final String VIEW_PARAMS_VISIABLE_LAST_HOUR = "visiable_last_hour";
    public static final String VIEW_PARAMS_LINE_NUM_VISIABLE = "line_num_visiable";
    public static final String VIEW_PARAMS_WEEK_START = "week_start";

    private static final int SELECTED_CIRCLE_ALPHA = 128;
    protected static int DEFAULT_HEIGHT = 32;
    protected static int DEFAULT_HEIGHT_HOUR = 32;
    protected static final int DEFAULT_NUM_ROWS = 6;
    protected static final int DEFAULT_NUM_ROWS_HOUR = 0;
    protected static int DAY_SELECTED_CIRCLE_SIZE;
    protected static int DAY_SEPARATOR_WIDTH = 1;
    protected static int MINI_DAY_NUMBER_TEXT_SIZE;
    protected static int HOUR_TEXT_CORNER_SIZE;
    protected static int MIN_HEIGHT = 10;
    protected static int MONTH_DAY_LABEL_TEXT_SIZE;
    protected static int MONTH_HEADER_SIZE;
    protected static int MONTH_LABEL_TEXT_SIZE;
    protected int mPadding = 0;
    private String mDayOfWeekTypeface;
    private String mMonthTitleTypeface;

    protected Paint mMonthDayLabelPaint;
    protected Paint mMonthNumPaint;
    protected Paint mMonthTitleBGPaint;
    protected Paint mMonthTitlePaint;
    protected Paint mSelectedCirclePaint;
    protected Paint mMiddlePaint;
    protected Paint mMiddleHourPaint;
    protected Paint mHourBgPaint;
    protected Paint mTodayPointPaint;
    protected Paint mHourLinePaint;
    protected Paint mHourTextPaint;
    protected Paint mHourTextCornerPaint;
    protected int mCurrentDayTextColor;
    protected int mMonthTextColor;
    protected int mDayTextColor;
    protected int mDayNumColor;
    protected int mMonthTitleBGColor;
    protected int mPreviousDayColor;
    protected int mUnSelectedDayColor;
    protected int mSelectedDaysColor;
    protected int mHourCornerTextColor;
    protected int mMiddleDaysColor;
    protected int mMiddleHoursColor;
    protected int mHourBgColor;
    protected int mTodayPointColor;
    protected int mHourLineColor;
    protected int mHourTextSelectedColor;
    protected int mHourUnSelectedColor;

    private final StringBuilder mStringBuilder;

    protected boolean mHasToday = false;
    protected boolean mIsPrev = false;
    protected int mSelectedBeginDay = -1;
    protected int mSelectedLastDay = -1;
    protected int mSelectedBeginMonth = -1;
    protected int mSelectedLastMonth = -1;
    protected int mSelectedBeginYear = -1;
    protected int mSelectedLastYear = -1;
    protected int mToday = -1;

    int hourFirstTime = -1;
    int hourListTime = -1;
    int isFirstHourVisiable = -1;
    int isLastHourVisiable = -1;
    int lineNumHour = -1;
    int lineVisiable = -1;

    protected int mWeekStart = 1;
    protected int mNumDays = 7;
    protected int mNumCells = mNumDays;
    private int mDayOfWeekStart = 0;
    protected int mMonth;
    protected Boolean mDrawRect;
    protected int mRowHeight = DEFAULT_HEIGHT;
    protected int mRowHourHeight = DEFAULT_HEIGHT_HOUR;
    protected int mWidth;
    protected int mYear;
    final Time today;

    private final Calendar mCalendar;
    private final Calendar mDayLabelCalendar;
    private final Boolean isPrevDayEnabled;

    private int mNumRows = DEFAULT_NUM_ROWS;
    private int mNumRowsHour = DEFAULT_NUM_ROWS_HOUR;

    private DateFormatSymbols mDateFormatSymbols = new DateFormatSymbols();

    private OnDayClickListener mOnDayClickListener;
    private Path mPath;

    public SimpleMonthView(Context context, TypedArray typedArray) {
        super(context);

        Resources resources = context.getResources();
        mDayLabelCalendar = Calendar.getInstance();
        mCalendar = Calendar.getInstance();
        today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        mDayOfWeekTypeface = resources.getString(R.string.sans_serif);
        mMonthTitleTypeface = resources.getString(R.string.sans_serif);
        mCurrentDayTextColor = typedArray.getColor(R.styleable.DayPickerView_colorCurrentDay, resources.getColor(R.color.normal_day));
        mMonthTextColor = typedArray.getColor(R.styleable.DayPickerView_colorMonthName, resources.getColor(R.color.normal_day));
        mDayTextColor = typedArray.getColor(R.styleable.DayPickerView_colorDayName, resources.getColor(R.color.normal_day));
        mDayNumColor = typedArray.getColor(R.styleable.DayPickerView_colorNormalDay, resources.getColor(R.color.normal_day));
        mPreviousDayColor = typedArray.getColor(R.styleable.DayPickerView_colorPreviousDay, resources.getColor(R.color.normal_day));
        mUnSelectedDayColor = typedArray.getColor(R.styleable.DayPickerView_colorUnselectedDay, resources.getColor(R.color.unselected_day));
        mSelectedDaysColor = typedArray.getColor(R.styleable.DayPickerView_colorSelectedDayBackground, resources.getColor(R.color.selected_day_background));
        mHourCornerTextColor = typedArray.getColor(R.styleable.DayPickerView_colorCornerText, resources.getColor(R.color.hour_corner_text));
        mMiddleDaysColor = typedArray.getColor(R.styleable.DayPickerView_colorMiddleDayBackground, resources.getColor(R.color.middle_day_background));
        mMiddleHoursColor = typedArray.getColor(R.styleable.DayPickerView_colorMiddleDayBackground, resources.getColor(R.color.middle_day_background));
        mHourBgColor = typedArray.getColor(R.styleable.DayPickerView_colorHourBackground, resources.getColor(R.color.background_hour_bg));
        mTodayPointColor = typedArray.getColor(R.styleable.DayPickerView_colorTodayPoint, resources.getColor(R.color.circle_today_point));
        mHourLineColor = typedArray.getColor(R.styleable.DayPickerView_colorHourLine, resources.getColor(R.color.background_hour_line));
        mHourTextSelectedColor = typedArray.getColor(R.styleable.DayPickerView_colorHourTextSelected, resources.getColor(R.color.selected_hour_text));
        mHourUnSelectedColor = typedArray.getColor(R.styleable.DayPickerView_colorHourTextUnselected, resources.getColor(R.color.unselected_hour_text));
        mMonthTitleBGColor = typedArray.getColor(R.styleable.DayPickerView_colorSelectedDayText, resources.getColor(R.color.selected_day_text));

        mDrawRect = typedArray.getBoolean(R.styleable.DayPickerView_drawRoundRect, false);
        mStringBuilder = new StringBuilder(50);

        MINI_DAY_NUMBER_TEXT_SIZE = typedArray.getDimensionPixelSize(R.styleable.DayPickerView_textSizeDay, resources.getDimensionPixelSize(R.dimen.text_size_day));
        HOUR_TEXT_CORNER_SIZE = typedArray.getDimensionPixelSize(R.styleable.DayPickerView_textSizeHourCorner, resources.getDimensionPixelSize(R.dimen.text_size_hour_corner));
        MONTH_LABEL_TEXT_SIZE = typedArray.getDimensionPixelSize(R.styleable.DayPickerView_textSizeMonth, resources.getDimensionPixelSize(R.dimen.text_size_month));
        MONTH_DAY_LABEL_TEXT_SIZE = typedArray.getDimensionPixelSize(R.styleable.DayPickerView_textSizeDayName, resources.getDimensionPixelSize(R.dimen.text_size_day_name));
        MONTH_HEADER_SIZE = typedArray.getDimensionPixelOffset(R.styleable.DayPickerView_headerMonthHeight, resources.getDimensionPixelOffset(R.dimen.header_month_height));
        DAY_SELECTED_CIRCLE_SIZE = typedArray.getDimensionPixelSize(R.styleable.DayPickerView_selectedDayRadius, resources.getDimensionPixelOffset(R.dimen.selected_day_radius));
        mRowHeight = ((typedArray.getDimensionPixelSize(R.styleable.DayPickerView_calendarHeight, resources.getDimensionPixelOffset(R.dimen.calendar_height)) - MONTH_HEADER_SIZE) / 6);
        mRowHourHeight = ((typedArray.getDimensionPixelSize(R.styleable.DayPickerView_calendarHeightHour, resources.getDimensionPixelOffset(R.dimen.calendar_hour_height))) / 4);
        isPrevDayEnabled = typedArray.getBoolean(R.styleable.DayPickerView_enablePreviousDay, true);
        initView();
    }

    private int calculateNumRows() {
        int offset = findDayOffset();
        int dividend = (offset + mNumCells) / mNumDays;
        int remainder = (offset + mNumCells) % mNumDays;
        return (dividend + (remainder > 0 ? 1 : 0));
    }

    private void drawMonthDayLabels(Canvas canvas) {
        int y = MONTH_HEADER_SIZE - (MONTH_DAY_LABEL_TEXT_SIZE / 2);
        int dayWidthHalf = (mWidth - mPadding * 2) / (mNumDays * 2);

        for (int i = 0; i < mNumDays; i++) {
            int calendarDay = (i + mWeekStart) % mNumDays;
            int x = (2 * i + 1) * dayWidthHalf + mPadding;
            mDayLabelCalendar.set(Calendar.DAY_OF_WEEK, calendarDay);
            canvas.drawText(mDateFormatSymbols.getShortWeekdays()[mDayLabelCalendar.get(Calendar.DAY_OF_WEEK)].toUpperCase(Locale.getDefault()), x, y, mMonthDayLabelPaint);
        }
    }

    private void drawMonthTitle(Canvas canvas) {
        int x = (mWidth + 2 * mPadding) / 2;
        int y = (MONTH_HEADER_SIZE - MONTH_DAY_LABEL_TEXT_SIZE) / 2 + (MONTH_LABEL_TEXT_SIZE / 2);
        StringBuilder stringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), x, y, mMonthTitlePaint);
    }

    private int findDayOffset() {
        return (mDayOfWeekStart < mWeekStart ? (mDayOfWeekStart + mNumDays) : mDayOfWeekStart)
                - mWeekStart;
    }

    private String getMonthAndYearString() {
        int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_NO_MONTH_DAY;
        mStringBuilder.setLength(0);
        long millis = mCalendar.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), millis, millis, flags);
    }

    private void onHourClick(String string, int position) {
        mOnDayClickListener.onHourClick(string, position);
    }

    private void onDayClick(SimpleMonthAdapter.CalendarDay calendarDay) {
        if (mOnDayClickListener != null && (isPrevDayEnabled || !((calendarDay.month == today.month) && (calendarDay.year == today.year) && calendarDay.day < today.monthDay))) {
            mOnDayClickListener.onDayClick(this, calendarDay);
        }
    }

    private boolean sameDay(int monthDay, Time time) {
        return (mYear == time.year) && (mMonth == time.month) && (monthDay == time.monthDay);
    }

    private boolean prevDay(int monthDay, Time time) {
        return ((mYear < time.year)) || (mYear == time.year && mMonth < time.month) || (mMonth == time.month && monthDay < time.monthDay);
    }

    private int selectedPositionFirst = 0;
    private int selectedPositionLast = 0;


    protected void drawMonthNums(Canvas canvas) {
        int y = (mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2 - DAY_SEPARATOR_WIDTH + MONTH_HEADER_SIZE;
        int paddingDay = (mWidth - 2 * mPadding) / (2 * mNumDays);
        int dayOffset = findDayOffset();
        int day = 1;
        Boolean isRowFirst = false;
        Boolean isRowLast = false;

        while (day <= mNumCells) {
            int x = paddingDay * (1 + dayOffset * 2) + mPadding;


            if ((mMonth == mSelectedBeginMonth && mSelectedBeginDay == day && mSelectedBeginYear == mYear)) {
                RectF rectF2;
                if (mSelectedLastYear > 0) {
                    if ((mSelectedBeginYear < mSelectedLastYear) || (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth < mSelectedLastMonth) ||
                            (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay < mSelectedLastDay)) {
                        if (dayOffset == 6) {
                            rectF2 = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                    x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                            canvas.drawRoundRect(rectF2, 0.0f, 0.0f, mMiddlePaint);
                        } else {
                            rectF2 = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                    x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                            canvas.drawRoundRect(rectF2, 0.0f, 0.0f, mMiddlePaint);
                        }
                        mSelectedCirclePaint.setColor(Color.WHITE);
                        canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                        mSelectedCirclePaint.setColor(mSelectedDaysColor);
                        canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                    }
                    /*else if ((mSelectedBeginYear > mSelectedLastYear) || (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth > mSelectedLastMonth) ||
                            (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay > mSelectedLastDay)) {
                        if (dayOffset == 0) {
                            rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                    x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                        } else {
                            rectF2 = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                    x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                        }

                        canvas.drawRoundRect(rectF2, 0.0f, 0.0f, mMiddlePaint);
                    }*/
                } else {

                    mSelectedCirclePaint.setColor(Color.WHITE);
                    canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                    mSelectedCirclePaint.setColor(mSelectedDaysColor);
                    canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                }

                selectedPositionFirst = y;
                isRowFirst = true;
            }
            if ((mMonth == mSelectedLastMonth && mSelectedLastDay == day && mSelectedLastYear == mYear)) {

                RectF rectF2;
                if ((mSelectedBeginYear < mSelectedLastYear) || (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth < mSelectedLastMonth) ||
                        (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay < mSelectedLastDay)) {
                    if (dayOffset == 0) {
                        rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    } else {
                        rectF2 = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    }
                    canvas.drawRoundRect(rectF2, 0.0f, 0.0f, mMiddlePaint);
                } /*else if ((mSelectedBeginYear > mSelectedLastYear) || (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth > mSelectedLastMonth) ||
                        (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay > mSelectedLastDay)) {
                    if (dayOffset == 6) {
                        rectF2 = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    } else {
                        rectF2 = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                                x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    }

                    canvas.drawRoundRect(rectF2, 0.0f, 0.0f, mMiddlePaint);
                }*/
                mSelectedCirclePaint.setColor(Color.WHITE);
                canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                mSelectedCirclePaint.setColor(mSelectedDaysColor);
                canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3, DAY_SELECTED_CIRCLE_SIZE, mSelectedCirclePaint);
                selectedPositionLast = y;
                isRowLast = true;
            }

            if (mHasToday && (mToday == day)) {
                mMonthNumPaint.setColor(mCurrentDayTextColor);
                mMonthNumPaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                canvas.drawCircle(x, y - MINI_DAY_NUMBER_TEXT_SIZE / 3 + DAY_SELECTED_CIRCLE_SIZE - 8, 8, mTodayPointPaint);
            } else {
                mMonthNumPaint.setColor(mDayNumColor);
                mMonthNumPaint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }

            if ((mMonth == mSelectedLastMonth && mSelectedLastDay == day && mSelectedLastYear == mYear)) {
                mMonthNumPaint.setColor(mMonthTitleBGColor);
            }
            if ((mMonth == mSelectedBeginMonth && mSelectedBeginDay == day && mSelectedBeginYear == mYear) &&
                    (mSelectedLastYear == -1 || (mSelectedLastYear > mSelectedBeginYear || (mSelectedLastYear == mSelectedBeginYear && mSelectedLastMonth > mSelectedBeginMonth) ||
                            (mSelectedLastYear == mSelectedBeginYear && mSelectedLastMonth == mSelectedBeginMonth && mSelectedLastDay > mSelectedBeginDay)))) {
                mMonthNumPaint.setColor(mMonthTitleBGColor);
            }

            if ((mSelectedBeginDay != -1 && mSelectedLastDay != -1 && mSelectedBeginYear == mSelectedLastYear &&
                    mSelectedBeginMonth == mSelectedLastMonth &&
                    mSelectedBeginDay == mSelectedLastDay &&
                    day == mSelectedBeginDay &&
                    mMonth == mSelectedBeginMonth &&
                    mYear == mSelectedBeginYear)) {
                mMonthNumPaint.setColor(Color.GRAY);
            }


            if ((mSelectedBeginDay != -1 && mSelectedLastDay != -1 && mSelectedBeginYear == mSelectedLastYear && mSelectedBeginYear == mYear) &&
                    (((mMonth == mSelectedBeginMonth && mSelectedLastMonth == mSelectedBeginMonth) &&
                            ((mSelectedBeginDay < mSelectedLastDay && day > mSelectedBeginDay && day < mSelectedLastDay))) ||
                            ((mSelectedBeginMonth < mSelectedLastMonth && mMonth == mSelectedBeginMonth && day > mSelectedBeginDay) || (mSelectedBeginMonth < mSelectedLastMonth && mMonth == mSelectedLastMonth && day < mSelectedLastDay)))) {
                // mMonthNumPaint.setColor(mSelectedDaysColor);
                mMonthNumPaint.setColor(Color.GRAY);
                // mMonthNumPaint.setColor(mSelectedDaysColor);

                if (dayOffset == 6) {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, -90, 180, true, mMiddlePaint);

                } else if (dayOffset == 0) {
                    RectF rectF = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, 90, 180, true, mMiddlePaint);

                } else {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                }
            }

            if ((mSelectedBeginDay != -1 && mSelectedLastDay != -1 && mSelectedBeginYear != mSelectedLastYear && ((mSelectedBeginYear == mYear && mMonth == mSelectedBeginMonth) || (mSelectedLastYear == mYear && mMonth == mSelectedLastMonth)) &&
                    (((mSelectedBeginMonth < mSelectedLastMonth && mMonth == mSelectedBeginMonth && day < mSelectedBeginDay) || (mSelectedBeginMonth < mSelectedLastMonth && mMonth == mSelectedLastMonth && day > mSelectedLastDay))))) {
                // mMonthNumPaint.setColor(mSelectedDaysColor);
                mMonthNumPaint.setColor(Color.GRAY);
                // mMonthNumPaint.setColor(mSelectedDaysColor);

                if (dayOffset == 6) {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, -90, 180, true, mMiddlePaint);

                } else if (dayOffset == 0) {
                    RectF rectF = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, 90, 180, true, mMiddlePaint);

                } else {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                }
            }

            if ((mSelectedBeginDay != -1 && mSelectedLastDay != -1 && mSelectedBeginYear == mSelectedLastYear && mYear == mSelectedBeginYear) &&
                    ((mMonth > mSelectedBeginMonth && mMonth < mSelectedLastMonth && mSelectedBeginMonth < mSelectedLastMonth))) {
                mMonthNumPaint.setColor(Color.GRAY);
                if (dayOffset == 6) {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, -90, 180, true, mMiddlePaint);

                } else if (dayOffset == 0) {
                    RectF rectF = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, 90, 180, true, mMiddlePaint);

                } else {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                }
            }

            if ((mSelectedBeginDay != -1 && mSelectedLastDay != -1 && mSelectedBeginYear != mSelectedLastYear) &&
                    ((mSelectedBeginYear < mSelectedLastYear && ((mMonth > mSelectedBeginMonth && mYear == mSelectedBeginYear) || (mMonth < mSelectedLastMonth && mYear == mSelectedLastYear))))) {
                // mMonthNumPaint.setColor(mSelectedDaysColor);
                mMonthNumPaint.setColor(Color.GRAY);
                if (dayOffset == 6) {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, -90, 180, false, mMiddlePaint);

                } else if (dayOffset == 0) {
                    RectF rectF = new RectF(x, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                    RectF rectF2 = new RectF(x - DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + DAY_SELECTED_CIRCLE_SIZE, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawArc(rectF2, 90, 180, false, mMiddlePaint);

                } else {
                    RectF rectF = new RectF(x - paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                            x + paddingDay, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) + DAY_SELECTED_CIRCLE_SIZE);
                    canvas.drawRoundRect(rectF, 0.0f, 0.0f, mMiddlePaint);
                }
            }

            if (!isPrevDayEnabled && prevDay(day, today) && today.month == mMonth && today.year == mYear) {
                mMonthNumPaint.setColor(mPreviousDayColor);
                mMonthNumPaint.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }

            if (mYear == today.year && mMonth == today.month && today.monthDay > day) {
                mMonthNumPaint.setColor(mUnSelectedDayColor);
            }

            canvas.drawText(String.format("%d", day), x, y, mMonthNumPaint);
            if (((mMonth == mSelectedBeginMonth && mSelectedBeginDay == day && mSelectedBeginYear == mYear)) && mSelectedLastYear != -1 && (mSelectedBeginYear > mSelectedLastYear || (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth > mSelectedLastMonth) ||
                    (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay > mSelectedLastDay))) {
                mHourTextCornerPaint.setColor(Color.rgb(24, 25, 20));
                canvas.drawText("最早", x, y - MINI_DAY_NUMBER_TEXT_SIZE / 4 + DAY_SELECTED_CIRCLE_SIZE, mHourTextCornerPaint);
                mHourTextCornerPaint.setColor(mHourCornerTextColor);
            }

            dayOffset++;
            if (dayOffset == mNumDays) {
                if (selectedPositionFirst == y && isRowFirst && isFirstHourVisiable == 1) {
                    isRowFirst = false;
                    dayOffset = 0;
                    y += (mRowHeight + mRowHourHeight * 4);
                } else if (selectedPositionLast == y && isRowLast && isLastHourVisiable == 1) {
                    isRowLast = false;
                    dayOffset = 0;
                    y += (mRowHeight + mRowHourHeight * 4);
                } else {
                    dayOffset = 0;
                    y += mRowHeight;
                }
            }
            day++;
        }
    }

    private String[] mStrings = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
            "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};

    private void drawHourNums(Canvas canvas) {
        if (lineVisiable == -1) {
            return;
        }
        if (isFirstHourVisiable == 1) {
            int i1 = (findDayOffset() + mSelectedBeginDay) / 7;
            if ((findDayOffset() + mSelectedBeginDay) % 7 == 0) {
                lineNumHour = i1;
            } else {
                lineNumHour = i1 + 1;
            }
        } else {
            int i1 = (findDayOffset() + mSelectedLastDay) / 7;
            if ((findDayOffset() + mSelectedLastDay) % 7 == 0) {
                lineNumHour = i1;
            } else {
                lineNumHour = i1 + 1;
            }
        }
        int y = (mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2 - DAY_SEPARATOR_WIDTH + MONTH_HEADER_SIZE + lineNumHour * mRowHeight;
        int paddingDay = (mWidth - 2 * mPadding) / (2 * 6);
        int dayOffset = 0;
        int day = 1;
        int lineNum;
        int rowNum;

        RectF rectF = new RectF(0, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE,
                mWidth, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * mNumRowsHour);
        canvas.drawRoundRect(rectF, 0.0f, 0.0f, mHourBgPaint);

        if (isLastHourVisiable == 1 && hourListTime != -1 && mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay == mSelectedLastDay) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if (hourFirstTime < i + j * 6 && hourListTime > i + j * 6) {
                        RectF rectF01 = new RectF(i * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * j,
                                (i + 1) * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (j + 1));
                        canvas.drawRoundRect(rectF01, 0.0f, 0.0f, mMiddleHourPaint);
                    }
                }
            }
        }
        mPath = new Path();
        for (int i = 0; i < 5; i++) {
            mPath.moveTo(0, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + i * mRowHourHeight);
            mPath.lineTo(mWidth, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + i * mRowHourHeight);
        }
        for (int i = 0; i < 7; i++) {
            mPath.moveTo(i * mWidth / 6, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE);
            mPath.lineTo(i * mWidth / 6, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * mNumRowsHour);
        }
        mPath.close();
        canvas.drawPath(mPath, mHourLinePaint);

        if (isFirstHourVisiable == 1 && hourFirstTime != -1) {
            lineNum = (hourFirstTime) / 6;
            rowNum = (hourFirstTime) % 6;
            RectF rectF01 = new RectF(rowNum * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * lineNum,
                    (rowNum + 1) * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum + 1));
            drawSelectHourBackGround(canvas, rectF01);
            canvas.drawText("最早", (2 * rowNum + 1) * (mWidth / 6) / 2, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum + 1) - 10, mHourTextCornerPaint);
        } else if (isLastHourVisiable == 1 && hourListTime != -1) {
            lineNum = (hourListTime) / 6;
            rowNum = (hourListTime) % 6;
            RectF rectF01 = new RectF(rowNum * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * lineNum,
                    (rowNum + 1) * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum + 1));
            drawSelectHourBackGround(canvas, rectF01);
            canvas.drawText("最晚", (2 * rowNum + 1) * (mWidth / 6) / 2, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum + 1) - 10, mHourTextCornerPaint);
            if (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay == mSelectedLastDay) {
                int lineNum2 = (hourFirstTime) / 6;
                int rowNum2 = (hourFirstTime) % 6;
                RectF rectF02 = new RectF(rowNum2 * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * lineNum2,
                        (rowNum2 + 1) * (mWidth / 6), (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum2 + 1));
                drawSelectHourBackGround(canvas, rectF02);
                canvas.drawText("最早", (2 * rowNum2 + 1) * (mWidth / 6) / 2, (y - MINI_DAY_NUMBER_TEXT_SIZE / 3) - DAY_SELECTED_CIRCLE_SIZE + mRowHourHeight * (lineNum2 + 1) - 10, mHourTextCornerPaint);
            }
        }

        while (day <= 24) {
            int x = paddingDay * (1 + dayOffset * 2) + mPadding;
            if (isFirstHourVisiable == 1 && day == hourFirstTime + 1) {
                mHourTextPaint.setColor(mHourTextSelectedColor);
            } else if (isLastHourVisiable == 1 && day == hourListTime + 1) {
                mHourTextPaint.setColor(mHourTextSelectedColor);
            } else {
                mHourTextPaint.setColor(mHourUnSelectedColor);
            }
            if (mSelectedBeginYear == mSelectedLastYear && mSelectedBeginMonth == mSelectedLastMonth && mSelectedBeginDay == mSelectedLastDay && day == hourFirstTime + 1) {
                mHourTextPaint.setColor(mHourTextSelectedColor);
            }

            canvas.drawText(mStrings[day - 1], x, y, mHourTextPaint);

            dayOffset++;
            if (dayOffset == 6) {
                dayOffset = 0;
                y += mRowHourHeight;
            }
            day++;
        }
    }

    private void drawSelectHourBackGround(Canvas canvas, RectF rectF) {
        Paint paint2 = new Paint();
        paint2.setFakeBoldText(true);
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Align.CENTER);
        paint2.setStyle(Style.FILL);
        paint2.setColor(Color.WHITE);
        paint2.setAlpha(SELECTED_CIRCLE_ALPHA);
        canvas.drawRoundRect(rectF, 0.0f, 0.0f, paint2);
        paint2.setStyle(Style.STROKE);
        paint2.setStrokeWidth(3);
        paint2.setColor(mSelectedDaysColor);
        canvas.drawRoundRect(rectF, 0.0f, 0.0f, paint2);

    }

    public int getHourFromLocation(float x, float y) {
        int padding = mPadding;
        if ((x < padding) || (x > mWidth - mPadding)) {
            return -1;
        }

        if (isFirstHourVisiable == 1 && lineVisiable == 1 || isLastHourVisiable == 1 && lineVisiable == 1) {

            if ((lineNumHour * mRowHeight + MONTH_HEADER_SIZE) < y && y < (lineNumHour * mRowHeight + MONTH_HEADER_SIZE + mNumRowsHour * mRowHourHeight)) {
                int yHour = (int) (y - mRowHeight * lineNumHour - MONTH_HEADER_SIZE) / mRowHourHeight;
                int hour = 1 + ((int) ((x - padding) * 6 / (mWidth - padding - mPadding))) + yHour * 6;
                return hour;
            }
        }
        return -1;
    }

    public SimpleMonthAdapter.CalendarDay getDayFromLocation(float x, float y) {
        int padding = mPadding;
        if ((x < padding) || (x > mWidth - mPadding)) {
            return null;
        }
        if (y < MONTH_HEADER_SIZE) {
            return null;
        }
        int yDay = 0;
        if (lineVisiable == 1) {
            if (y > MONTH_HEADER_SIZE && y < MONTH_HEADER_SIZE + lineNumHour * mRowHeight) {
                yDay = (int) (y - MONTH_HEADER_SIZE) / mRowHeight;
            } else if (y > MONTH_HEADER_SIZE + lineNumHour * mRowHeight && y < MONTH_HEADER_SIZE + lineNumHour * mRowHeight + mRowHourHeight * mNumRowsHour) {
                return null;
            } else if (y > MONTH_HEADER_SIZE + lineNumHour * mRowHeight + mRowHourHeight * mNumRowsHour) {
                yDay = (int) (y - MONTH_HEADER_SIZE - mRowHourHeight * mNumRowsHour) / mRowHeight;
            }
        } else {
            yDay = (int) (y - MONTH_HEADER_SIZE) / mRowHeight;
        }
        int day = 1 + ((int) ((x - padding) * mNumDays / (mWidth - padding - mPadding)) - findDayOffset()) + yDay * mNumDays;

        if (mMonth > 11 || mMonth < 0 || CalendarUtils.getDaysInMonth(mMonth, mYear) < day || day < 1) {
            return null;
        }
        if (mYear < today.year || mYear == today.year && mMonth < today.month || mYear == today.year && mMonth == today.month && day < today.monthDay) {
            return null;
        }

        return new SimpleMonthAdapter.CalendarDay(mYear, mMonth, day);
    }

    protected void initView() {
        mMonthTitlePaint = new Paint();
        mMonthTitlePaint.setFakeBoldText(true);
        mMonthTitlePaint.setAntiAlias(true);
        mMonthTitlePaint.setTextSize(MONTH_LABEL_TEXT_SIZE);
        mMonthTitlePaint.setColor(mMonthTextColor);
        mMonthTitlePaint.setTextAlign(Align.CENTER);
        mMonthTitlePaint.setStyle(Style.FILL);

        mMonthTitleBGPaint = new Paint();
        mMonthTitleBGPaint.setFakeBoldText(true);
        mMonthTitleBGPaint.setAntiAlias(true);
        mMonthTitleBGPaint.setColor(mMonthTitleBGColor);
        mMonthTitleBGPaint.setTextAlign(Align.CENTER);
        mMonthTitleBGPaint.setStyle(Style.FILL);

        mSelectedCirclePaint = new Paint();
        mSelectedCirclePaint.setFakeBoldText(true);
        mSelectedCirclePaint.setAntiAlias(true);
        mSelectedCirclePaint.setColor(mSelectedDaysColor);
        mSelectedCirclePaint.setTextAlign(Align.CENTER);
        mSelectedCirclePaint.setStyle(Style.FILL);
        mSelectedCirclePaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mMiddlePaint = new Paint();
        mMiddlePaint.setFakeBoldText(true);
        mMiddlePaint.setAntiAlias(true);
        mMiddlePaint.setColor(mMiddleDaysColor);
        mMiddlePaint.setTextAlign(Align.CENTER);
        mMiddlePaint.setStyle(Style.FILL);
        mMiddlePaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mMiddleHourPaint = new Paint();
        mMiddleHourPaint.setFakeBoldText(true);
        mMiddleHourPaint.setAntiAlias(true);
        mMiddleHourPaint.setColor(mMiddleHoursColor);
        mMiddleHourPaint.setTextAlign(Align.CENTER);
        mMiddleHourPaint.setStyle(Style.FILL);
        mMiddleHourPaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mHourBgPaint = new Paint();
        mHourBgPaint.setFakeBoldText(true);
        mHourBgPaint.setAntiAlias(true);
        mHourBgPaint.setColor(mHourBgColor);
        mHourBgPaint.setTextAlign(Align.CENTER);
        mHourBgPaint.setStyle(Style.FILL);
        mHourBgPaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mTodayPointPaint = new Paint();
        mTodayPointPaint.setFakeBoldText(true);
        mTodayPointPaint.setAntiAlias(true);
        mTodayPointPaint.setColor(mTodayPointColor);
        mTodayPointPaint.setTextAlign(Align.CENTER);
        mTodayPointPaint.setStyle(Style.FILL);
        mTodayPointPaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mHourLinePaint = new Paint();
        mHourLinePaint.setFakeBoldText(true);
        mHourLinePaint.setAntiAlias(true);
        mHourLinePaint.setColor(mHourLineColor);
        mHourLinePaint.setTextAlign(Align.CENTER);
        mHourLinePaint.setStyle(Style.STROKE);
        mHourLinePaint.setStrokeWidth(4);
        mHourLinePaint.setAlpha(SELECTED_CIRCLE_ALPHA);

        mHourTextPaint = new Paint();
        mHourTextPaint.setAntiAlias(true);
        mHourTextPaint.setTextSize(MINI_DAY_NUMBER_TEXT_SIZE);
        mHourTextPaint.setStyle(Style.FILL);
        mHourTextPaint.setTextAlign(Align.CENTER);
        mHourTextPaint.setFakeBoldText(false);

        mHourTextCornerPaint = new Paint();
        mHourTextCornerPaint.setAntiAlias(true);
        mHourTextCornerPaint.setTextSize(HOUR_TEXT_CORNER_SIZE);
        mHourTextCornerPaint.setStyle(Style.FILL);
        mHourTextCornerPaint.setTextAlign(Align.CENTER);
        mHourTextCornerPaint.setFakeBoldText(false);
        mHourTextCornerPaint.setColor(mHourCornerTextColor);

        mMonthDayLabelPaint = new Paint();
        mMonthDayLabelPaint.setAntiAlias(true);
        mMonthDayLabelPaint.setTextSize(MONTH_DAY_LABEL_TEXT_SIZE);
        mMonthDayLabelPaint.setColor(mDayTextColor);
        mMonthDayLabelPaint.setTypeface(Typeface.create(mDayOfWeekTypeface, Typeface.NORMAL));
        mMonthDayLabelPaint.setStyle(Style.FILL);
        mMonthDayLabelPaint.setTextAlign(Align.CENTER);
        mMonthDayLabelPaint.setFakeBoldText(true);

        mMonthNumPaint = new Paint();
        mMonthNumPaint.setAntiAlias(true);
        mMonthNumPaint.setTextSize(MINI_DAY_NUMBER_TEXT_SIZE);
        mMonthNumPaint.setStyle(Style.FILL);
        mMonthNumPaint.setTextAlign(Align.CENTER);
        mMonthNumPaint.setFakeBoldText(false);
    }

    protected void onDraw(Canvas canvas) {
        drawMonthTitle(canvas);
        // drawMonthDayLabels(canvas);
        drawMonthNums(canvas);
        drawHourNums(canvas);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mRowHeight * mNumRows + MONTH_HEADER_SIZE + mRowHourHeight * mNumRowsHour + 30);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            SimpleMonthAdapter.CalendarDay calendarDay = getDayFromLocation(event.getX(), event.getY());
            int hourFromLocation = getHourFromLocation(event.getX(), event.getY());
            if (hourFromLocation > 0 && hourFromLocation <= 24) {
                onHourClick(mStrings[hourFromLocation - 1], hourFromLocation - 1);
            } else if (calendarDay != null) {
                onDayClick(calendarDay);
            }
        }
        return true;
    }

    public void reuse() {
        mNumRows = DEFAULT_NUM_ROWS;
        mNumRowsHour = DEFAULT_NUM_ROWS_HOUR;
        requestLayout();
    }

    public void setMonthParams(HashMap<String, Integer> params) {
        if (!params.containsKey(VIEW_PARAMS_MONTH) && !params.containsKey(VIEW_PARAMS_YEAR)) {
            throw new InvalidParameterException("You must specify month and year for this view");
        }
        setTag(params);

        if (params.containsKey(VIEW_PARAMS_HEIGHT)) {
            mRowHeight = params.get(VIEW_PARAMS_HEIGHT);
            if (mRowHeight < MIN_HEIGHT) {
                mRowHeight = MIN_HEIGHT;
            }
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_BEGIN_DAY)) {
            mSelectedBeginDay = params.get(VIEW_PARAMS_SELECTED_BEGIN_DAY);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_LAST_DAY)) {
            mSelectedLastDay = params.get(VIEW_PARAMS_SELECTED_LAST_DAY);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_BEGIN_MONTH)) {
            mSelectedBeginMonth = params.get(VIEW_PARAMS_SELECTED_BEGIN_MONTH);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_LAST_MONTH)) {
            mSelectedLastMonth = params.get(VIEW_PARAMS_SELECTED_LAST_MONTH);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_BEGIN_YEAR)) {
            mSelectedBeginYear = params.get(VIEW_PARAMS_SELECTED_BEGIN_YEAR);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_LAST_YEAR)) {
            mSelectedLastYear = params.get(VIEW_PARAMS_SELECTED_LAST_YEAR);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_LAST_HOUR)) {
            hourListTime = params.get(VIEW_PARAMS_SELECTED_LAST_HOUR);
        }
        if (params.containsKey(VIEW_PARAMS_SELECTED_BEGIN_HOUR)) {
            hourFirstTime = params.get(VIEW_PARAMS_SELECTED_BEGIN_HOUR);
        }
        if (params.containsKey(VIEW_PARAMS_VISIABLE_BEGIN_HOUR)) {
            isFirstHourVisiable = params.get(VIEW_PARAMS_VISIABLE_BEGIN_HOUR);
        }
        if (params.containsKey(VIEW_PARAMS_VISIABLE_LAST_HOUR)) {
            isLastHourVisiable = params.get(VIEW_PARAMS_VISIABLE_LAST_HOUR);
        }
        if (params.containsKey(VIEW_PARAMS_LINE_NUM_VISIABLE)) {
            lineVisiable = params.get(VIEW_PARAMS_LINE_NUM_VISIABLE);
        } else {
            lineVisiable = -1;
        }
        if (lineVisiable == 1) {
            mNumRowsHour = 4;
        } else {
            mNumRowsHour = 0;
        }
        mMonth = params.get(VIEW_PARAMS_MONTH);
        mYear = params.get(VIEW_PARAMS_YEAR);

        mHasToday = false;
        mToday = -1;

        mCalendar.set(Calendar.MONTH, mMonth);
        mCalendar.set(Calendar.YEAR, mYear);
        mCalendar.set(Calendar.DAY_OF_MONTH, 1);
        mDayOfWeekStart = mCalendar.get(Calendar.DAY_OF_WEEK);

        if (params.containsKey(VIEW_PARAMS_WEEK_START)) {
            mWeekStart = params.get(VIEW_PARAMS_WEEK_START);
        } else {
            mWeekStart = mCalendar.getFirstDayOfWeek();
        }

        mNumCells = CalendarUtils.getDaysInMonth(mMonth, mYear);
        for (int i = 0; i < mNumCells; i++) {
            final int day = i + 1;
            if (sameDay(day, today)) {
                mHasToday = true;
                mToday = day;
            }
            mIsPrev = prevDay(day, today);
        }
        mNumRows = calculateNumRows();
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        mOnDayClickListener = onDayClickListener;
    }

    public static abstract interface OnDayClickListener {
        public abstract void onDayClick(SimpleMonthView simpleMonthView, SimpleMonthAdapter.CalendarDay calendarDay);

        public abstract void onHourClick(String hourString, int position);
    }
}