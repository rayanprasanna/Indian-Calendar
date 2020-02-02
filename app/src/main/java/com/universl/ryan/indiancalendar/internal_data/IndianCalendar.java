package com.universl.ryan.indiancalendar.internal_data;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.universl.ryan.indiancalendar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class IndianCalendar extends BaseAdapter {

    private Activity context;

    private Calendar month;
    public Calendar pmonth;
    /**
     * calendar instance for previous month for getting complete view
     */
    public GregorianCalendar pmonthmaxset;
    private GregorianCalendar selectedDate;
    int firstDay;
    int maxWeeknumber;
    int maxP;
    int calMaxP;
    int monthlength;
    String itemvalue, curentDateString;
    DateFormat df;

    private ArrayList<String> items;
    public static List<String> day_string;
    public ArrayList<EventCollection>  date_collection_arr;
    private String gridvalue;
    private ListView listTeachers;
    private ArrayList<Details> alCustom=new ArrayList<>();

    public IndianCalendar(Activity context, Calendar monthCalendar, ArrayList<EventCollection> date_collection_arr) {
        this.date_collection_arr=date_collection_arr;
        IndianCalendar.day_string = new ArrayList<String>();
        Locale.setDefault(Locale.US);
        month = monthCalendar;
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        this.context = context;
        month.set(GregorianCalendar.DAY_OF_MONTH, 1);

        this.items = new ArrayList<String>();
        df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        curentDateString = df.format(selectedDate.getTime());
        refreshDays();

    }

    public int getCount() {
        return day_string.size();
    }

    public Object getItem(int position) {
        return day_string.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new view for each item referenced by the Adapter
    @SuppressLint({"InflateParams", "ResourceAsColor"})
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView dayView;
        CircleImageView purple,dark_green,light_red,light_green,dark_red;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.calendar_items, null);

        }

        purple = v.findViewById(R.id.purple);
        dark_green = v.findViewById(R.id.dark_green);
        light_red = v.findViewById(R.id.light_red);
        light_green = v.findViewById(R.id.light_green);
        dark_red = v.findViewById(R.id.dark_red);

        purple.setBorderColor(Color.parseColor("#4B0082"));
        dark_green.setBorderColor(Color.parseColor("#666600"));
        light_red.setBorderColor(Color.parseColor("#ff0000"));
        light_green.setBorderColor(Color.parseColor("#00cc00"));
        dark_red.setBorderColor(Color.parseColor("#660000"));

        dayView = v.findViewById(R.id.date);

        String[] separatedTime = day_string.get(position).split("-");


        gridvalue = separatedTime[2].replaceFirst("^0*", "");

        if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
            dayView.setTextColor(android.R.color.transparent);
            dayView.setClickable(false);
            dayView.setFocusable(false);

            purple.setVisibility(View.GONE);
            dark_green.setVisibility(View.GONE);
            light_red.setVisibility(View.GONE);
            light_green.setVisibility(View.GONE);
            dark_red.setVisibility(View.GONE);
        } else if ((Integer.parseInt(gridvalue) <= 12) && (position > 28)) {
            dayView.setTextColor(android.R.color.transparent);
            dayView.setClickable(false);
            dayView.setFocusable(false);

            purple.setVisibility(View.GONE);
            dark_green.setVisibility(View.GONE);
            light_red.setVisibility(View.GONE);
            light_green.setVisibility(View.GONE);
            dark_red.setVisibility(View.GONE);
        } else {
            // setting curent month's days in blue color.
            dayView.setTextColor(Color.parseColor("#000000"));
            purple.setVisibility(View.GONE);
            dark_green.setVisibility(View.GONE);
            light_red.setVisibility(View.GONE);
            light_green.setVisibility(View.GONE);
            dark_red.setVisibility(View.GONE);
        }
        Calendar calendar = Calendar.getInstance();

        String days = separatedTime[2].replaceFirst("^0*", "");
        String months = separatedTime[1].replaceFirst("^0*", "");
        String years = separatedTime[0];
        calendar.set(Integer.parseInt(years), Integer.parseInt(months) - 1, Integer.parseInt(days));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (day_string.get(position).equals(curentDateString)) {
            if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
                v.setBackgroundResource(R.drawable.not_day);
            } else if ((Integer.parseInt(gridvalue) <= 12) && (position > 28)) {
                v.setBackgroundResource(R.drawable.not_day);
            }else {
                if (dayOfWeek == Calendar.SUNDAY){
                    dayView.setTextColor(Color.parseColor("#ff0000"));
                    v.setBackgroundResource(R.drawable.current_day);
                }else {
                    dayView.setTextColor(Color.parseColor("#000000"));
                    v.setBackgroundResource(R.drawable.current_day);
                }
            }
        } else {
            if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)){
                v.setBackgroundResource(R.drawable.not_day);
            }else if ((Integer.parseInt(gridvalue) <= 12) && (position > 28)){
                v.setBackgroundResource(R.drawable.not_day);
            }else {
                if (dayOfWeek == Calendar.SUNDAY){
                    dayView.setTextColor(Color.parseColor("#ff0000"));
                    v.setBackgroundResource(R.drawable.other_day);
                }else {
                    dayView.setTextColor(Color.parseColor("#000000"));
                    v.setBackgroundResource(R.drawable.other_day);
                }
                //v.setBackgroundResource(R.drawable.other_day);
            }
        }


        dayView.setText(gridvalue);

        // create date string for comparison
        String date = day_string.get(position);

        if (date.length() == 1) {
            date = "0" + date;
        }
        String monthStr = "" + (month.get(GregorianCalendar.MONTH) + 1);
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        setEventView(v, position,dayView,purple,dark_green,light_red,light_green,dark_red);

        return v;
    }

    public void refreshDays() {
        // clear items
        items.clear();
        day_string.clear();
        Locale.setDefault(Locale.US);
        pmonth = (GregorianCalendar) month.clone();
        // month start day. ie; sun, mon, etc
        firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
        // finding number of weeks in current month.
        maxWeeknumber = month.getMaximum(GregorianCalendar.WEEK_OF_MONTH);

        // allocating maximum row number for the gridview.
        monthlength = maxWeeknumber * 7;
        maxP = getMaxP(); // previous month maximum day 31,30....
        calMaxP = maxP - (firstDay - 1);// calendar offday starting 24,25 ...
        pmonthmaxset = (GregorianCalendar) pmonth.clone();

        pmonthmaxset.set(GregorianCalendar.DAY_OF_MONTH, calMaxP + 1);


        for (int n = 0; n < monthlength; n++) {

            itemvalue = df.format(pmonthmaxset.getTime());
            pmonthmaxset.add(GregorianCalendar.DATE, 1);
            day_string.add(itemvalue);
        }
        day_string.size();
    }

    private int getMaxP() {
        int maxP;
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            pmonth.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            pmonth.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }
        maxP = pmonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        return maxP;
    }




    private void setEventView(View v, int pos, TextView txt, CircleImageView purple, CircleImageView dark_green, CircleImageView light_red, CircleImageView light_green, CircleImageView dark_red){

        int len = EventCollection.date_collection_arr.size();
        for (int i = 0; i < len; i++) {
            EventCollection cal_obj = EventCollection.date_collection_arr.get(i);
            String date=cal_obj.date;

            String[] separatedTime = date.split("-");

            Calendar calendar = Calendar.getInstance();

            String days = separatedTime[2].replaceFirst("^0*", "");
            String months = separatedTime[1].replaceFirst("^0*", "");
            String years = separatedTime[0];
            calendar.set(Integer.parseInt(years), Integer.parseInt(months) - 1, Integer.parseInt(days));
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            int len1=day_string.size();
            if (len1>pos) {

                if (day_string.get(pos).equals(date)) {
                    if ((Integer.parseInt(gridvalue) > 1) && (pos < firstDay)) {
                        System.out.println("Nothing");
                    } else if ((Integer.parseInt(gridvalue) < 7) && (pos > 28)) {
                        System.out.println("Nothing");
                    } else {
                        if (date.equalsIgnoreCase("2019-01-01") || date.equalsIgnoreCase("2019-04-19") || date.equalsIgnoreCase("2019-04-21") || date.equalsIgnoreCase("2019-12-25")||date.equalsIgnoreCase("2020-01-01")||date.equalsIgnoreCase("2020-04-10")||date.equalsIgnoreCase("2020-04-12")||date.equalsIgnoreCase("2020-12-25")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.VISIBLE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.GONE);
                        }else if (date.equalsIgnoreCase("2019-01-12")||date.equalsIgnoreCase("2019-01-23")||date.equalsIgnoreCase("2019-01-26")||date.equalsIgnoreCase("2019-01-30")||date.equalsIgnoreCase("2019-04-01")||date.equalsIgnoreCase("2019-05-07")||date.equalsIgnoreCase("2019-10-02")||date.equalsIgnoreCase("2019-11-14")||
                        date.equalsIgnoreCase("2020-01-12")||date.equalsIgnoreCase("2020-01-23")||date.equalsIgnoreCase("2020-01-26")||date.equalsIgnoreCase("2020-01-30")||date.equalsIgnoreCase("2020-03-23")||date.equalsIgnoreCase("2020-04-01")||date.equalsIgnoreCase("2020-04-14")||date.equalsIgnoreCase("2020-08-15")||date.equalsIgnoreCase("2020-09-15")||date.equalsIgnoreCase("2020-10-02")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.VISIBLE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.GONE);
                        }else if(date.equalsIgnoreCase("2019-01-14")||date.equalsIgnoreCase("2020-01-14")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.VISIBLE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.GONE);
                        }else if (date.equalsIgnoreCase("2020-04-13")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.VISIBLE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.VISIBLE);
                        }else if (date.equalsIgnoreCase("2019-03-20")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.VISIBLE);
                            dark_red.setVisibility(View.VISIBLE);
                        }else if (date.equalsIgnoreCase("2019-03-23")||date.equalsIgnoreCase("2019-08-15")|| date.equalsIgnoreCase("2019-09-15")||date.equalsIgnoreCase("2020-01-17")||date.equalsIgnoreCase("2020-05-07")||date.equalsIgnoreCase("2020-11-14")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.VISIBLE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.VISIBLE);
                        }else if (date.equalsIgnoreCase("2019-04-14")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.VISIBLE);
                            dark_green.setVisibility(View.VISIBLE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.VISIBLE);
                        }else if (date.equalsIgnoreCase("2019-05-31")||date.equalsIgnoreCase("2019-06-05")||date.equalsIgnoreCase("2019-08-12")||date.equalsIgnoreCase("2019-09-01")||date.equalsIgnoreCase("2019-09-10")||date.equalsIgnoreCase("2019-11-10")||
                        date.equalsIgnoreCase("2020-03-08")||date.equalsIgnoreCase("2020-05-22")||date.equalsIgnoreCase("2020-05-24")||date.equalsIgnoreCase("2020-07-31")||date.equalsIgnoreCase("2020-08-20")||date.equalsIgnoreCase("2020-08-29")||date.equalsIgnoreCase("2020-10-29")){
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.VISIBLE);
                            dark_red.setVisibility(View.GONE);
                        }else {
                            v.setBackgroundColor(Color.parseColor("#000000"));
                            v.setBackgroundResource(R.drawable.rounded_calendar);
                            txt.setTextColor(Color.parseColor("#000000"));
                            purple.setVisibility(View.GONE);
                            dark_green.setVisibility(View.GONE);
                            light_red.setVisibility(View.GONE);
                            light_green.setVisibility(View.GONE);
                            dark_red.setVisibility(View.VISIBLE);
                        }
                    }

                }
            }}
    }

    public void getPositionList(String date,final Activity act){

        int len= EventCollection.date_collection_arr.size();
        JSONArray jbarrays=new JSONArray();
        for (int j=0; j<len; j++){
            if (EventCollection.date_collection_arr.get(j).date.equals(date)){
                HashMap<String, String> maplist = new HashMap<String, String>();
                maplist.put("hnames",EventCollection.date_collection_arr.get(j).name);
                maplist.put("hsubject",EventCollection.date_collection_arr.get(j).subject);
                maplist.put("descript",EventCollection.date_collection_arr.get(j).description);
                JSONObject json1 = new JSONObject(maplist);
                jbarrays.put(json1);
            }
        }
        if (jbarrays.length()!=0) {
            final Dialog dialogs = new Dialog(context);
            dialogs.setContentView(R.layout.dialog_information);
            listTeachers = (ListView) dialogs.findViewById(R.id.list_teachers);
            ImageView imgCross = (ImageView) dialogs.findViewById(R.id.img_cross);
            listTeachers.setAdapter(new Notification(context, getMatchList(jbarrays + "")));
            imgCross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogs.dismiss();
                }
            });
            dialogs.show();

        }

    }

    private ArrayList<Details> getMatchList(String detail) {
        try {
            JSONArray jsonArray = new JSONArray(detail);
            alCustom = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.optJSONObject(i);

                Details pojo = new Details();

                pojo.setTitles(jsonObject.optString("hnames"));
                pojo.setSubjects(jsonObject.optString("hsubject"));
                pojo.setDescripts(jsonObject.optString("descript"));

                alCustom.add(pojo);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return alCustom;
    }
}

