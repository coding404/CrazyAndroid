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
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class SimpleMonthAdapter extends RecyclerView.Adapter<SimpleMonthAdapter.ViewHolder> implements SimpleMonthView.OnDayClickListener {
    protected static final int MONTHS_IN_YEAR = 12;
    private final TypedArray typedArray;
    private final Context mContext;
    private final DatePickerController mController;
    private final Calendar calendar;
    private final SelectedDays<CalendarDay> selectedDays;
    private final Integer firstMonth;
    private final Integer lastMonth;

    public SimpleMonthAdapter(Context context, DatePickerController datePickerController, TypedArray typedArray) {
        this.typedArray = typedArray;
        calendar = Calendar.getInstance();
        firstMonth = typedArray.getInt(R.styleable.DayPickerView_firstMonth, calendar.get(Calendar.MONTH));
        lastMonth = typedArray.getInt(R.styleable.DayPickerView_lastMonth, (calendar.get(Calendar.MONTH) - 1) % MONTHS_IN_YEAR);
        selectedDays = new SelectedDays<>();
        mContext = context;
        mController = datePickerController;
        init();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final SimpleMonthView simpleMonthView = new SimpleMonthView(mContext, typedArray);
        return new ViewHolder(simpleMonthView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // viewHolder.setIsRecyclable(false);
        final SimpleMonthView v = viewHolder.simpleMonthView;
        final HashMap<String, Integer> drawingParams = new HashMap<String, Integer>();
        int month;
        int year;

        month = (firstMonth + (position % MONTHS_IN_YEAR)) % MONTHS_IN_YEAR;
        year = position / MONTHS_IN_YEAR + calendar.get(Calendar.YEAR) + ((firstMonth + (position % MONTHS_IN_YEAR)) / MONTHS_IN_YEAR);

        int selectedFirstDay = -1;
        int selectedLastDay = -1;
        int selectedFirstMonth = -1;
        int selectedLastMonth = -1;
        int selectedFirstYear = -1;
        int selectedLastYear = -1;
        int hourFirstTime = -1;
        int hourListTime = -1;
        int isFirstHourVisiable = -1;
        int isLastHourVisiable = -1;
        int lineVisiable;

        if (selectedDays.getFirst() != null) {
            selectedFirstDay = selectedDays.getFirst().day;
            selectedFirstMonth = selectedDays.getFirst().month;
            selectedFirstYear = selectedDays.getFirst().year;
            hourFirstTime = selectedDays.getFirst().getHourTime();
            isFirstHourVisiable = selectedDays.getFirst().getIsHourVisiable();
            calendar.set(selectedFirstYear, selectedFirstMonth, selectedFirstDay);
        }

        if (selectedDays.getLast() != null) {
            selectedLastDay = selectedDays.getLast().day;
            selectedLastMonth = selectedDays.getLast().month;
            selectedLastYear = selectedDays.getLast().year;
            hourListTime = selectedDays.getLast().getHourTime();
            isLastHourVisiable = selectedDays.getLast().getIsHourVisiable();
            calendar.set(selectedLastYear, selectedLastMonth, selectedLastDay);
        }
        if (selectedDays.getFirst() != null && selectedDays.getLast() == null) {
            if (year == selectedDays.getFirst().year && month == selectedDays.getFirst().month) {
                lineVisiable = 1;
            } else {
                lineVisiable = -1;
            }
        } else if (selectedDays.getLast() != null) {
            if (year == selectedDays.getLast().year && month == selectedDays.getLast().month) {
                lineVisiable = 1;
            } else {
                lineVisiable = -1;
            }
        } else {
            lineVisiable = -1;
        }

        v.reuse();
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_BEGIN_YEAR, selectedFirstYear);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_LAST_YEAR, selectedLastYear);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_BEGIN_MONTH, selectedFirstMonth);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_LAST_MONTH, selectedLastMonth);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_BEGIN_DAY, selectedFirstDay);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_LAST_DAY, selectedLastDay);

        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_LAST_HOUR, hourListTime);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_SELECTED_BEGIN_HOUR, hourFirstTime);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_VISIABLE_BEGIN_HOUR, isFirstHourVisiable);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_VISIABLE_LAST_HOUR, isLastHourVisiable);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_LINE_NUM_VISIABLE, lineVisiable);

        drawingParams.put(SimpleMonthView.VIEW_PARAMS_YEAR, year);
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_MONTH, month);
        calendar.setTimeInMillis(System.currentTimeMillis());
        drawingParams.put(SimpleMonthView.VIEW_PARAMS_WEEK_START, calendar.getFirstDayOfWeek());
        v.setMonthParams(drawingParams);
        v.invalidate();
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        int itemCount = (((mController.getMaxYear() - calendar.get(Calendar.YEAR)) + 1) * MONTHS_IN_YEAR);

        if (firstMonth != -1)
            itemCount -= firstMonth;

        if (lastMonth != -1)
            itemCount -= (MONTHS_IN_YEAR - lastMonth) - 1;

        return itemCount;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final SimpleMonthView simpleMonthView;

        public ViewHolder(View itemView, SimpleMonthView.OnDayClickListener onDayClickListener) {
            super(itemView);
            simpleMonthView = (SimpleMonthView) itemView;
            simpleMonthView.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            simpleMonthView.setClickable(true);
            simpleMonthView.setOnDayClickListener(onDayClickListener);
        }
    }

    protected void init() {
        if (typedArray.getBoolean(R.styleable.DayPickerView_currentDaySelected, false))
            onDayTapped(new CalendarDay(System.currentTimeMillis()));
    }

    public void onDayClick(SimpleMonthView simpleMonthView, CalendarDay calendarDay) {
        if (calendarDay != null) {
            onDayTapped(calendarDay);
        }
    }

    @Override
    public void onHourClick(String hourString, int position) {
        if (hourString != null) {
            onHourTapped(hourString, position);
        }
    }

    private void onHourTapped(String hourString, int position) {
        mController.onHourSelected(hourString);
        setSelectedHour(position);
    }

    private void setSelectedHour(int position) {

        if (selectedDays.getFirst() != null && selectedDays.getLast() == null) {
            if (selectedDays.getFirst().getHourTime() != -1 && selectedDays.getFirst().getHourTime() < position) {

                selectedDays.getFirst().setIsHourVisiable(-1);
                CalendarDay first = selectedDays.getFirst();
                CalendarDay calendarDay = new CalendarDay();
                calendarDay.set(first);
                calendarDay.setIsHourVisiable(1);
                calendarDay.setHourTime(position);
                selectedDays.setLast(calendarDay);
                mController.onDateRangeSelected(selectedDays);
            } else {
                selectedDays.getFirst().setHourTime(position);
            }
        } else if (selectedDays.getFirst() != null && selectedDays.getLast() != null) {
            if (selectedDays.getLast().getHourTime() == -1 &&
                    (selectedDays.getFirst().year > selectedDays.getLast().year ||
                            (selectedDays.getFirst().year == selectedDays.getLast().year && selectedDays.getFirst().month > selectedDays.getLast().month) ||
                            (selectedDays.getFirst().year == selectedDays.getLast().year && selectedDays.getFirst().month == selectedDays.getLast().month &&
                                    selectedDays.getFirst().day > selectedDays.getLast().day))) {
                selectedDays.getLast().setHourTime(position);
                CalendarDay last = selectedDays.getLast();
                CalendarDay calendarDay = new CalendarDay();
                calendarDay.set(last);
                calendarDay.setIsHourVisiable(1);
                calendarDay.setHourTime(position);
                selectedDays.setFirst(calendarDay);
                selectedDays.setLast(null);

            } else {
                Log.e("POSITION", "position=" + position);
                selectedDays.getLast().setHourTime(position);
                mController.onDateRangeSelected(selectedDays);
            }
        }

        notifyDataSetChanged();

    }

    protected void onDayTapped(CalendarDay calendarDay) {
        mController.onDayOfMonthSelected(calendarDay.year, calendarDay.month, calendarDay.day);
        setSelectedDay(calendarDay);
    }

    public void setSelectedDay(CalendarDay calendarDay) {

        if (selectedDays.getFirst() != null && selectedDays.getLast() == null) {
            CalendarDay first = selectedDays.getFirst();
            if (first.year == calendarDay.year && first.month == calendarDay.month && first.day == calendarDay.day) {
                return;
            }
            if (first.getHourTime() == -1) {
                selectedDays.setFirst(calendarDay);
                selectedDays.getFirst().setIsHourVisiable(1);
                selectedDays.getFirst().setHourTime(-1);
                selectedDays.setLast(null);
            } else {
                selectedDays.getFirst().setIsHourVisiable(-1);
                selectedDays.setLast(calendarDay);
                selectedDays.getLast().setIsHourVisiable(1);
                selectedDays.getLast().setHourTime(-1);
            }

        } else if (selectedDays.getLast() != null) {
            if (selectedDays.getFirst().year == calendarDay.year && selectedDays.getFirst().month == calendarDay.month && selectedDays.getFirst().day == calendarDay.day) {
                selectedDays.getFirst().setIsHourVisiable(1);
                selectedDays.setLast(null);
            } else {
                selectedDays.setLast(calendarDay);
                selectedDays.getLast().setHourTime(-1);
                selectedDays.getFirst().setIsHourVisiable(-1);
                selectedDays.getLast().setIsHourVisiable(1);
            }
        } else {
            selectedDays.setFirst(calendarDay);
            selectedDays.getFirst().setIsHourVisiable(1);
            selectedDays.getFirst().setHourTime(-1);
            selectedDays.setLast(null);
        }

        notifyDataSetChanged();
    }

    public static class CalendarDay implements Serializable {
        private static final long serialVersionUID = -5456695978688356202L;
        private Calendar calendar;

        int day;
        int month;
        int year;
        int hourTime;
        int isHourVisiable;

        public int getHourTime() {
            return hourTime;
        }

        public void setHourTime(int hourTime) {
            this.hourTime = hourTime;
        }

        public int getIsHourVisiable() {
            return isHourVisiable;
        }

        public void setIsHourVisiable(int isHourVisiable) {
            this.isHourVisiable = isHourVisiable;
        }

        public CalendarDay() {
            setTime(System.currentTimeMillis());
        }

        public CalendarDay(int year, int month, int day) {
            setDay(year, month, day);
        }

        public CalendarDay(long timeInMillis) {
            setTime(timeInMillis);
        }

        public CalendarDay(Calendar calendar) {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }

        private void setTime(long timeInMillis) {
            if (calendar == null) {
                calendar = Calendar.getInstance();
            }
            calendar.setTimeInMillis(timeInMillis);
            month = this.calendar.get(Calendar.MONTH);
            year = this.calendar.get(Calendar.YEAR);
            day = this.calendar.get(Calendar.DAY_OF_MONTH);
        }

        public void set(CalendarDay calendarDay) {
            year = calendarDay.year;
            month = calendarDay.month;
            day = calendarDay.day;
        }

        public void setDay(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public Date getDate() {
            if (calendar == null) {
                calendar = Calendar.getInstance();
            }
            calendar.set(year, month, day, hourTime, 0);

            return calendar.getTime();
        }

        @Override
        public String toString() {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ year: ");
            stringBuilder.append(year);
            stringBuilder.append(", month: ");
            stringBuilder.append(month);
            stringBuilder.append(", day: ");
            stringBuilder.append(day);
            stringBuilder.append(", hour: ");
            stringBuilder.append(hourTime);
            stringBuilder.append(" }");

            return stringBuilder.toString();
        }
    }

    public SelectedDays<CalendarDay> getSelectedDays() {
        return selectedDays;
    }

    public static class SelectedDays<K> implements Serializable {
        private static final long serialVersionUID = 3942549765282708376L;
        private K first;
        private K last;

        public K getFirst() {
            return first;
        }

        public void setFirst(K first) {
            this.first = first;
        }

        public K getLast() {
            return last;
        }

        public void setLast(K last) {
            this.last = last;
        }
    }
}