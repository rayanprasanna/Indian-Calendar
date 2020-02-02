package com.universl.ryan.indiancalendar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universl.ryan.indiancalendar.internal_data.EventCollection;
import com.universl.ryan.indiancalendar.internal_data.IndianCalendar;
import com.universl.ryan.indiancalendar.sub_activity.AllEventActivity;
import com.universl.ryan.indiancalendar.sub_activity.AllHolidayActivity;
import com.universl.ryan.indiancalendar.sub_activity.RemindTaskActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    public Calendar cal_month, cal_month_copy;
    private IndianCalendar hwAdapter;
    private TextView tv_month;
    RelativeLayout main;
    LinearLayout date_layout;
    LinearLayout holiday_2,holiday,holiday_details;
    TextView month_1,month_2,month_3,month_4,month_5,month_6,month_7,month_8,month_9,month_10,month_11,title_1,title_2,title_3,title_4,title_5,title_6,title_7,title_8,title_9,title_10,title_11;
    CircleImageView purple_1,purple_2,purple_3,purple_4,purple_5,purple_6,purple_7,purple_8,purple_9,purple_10,purple_11;
    CircleImageView dark_green_1,dark_green_2,dark_green_3,dark_green_4,dark_green_5,dark_green_6,dark_green_7,dark_green_8,dark_green_9,dark_green_10,dark_green_11;
    CircleImageView light_red_1,light_red_2,light_red_3,light_red_4,light_red_5,light_red_6,light_red_7,light_red_8,light_red_9,light_red_10,light_red_11;
    CircleImageView light_green_1,light_green_2,light_green_3,light_green_4,light_green_5,light_green_6,light_green_7,light_green_8,light_green_9,light_green_10,light_green_11;
    CircleImageView dark_red_1,dark_red_2,dark_red_3,dark_red_4,dark_red_5,dark_red_6,dark_red_7,dark_red_8,dark_red_9,dark_red_10,dark_red_11;

    public Activity activity;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.search_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>Indian Calendar 2020</font>"));


        activity = MainActivity.this;
        holiday_2 = findViewById(R.id.holiday_2);holiday = findViewById(R.id.holiday); holiday_details = findViewById(R.id.holiday_details);

        date_layout = findViewById(R.id.layout);
        main = findViewById(R.id.main); month_1 = findViewById(R.id.month_1); month_2 = findViewById(R.id.month_2); month_3 = findViewById(R.id.month_3); month_4 = findViewById(R.id.month_4);month_5 = findViewById(R.id.month_5); month_6 = findViewById(R.id.month_6); month_7 = findViewById(R.id.month_7); month_8 = findViewById(R.id.month_8);month_9 = findViewById(R.id.month_9); month_10 = findViewById(R.id.month_10); month_11 = findViewById(R.id.month_11);

        purple_1 = findViewById(R.id.purple_1); purple_2 = findViewById(R.id.purple_2); purple_3 = findViewById(R.id.purple_3); purple_4 = findViewById(R.id.purple_4); purple_5 = findViewById(R.id.purple_5); purple_6 = findViewById(R.id.purple_6); purple_7 = findViewById(R.id.purple_7); purple_8 = findViewById(R.id.purple_8);purple_9 = findViewById(R.id.purple_9); purple_10 = findViewById(R.id.purple_10); purple_11 = findViewById(R.id.purple_11);

        dark_green_1 = findViewById(R.id.dark_green_1); dark_green_2 = findViewById(R.id.dark_green_2); dark_green_3 = findViewById(R.id.dark_green_3); dark_green_4 = findViewById(R.id.dark_green_4); dark_green_5 = findViewById(R.id.dark_green_5); dark_green_6 = findViewById(R.id.dark_green_6); dark_green_7 = findViewById(R.id.dark_green_7); dark_green_8 = findViewById(R.id.dark_green_8);dark_green_9 = findViewById(R.id.dark_green_9); dark_green_10 = findViewById(R.id.dark_green_10); dark_green_11 = findViewById(R.id.dark_green_11);

        light_red_1 = findViewById(R.id.light_red_1); light_red_2 = findViewById(R.id.light_red_2); light_red_3 = findViewById(R.id.light_red_3); light_red_4 = findViewById(R.id.light_red_4); light_red_5 = findViewById(R.id.light_red_5); light_red_6 = findViewById(R.id.light_red_6); light_red_7 = findViewById(R.id.light_red_7); light_red_8 = findViewById(R.id.light_red_8);light_red_9 = findViewById(R.id.light_red_9); light_red_10 = findViewById(R.id.light_red_10); light_red_11 = findViewById(R.id.light_red_11);

        light_green_1 = findViewById(R.id.light_green_1); light_green_2 = findViewById(R.id.light_green_2); light_green_3 = findViewById(R.id.light_green_3); light_green_4 = findViewById(R.id.light_green_4); light_green_5 = findViewById(R.id.light_green_5); light_green_6 = findViewById(R.id.light_green_6); light_green_7 = findViewById(R.id.light_green_7); light_green_8 = findViewById(R.id.light_green_8);light_green_9 = findViewById(R.id.light_green_9); light_green_10 = findViewById(R.id.light_green_10); light_green_11 = findViewById(R.id.light_green_11);

        dark_red_1 = findViewById(R.id.dark_red_1); dark_red_2 = findViewById(R.id.dark_red_2); dark_red_3 = findViewById(R.id.dark_red_3); dark_red_4 = findViewById(R.id.dark_red_4); dark_red_5 = findViewById(R.id.dark_red_5); dark_red_6 = findViewById(R.id.dark_red_6); dark_red_7 = findViewById(R.id.dark_red_7); dark_red_8 = findViewById(R.id.dark_red_8);dark_red_9 = findViewById(R.id.dark_red_9); dark_red_10 = findViewById(R.id.dark_red_10); dark_red_11 = findViewById(R.id.dark_red_11);

        // 2019 Sri Lanka Calendar
        EventCollection.date_collection_arr=new ArrayList<>(); title_1 = findViewById(R.id.title_1); title_2 = findViewById(R.id.title_2); title_3 = findViewById(R.id.title_3); title_4 = findViewById(R.id.title_4);title_5 = findViewById(R.id.title_5); title_6 = findViewById(R.id.title_6); title_7 = findViewById(R.id.title_7); title_8 = findViewById(R.id.title_8);title_9 = findViewById(R.id.title_9); title_10 = findViewById(R.id.title_10); title_11 = findViewById(R.id.title_11);

        EventCollection.date_collection_arr.add( new EventCollection("2019-01-01" ,"01 - अंग्रेजी नव वर्ष","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-12" ,"12 - स्वामी विवेकानंद जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-13" ,"13 - गुरु गोविंद सिंह जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-14" ,"14 - लोहड़ी","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-15" ,"15 - पोंगल","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-17" ,"17 - तैलंग स्वामी जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-23" ,"23 - सुभास चंद्र बोस जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-26" ,"26 - गणतंत्र दिवस","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-27" ,"27 - विवेकानंद जयंती * संवत","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-30" ,"30 - गांधी पुण्यतिथि","Holiday","जनवरी"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-02-10" ,"10 - वसंत पंचमी","Holiday","फरवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-02-19" ,"19 - गुरु रविदास जयंती","Holiday","फरवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-02-28" ,"28 - महर्षि जयानंद सरस्वती जयंती","Holiday","फरवरी"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-03-04" ,"04 - महा शिवरात्रि","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-08" ,"08 - रामकृष्ण जयंती","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-20" ,"20 - छोटी होली, होलिका दहन, हज़रत अली का जन्मदिन","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-21" ,"21 - होली, चैतन्य महाप्रभु जयंती, पारसी नववर्ष","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-23" ,"23 - शिवाजी जयंती, शहीद दिवस","Holiday","मार्च"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-04-01" ,"01 - बैंक की छुट्टी","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-06" ,"06 - गुड़ी पड़वा, उगादी","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-13" ,"13 - राम नवमी * स्मार्टा","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-14" ,"14 - राम नवमी * इस्कॉन, सौर नववर्ष, बैसाखी, अम्बेडकर जयंती","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-17" ,"17 - महावीर जयंती","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-19" ,"19 - गुड फ्राइडे","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-21" ,"21 - ईस्टर","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-30" ,"30 - वल्लभाचार्य जयंती","Holiday","अप्रैल"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-05-07" ,"07 - रवीन्द्रनाथ टैगोर जयंती","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-09" ,"09 - आदि शंकराचार्य जयंती, सूरदास जयंती","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-18" ,"18 - बुद्ध पूर्णिमा, बुद्ध जयंती","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-31" ,"31 - जमात उल-विदा","Holiday","मई"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-06-05" ,"05 - ईद अल-फितर (रमजान)","Holiday","जून"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-06-06" ,"06 - महाराणा प्रताप जयंती","Holiday","जून"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-06-17" ,"17 - संत कबीरदास जयंती","Holiday","जून"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-07-04" ,"04 - रथ यात्रा","Holiday","जुलाई"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-07-16" ,"16 - गुरु पूर्णिमा","Holiday","जुलाई"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-08-07" ,"07 - तुलसीदास जयंती","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-08-12" ,"12 - बकरीद, ईद अल-अधा","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-08-15" ,"15 - राखी, रक्षा बंधन, स्वतंत्रता दिवस","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-08-24" ,"24 - कृष्ण जन्माष्टमी","Holiday","अगस्त"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-09-01" ,"01 - अल-हिजरा, इस्लामी नया साल","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-02" ,"02 - गणेश चतुर्थी","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-10" ,"10 - आशूरा का दिन, मुहर्रम","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-11" ,"11 - ओणम","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-15" ,"15 - विश्वेश्वर्य जयंती","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-23" ,"23 - शरद विषुव","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-29" ,"29 - महाराजा अग्रसेन जयंती","Holiday","सितंबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-10-02" ,"02 - महात्मा गांधी जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-06" ,"06 - दुर्गा अष्टमी, महा नवमी","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-08" ,"08 - दशहरा, माधवाचार्य जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-13" ,"13 - वाल्मीकि जयंती, मीरा बाई जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-17" ,"17 - करवा चौथ","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-27" ,"27 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-28" ,"28 - गोवर्धन पूजा","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-29" ,"29 - भाई दूज","Holiday","अक्टूबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-11-02" ,"02 - छठ पूजा","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-11-10" ,"10 - मिलाद-ए-नबी, ईद-ए-मिलाद","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-11-12" ,"12 - गुरु नानक जयंती","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-11-14" ,"14 - जवाहरलाल नेहरू जयंती","Holiday","नवंबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2019-12-25" ,"25 - मेरी क्रिसमस","Holiday","දෙසැ."));



        //2020 Sri Lanka Calendar
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-01" ,"01 - अंग्रेजी नव वर्ष","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-02" ,"02 - गुरु गोविंद सिंह जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-06" ,"06 - तैलंग स्वामी जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-12" ,"12 - स्वामी विवेकानंद जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-14" ,"14 - लोहड़ी","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-15" ,"15 - पोंगल","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-17" ,"17 - विवेकानंद जयंती * संवत","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-23" ,"23 - सुभास चंद्र बोस जयंती","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-26" ,"26 - गणतंत्र दिवस","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-29" ,"29 - वसंत पंचमी","Holiday","जनवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-30" ,"30 - गांधी पुण्यतिथि","Holiday","जनवरी"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-02-09" ,"09 - गुरु रविदास जयंती","Holiday","फरवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-18" ,"18 - महर्षि जयानंद सरस्वती जयंती","Holiday","फरवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-21" ,"21 - महा शिवरात्रि","Holiday","फरवरी"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-25" ,"25 - रामकृष्ण जयंती","Holiday","फरवरी"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-03-08" ,"08 - हज़रत अली का जन्मदिन","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-09" ,"09 - छोटी होली, होलिका दहन, चैतन्य महाप्रभु जयंती","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-10" ,"10 - होली","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-12" ,"12 - शिवाजी जयंती","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-20" ,"20 - पारसी नव वर्ष","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-23" ,"23 - शहीद दिवस","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-25" ,"25 - गुड़ी पड़वा, उगादी","Holiday","मार्च"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-26" ,"26 - झूलेलाल जयंती","Holiday","मार्च"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-04-01" ,"01 - बैंक की छुट्टी","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-02" ,"02 - राम नवमी","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-06" ,"06 - महावीर जयंती","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-10" ,"10 - शुभ शुक्रवार","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-12" ,"12 - ईस्टर","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-13" ,"13 - सौर नव वर्ष, बैसाखी","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-14" ,"14 - अंबेडकर जयंती","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-18" ,"18 - वल्लभाचार्य जयंती","Holiday","अप्रैल"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-28" ,"28 - शंकराचार्य जयंती, सूरदास जयंती","Holiday","अप्रैल"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-05-07" ,"07 - बुद्ध पूर्णिमा, बुद्ध जयंती, रवींद्रनाथ टैगोर जयंती","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-22" ,"22 - जमात उल-विदा","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-24" ,"24 - ईद अल-फितर (रमजान)","Holiday","मई"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-25" ,"25 - महाराणा प्रताप जयंती","Holiday","मई"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-06-05" ,"05 - संत कबीरदास जयंती","Holiday","जून"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-23" ,"23 - रथ यात्रा","Holiday","जून"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-07-05" ,"05 - गुरु पूर्णिमा","Holiday","जुलाई"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-27" ,"27 - तुलसीदास जयंती","Holiday","जुलाई"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-31" ,"31 - ईद अल-अधा, बकरीद","Holiday","जुलाई"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-08-03" ,"03 - राखी, रक्षा बंधन","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-11" ,"11 - कृष्ण जन्माष्टमी * स्मार्टा","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-12" ,"12 - कृष्ण जन्माष्टमी * इस्कॉन","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-15" ,"15 - स्वतंत्रता दिवस","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-20" ,"20 - अल-हिजरा, इस्लामिक न्यूयर","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-22" ,"22 - गणेश चतुर्थी","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-29" ,"29 - आशूरा का दिन, मुहर्रम","Holiday","अगस्त"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-31" ,"31 - ओणम","Holiday","अगस्त"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-09-15" ,"15 - विश्वेश्वर्य जयंती","Holiday","सितंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-09-22" ,"22 - शरद विषुव","Holiday","सितंबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-10-02" ,"02 - महात्मा गांधी जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-17" ,"17 - महाराजा अग्रसेन जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-24" ,"24 - दुर्गा अष्टमी, महा नवमी","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-25" ,"25 - दशहरा","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-26" ,"26 - माधवाचार्य जयंती","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-29" ,"29 - मिलाद-ए-नबी, ईद-ए-मिलाद","Holiday","अक्टूबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-31" ,"31 - वाल्मीकि जयंती, मीरा बाई जयंती","Holiday","अक्टूबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-11-04" ,"04 - करवा चौथ","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-14" ,"14 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा, जवाहरलाल नेहरू जयंती","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-15" ,"15 - गोवर्धन पूजा","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-16" ,"16 - भाई दूज","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-20" ,"20 - छठ पूजा","Holiday","नवंबर"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-30" ,"30 - गुरु नानक जयंती","Holiday","नवंबर"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-12-25" ,"25 - मेरी क्रिसमस","Holiday","दिसंबर"));

        cal_month = GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new IndianCalendar(this, cal_month,EventCollection.date_collection_arr);

        tv_month = findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

        if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
            main.setBackgroundResource(R.drawable.january);
            month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("जनवरी");title_2.setText("12 - स्वामी विवेकानंद जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
            month_3.setText("जनवरी");title_3.setText("13 - गुरु गोविंद सिंह जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("जनवरी");title_4.setText("14 - लोहड़ी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setText("जनवरी");title_5.setText("15 - पोंगल");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("जनवरी");title_6.setText("17 - तैलंग स्वामी जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("जनवरी");title_7.setText("23 - सुभास चंद्र बोस जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setText("जनवरी");title_8.setText("26 - गणतंत्र दिवस");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setText("जनवरी");title_9.setText("27 - विवेकानंद जयंती * संवत");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
            month_10.setText("जनवरी");title_10.setText("30 - गांधी पुण्यतिथि");purple_10.setVisibility(View.VISIBLE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
            main.setBackgroundResource(R.drawable.february);
            month_1.setText("फरवरी");title_1.setText("10 - वसंत पंचमी");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("फरवरी");title_2.setText("19 - गुरु रविदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("फरवरी");title_3.setText("28 - महर्षि जयानंद सरस्वती जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
            main.setBackgroundResource(R.drawable.march);
            month_1.setText("मार्च");title_1.setText("04 - महा शिवरात्रि");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("मार्च");title_2.setText("08 - रामकृष्ण जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("मार्च");title_3.setText("20 - छोटी होली, होलिका दहन, हज़रत अली का जन्मदिन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("मार्च");title_4.setText("21 - होली, चैतन्य महाप्रभु जयंती, पारसी नववर्ष");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("मार्च");title_5.setText("23 - शिवाजी जयंती, शहीद दिवस");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
            main.setBackgroundResource(R.drawable.april);
            month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("अप्रैल");title_2.setText("06 - गुड़ी पड़वा, उगादी, झूलेलाल जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("अप्रैल");title_3.setText("13 - राम नवमी * स्मार्टा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अप्रैल");title_4.setText("14 - राम नवमी * इस्कॉन, सौर नववर्ष, बैसाखी, अम्बेडकर जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("अप्रैल");title_5.setText("17 - महावीर जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("अप्रैल");title_6.setText("19 - गुड फ्राइडे");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setText("अप्रैल");title_7.setText("21 - ईस्टर");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setText("अप्रैल");title_8.setText("30 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
            main.setBackgroundResource(R.drawable.may);
            month_1.setText("मई");title_1.setText("07 - रवीन्द्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("मई");title_2.setText("09 - आदि शंकराचार्य जयंती, सूरदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("मई");title_3.setText("18 - बुद्ध पूर्णिमा, बुद्ध जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("मई");title_4.setText("31 - जमात उल-विदा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
            main.setBackgroundResource(R.drawable.june);
            month_1.setText("जून");title_1.setText("05 - ईद अल-फितर (रमजान)");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("जून");title_2.setText("06 - महाराणा प्रताप जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("जून");title_3.setText("17 - संत कबीरदास जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
            main.setBackgroundResource(R.drawable.july);
            month_1.setText("जुलाई");title_1.setText("04 - रथ यात्रा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("जुलाई");title_2.setText("16 - गुरु पूर्णिमा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
            main.setBackgroundResource(R.drawable.august);
            month_1.setText("अगस्त");title_1.setText("07 - तुलसीदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("अगस्त");title_2.setText("12 - बकरीद, ईद अल-अधा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
            month_3.setText("अगस्त");title_3.setText("15 - राखी, रक्षा बंधन, स्वतंत्रता दिवस");purple_3.setVisibility(View.VISIBLE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अगस्त");title_4.setText("24 - कृष्ण जन्माष्टमी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
            main.setBackgroundResource(R.drawable.september);
            month_1.setText("सितंबर");title_1.setText("01 - अल-हिजरा, इस्लामी नया साल");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("सितंबर");title_2.setText("02 - गणेश चतुर्थी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("सितंबर");title_3.setText("10 - आशूरा का दिन, मुहर्रम");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
            month_4.setText("सितंबर");title_4.setText("11 - ओणम");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("सितंबर");title_5.setText("15 - विश्वेश्वर्य जयंती");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("सितंबर");title_6.setText("23 - शरद विषुव");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("सितंबर");title_7.setText("29 - महाराजा अग्रसेन जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
            main.setBackgroundResource(R.drawable.october);
            month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("अक्टूबर");title_2.setText("06 - दुर्गा अष्टमी, महा नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("अक्टूबर");title_3.setText("08 - दशहरा, माधवाचार्य जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अक्टूबर");title_4.setText("13 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("अक्टूबर");title_5.setText("17 - करवा चौथ");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("अक्टूबर");title_6.setText("27 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("अक्टूबर");title_7.setText("28 - गोवर्धन पूजा");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
            month_8.setText("अक्टूबर");title_8.setText("29 - भाई दूज");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
            main.setBackgroundResource(R.drawable.novenber);
            month_1.setText("नवंबर");title_1.setText("02 - छठ पूजा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("नवंबर");title_2.setText("10 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
            month_3.setText("नवंबर");title_3.setText("12 - गुरु नानक जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("नवंबर");title_4.setText("14 - जवाहरलाल नेहरू जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
            main.setBackgroundResource(R.drawable.december);
            month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
            main.setBackgroundResource(R.drawable.january);
            month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("जनवरी");title_2.setText("02 - गुरु गोविंद सिंह जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("जनवरी");title_3.setText("06 - तैलंग स्वामी जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("जनवरी");title_4.setText("12 - स्वामी विवेकानंद जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setText("जनवरी");title_5.setText("14 - लोहड़ी");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.VISIBLE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setText("जनवरी");title_6.setText("15 - पोंगल");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("जनवरी");title_7.setText("17 - विवेकानंद जयंती * संवत");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
            month_8.setText("जनवरी");title_8.setText("23 - सुभास चंद्र बोस जयंती");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setText("जनवरी");title_9.setText("26 - गणतंत्र दिवस");purple_9.setVisibility(View.VISIBLE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setText("जनवरी");title_10.setText("29 - वसंत पंचमी");purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.VISIBLE);
            month_11.setText("जनवरी");title_11.setText("30 - गांधी पुण्यतिथि");purple_11.setVisibility(View.VISIBLE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
            main.setBackgroundResource(R.drawable.february);
            month_1.setText("फरवरी");title_1.setText("09 - गुरु रविदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("फरवरी");title_2.setText("18 - महर्षि जयानंद सरस्वती जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("फरवरी");title_3.setText("21 - महा शिवरात्रि");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("फरवरी");title_4.setText("25 - रामकृष्ण जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
            main.setBackgroundResource(R.drawable.march);
            month_1.setText("मार्च");title_1.setText("08 - हज़रत अली का जन्मदिन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("मार्च");title_2.setText("09 - छोटी होली, होलिका दहन, चैतन्य महाप्रभु जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("मार्च");title_3.setText("10 - होली");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("मार्च");title_4.setText("12 - शिवाजी जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("मार्च");title_5.setText("20 - पारसी नव वर्ष");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("मार्च");title_6.setText("23 - शहीद दिवस");purple_6.setVisibility(View.VISIBLE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setText("मार्च");title_7.setText("25 - गुड़ी पड़वा, उगादी");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
            month_8.setText("मार्च");title_8.setText("26 - झूलेलाल जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
            main.setBackgroundResource(R.drawable.april);
            month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("अप्रैल");title_2.setText("02 - राम नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("अप्रैल");title_3.setText("06 - महावीर जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अप्रैल");title_4.setText("10 - शुभ शुक्रवार");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.VISIBLE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setText("अप्रैल");title_5.setText("12 - ईस्टर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.VISIBLE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setText("अप्रैल");title_6.setText("13 - सौर नव वर्ष, बैसाखी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.VISIBLE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("अप्रैल");title_7.setText("14 - अंबेडकर जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setText("अप्रैल");title_8.setText("18 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
            month_9.setText("अप्रैल");title_9.setText("28 - शंकराचार्य जयंती, सूरदास जयंती");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
            main.setBackgroundResource(R.drawable.may);
            month_1.setText("मई");title_1.setText("07 - बुद्ध पूर्णिमा, बुद्ध जयंती, रवींद्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("मई");title_2.setText("22 - जमात उल-विदा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
            month_3.setText("मई");title_3.setText("24 - ईद अल-फितर (रमजान)");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
            month_4.setText("मई");title_4.setText("25 - महाराणा प्रताप जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
            main.setBackgroundResource(R.drawable.june);
            month_1.setText("जून");title_1.setText("05 - संत कबीरदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("जून");title_2.setText("23 - रथ यात्रा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
            main.setBackgroundResource(R.drawable.july);
            month_1.setText("जुलाई");title_1.setText("05 - गुरु पूर्णिमा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("जुलाई");title_2.setText("27 - तुलसीदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("जुलाई");title_3.setText("31 - ईद अल-अधा, बकरीद");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
            main.setBackgroundResource(R.drawable.august);
            month_1.setText("अगस्त");title_1.setText("03 - राखी, रक्षा बंधन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("अगस्त");title_2.setText("11 - कृष्ण जन्माष्टमी * स्मार्टा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("अगस्त");title_3.setText("12 - कृष्ण जन्माष्टमी * इस्कॉन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अगस्त");title_4.setText("15 - स्वतंत्रता दिवस");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setText("अगस्त");title_5.setText("20 - अल-हिजरा, इस्लामिक न्यूयर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.VISIBLE);dark_red_5.setVisibility(View.GONE);
            month_6.setText("अगस्त");title_6.setText("22 - गणेश चतुर्थी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setText("अगस्त");title_7.setText("29 - आशूरा का दिन, मुहर्रम");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);dark_red_7.setVisibility(View.GONE);
            month_8.setText("अगस्त");title_8.setText("31 - ओणम");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
            main.setBackgroundResource(R.drawable.september);
            month_1.setText("सितंबर");title_1.setText("15 - विश्वेश्वर्य जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("सितंबर");title_2.setText("22 - शरद विषुव");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
            main.setBackgroundResource(R.drawable.october);
            month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setText("अक्टूबर");title_2.setText("17 - महाराजा अग्रसेन जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("अक्टूबर");title_3.setText("24 - दुर्गा अष्टमी, महा नवमी");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("अक्टूबर");title_4.setText("25 - दशहरा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("अक्टूबर");title_5.setText("26 - माधवाचार्य जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("अक्टूबर");title_6.setText("29 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.VISIBLE);dark_red_6.setVisibility(View.GONE);
            month_7.setText("अक्टूबर");title_7.setText("31 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
            main.setBackgroundResource(R.drawable.novenber);
            month_1.setText("नवंबर");title_1.setText("04 - करवा चौथ");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
            month_2.setText("नवंबर");title_2.setText("14 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा, जवाहरलाल नेहरू जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
            month_3.setText("नवंबर");title_3.setText("15 - गोवर्धन पूजा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
            month_4.setText("नवंबर");title_4.setText("16 - भाई दूज");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
            month_5.setText("नवंबर");title_5.setText("20 - छठ पूजा");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
            month_6.setText("नवंबर");title_6.setText("30 - गुरु नानक जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
            main.setBackgroundResource(R.drawable.december);
            month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
        }
        ImageButton previous = findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.err.println("Month : " + GregorianCalendar.MONTH);
                System.err.println("Month : " + Calendar.MONTH);
                setPreviousMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("जनवरी");title_2.setText("12 - स्वामी विवेकानंद जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setText("जनवरी");title_3.setText("13 - गुरु गोविंद सिंह जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("जनवरी");title_4.setText("14 - लोहड़ी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("जनवरी");title_5.setText("15 - पोंगल");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("जनवरी");title_6.setText("17 - तैलंग स्वामी जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("जनवरी");title_7.setText("23 - सुभास चंद्र बोस जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("जनवरी");title_8.setText("26 - गणतंत्र दिवस");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.VISIBLE);title_9.setVisibility(View.VISIBLE);month_9.setText("जनवरी");title_9.setText("27 - विवेकानंद जयंती * संवत");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
                        month_10.setVisibility(View.VISIBLE);title_10.setVisibility(View.VISIBLE);month_10.setText("जनवरी");title_10.setText("30 - गांधी पुण्यतिथि");purple_10.setVisibility(View.VISIBLE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("फरवरी");title_1.setText("10 - वसंत पंचमी");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("फरवरी");title_2.setText("19 - गुरु रविदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("फरवरी");title_3.setText("28 - महर्षि जयानंद सरस्वती जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("मार्च");title_1.setText("04 - महा शिवरात्रि");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("मार्च");title_2.setText("08 - रामकृष्ण जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मार्च");title_3.setText("20 - छोटी होली, होलिका दहन, हज़रत अली का जन्मदिन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("मार्च");title_4.setText("21 - होली, चैतन्य महाप्रभु जयंती, पारसी नववर्ष");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("मार्च");title_5.setText("23 - शिवाजी जयंती, शहीद दिवस");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अप्रैल");title_2.setText("06 - गुड़ी पड़वा, उगादी, झूलेलाल जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अप्रैल");title_3.setText("13 - राम नवमी * स्मार्टा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अप्रैल");title_4.setText("14 - राम नवमी * इस्कॉन, सौर नववर्ष, बैसाखी, अम्बेडकर जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अप्रैल");title_5.setText("17 - महावीर जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अप्रैल");title_6.setText("19 - गुड फ्राइडे");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अप्रैल");title_7.setText("21 - ईस्टर");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अप्रैल");title_8.setText("30 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("मई");title_1.setText("07 - रवीन्द्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("मई");title_2.setText("09 - आदि शंकराचार्य जयंती, सूरदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मई");title_3.setText("18 - बुद्ध पूर्णिमा, बुद्ध जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("मई");title_4.setText("31 - जमात उल-विदा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("जून");title_1.setText("05 - ईद अल-फितर (रमजान)");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("जून");title_2.setText("06 - महाराणा प्रताप जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("जून");title_3.setText("17 - संत कबीरदास जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("जुलाई");title_1.setText("04 - रथ यात्रा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जुलाई");title_2.setText("16 - गुरु पूर्णिमा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("अगस्त");title_1.setText("07 - तुलसीदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("अगस्त");title_2.setText("12 - बकरीद, ईद अल-अधा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setText("अगस्त");title_3.setText("15 - राखी, रक्षा बंधन, स्वतंत्रता दिवस");purple_3.setVisibility(View.VISIBLE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अगस्त");title_4.setText("24 - कृष्ण जन्माष्टमी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("सितंबर");title_1.setText("01 - अल-हिजरा, इस्लामी नया साल");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("सितंबर");title_2.setText("02 - गणेश चतुर्थी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("सितंबर");title_3.setText("10 - आशूरा का दिन, मुहर्रम");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setText("सितंबर");title_4.setText("11 - ओणम");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("सितंबर");title_5.setText("15 - विश्वेश्वर्य जयंती");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("सितंबर");title_6.setText("23 - शरद विषुव");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setText("सितंबर");title_7.setText("29 - महाराजा अग्रसेन जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अक्टूबर");title_2.setText("06 - दुर्गा अष्टमी, महा नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अक्टूबर");title_3.setText("08 - दशहरा, माधवाचार्य जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अक्टूबर");title_4.setText("13 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अक्टूबर");title_5.setText("17 - करवा चौथ");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अक्टूबर");title_6.setText("27 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अक्टूबर");title_7.setText("28 - गोवर्धन पूजा");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अक्टूबर");title_8.setText("29 - भाई दूज");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.novenber);
                        month_1.setText("नवंबर");title_1.setText("02 - छठ पूजा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("नवंबर");title_2.setText("10 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("नवंबर");title_3.setText("12 - गुरु नानक जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("नवंबर");title_4.setText("14 - जवाहरलाल नेहरू जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("जनवरी");title_2.setText("02 - गुरु गोविंद सिंह जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("जनवरी");title_3.setText("06 - तैलंग स्वामी जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("जनवरी");title_4.setText("12 - स्वामी विवेकानंद जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("जनवरी");title_5.setText("14 - लोहड़ी");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.VISIBLE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("जनवरी");title_6.setText("15 - पोंगल");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("जनवरी");title_7.setText("17 - विवेकानंद जयंती * संवत");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("जनवरी");title_8.setText("23 - सुभास चंद्र बोस जयंती");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.VISIBLE);title_9.setVisibility(View.VISIBLE);month_9.setText("जनवरी");title_9.setText("26 - गणतंत्र दिवस");purple_9.setVisibility(View.VISIBLE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.VISIBLE);title_10.setVisibility(View.VISIBLE);month_10.setText("जनवरी");title_10.setText("29 - वसंत पंचमी");purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.VISIBLE);
                        month_11.setVisibility(View.VISIBLE);title_11.setVisibility(View.VISIBLE);month_11.setText("जनवरी");title_11.setText("30 - गांधी पुण्यतिथि");purple_11.setVisibility(View.VISIBLE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("फरवरी");title_1.setText("09 - गुरु रविदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("फरवरी");title_2.setText("18 - महर्षि जयानंद सरस्वती जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("फरवरी");title_3.setText("21 - महा शिवरात्रि");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("फरवरी");title_4.setText("25 - रामकृष्ण जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("मार्च");title_1.setText("08 - हज़रत अली का जन्मदिन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("मार्च");title_2.setText("09 - छोटी होली, होलिका दहन, चैतन्य महाप्रभु जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मार्च");title_3.setText("10 - होली");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("मार्च");title_4.setText("12 - शिवाजी जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("मार्च");title_5.setText("20 - पारसी नव वर्ष");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("मार्च");title_6.setText("23 - शहीद दिवस");purple_6.setVisibility(View.VISIBLE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setText("मार्च");title_7.setText("25 - गुड़ी पड़वा, उगादी");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setText("मार्च");title_8.setText("26 - झूलेलाल जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अप्रैल");title_2.setText("02 - राम नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अप्रैल");title_3.setText("06 - महावीर जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अप्रैल");title_4.setText("10 - शुभ शुक्रवार");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.VISIBLE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अप्रैल");title_5.setText("12 - ईस्टर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.VISIBLE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अप्रैल");title_6.setText("13 - सौर नव वर्ष, बैसाखी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.VISIBLE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अप्रैल");title_7.setText("14 - अंबेडकर जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अप्रैल");title_8.setText("18 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.VISIBLE);title_9.setVisibility(View.VISIBLE);month_9.setText("अप्रैल");title_9.setText("28 - शंकराचार्य जयंती, सूरदास जयंती");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("मई");title_1.setText("07 - बुद्ध पूर्णिमा, बुद्ध जयंती, रवींद्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("मई");title_2.setText("22 - जमात उल-विदा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("मई");title_3.setText("24 - ईद अल-फितर (रमजान)");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("मई");title_4.setText("25 - महाराणा प्रताप जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("जून");title_1.setText("05 - संत कबीरदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जून");title_2.setText("23 - रथ यात्रा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("जुलाई");title_1.setText("05 - गुरु पूर्णिमा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जुलाई");title_2.setText("27 - तुलसीदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("जुलाई");title_3.setText("31 - ईद अल-अधा, बकरीद");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("अगस्त");title_1.setText("03 - राखी, रक्षा बंधन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("अगस्त");title_2.setText("11 - कृष्ण जन्माष्टमी * स्मार्टा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("अगस्त");title_3.setText("12 - कृष्ण जन्माष्टमी * इस्कॉन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("अगस्त");title_4.setText("15 - स्वतंत्रता दिवस");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अगस्त");title_5.setText("20 - अल-हिजरा, इस्लामिक न्यूयर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.VISIBLE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अगस्त");title_6.setText("22 - गणेश चतुर्थी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अगस्त");title_7.setText("29 - आशूरा का दिन, मुहर्रम");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अगस्त");title_8.setText("31 - ओणम");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("सितंबर");title_1.setText("15 - विश्वेश्वर्य जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("सितंबर");title_2.setText("22 - शरद विषुव");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अक्टूबर");title_2.setText("17 - महाराजा अग्रसेन जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अक्टूबर");title_3.setText("24 - दुर्गा अष्टमी, महा नवमी");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अक्टूबर");title_4.setText("25 - दशहरा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("अक्टूबर");title_5.setText("26 - माधवाचार्य जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("अक्टूबर");title_6.setText("29 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.VISIBLE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अक्टूबर");title_7.setText("31 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.novenber);
                        month_1.setText("नवंबर");title_1.setText("04 - करवा चौथ");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("नवंबर");title_2.setText("14 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा, जवाहरलाल नेहरू जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("नवंबर");title_3.setText("15 - गोवर्धन पूजा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("नवंबर");title_4.setText("16 - भाई दूज");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("नवंबर");title_5.setText("20 - छठ पूजा");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("नवंबर");title_6.setText("30 - गुरु नानक जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else {
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.novenber);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);

                    }
                }
            }
        });
        ImageButton next = findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (cal_month.get(GregorianCalendar.MONTH) == Calendar.DECEMBER && cal_month.get(GregorianCalendar.YEAR)==2019) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(MainActivity.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }*/
                setNextMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("जनवरी");title_2.setText("12 - स्वामी विवेकानंद जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setText("जनवरी");title_3.setText("13 - गुरु गोविंद सिंह जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("जनवरी");title_4.setText("14 - लोहड़ी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setText("जनवरी");title_5.setText("15 - पोंगल");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("जनवरी");title_6.setText("17 - तैलंग स्वामी जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setText("जनवरी");title_7.setText("23 - सुभास चंद्र बोस जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setText("जनवरी");title_8.setText("26 - गणतंत्र दिवस");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setText("जनवरी");title_9.setText("27 - विवेकानंद जयंती * संवत");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
                        month_10.setText("जनवरी");title_10.setText("30 - गांधी पुण्यतिथि");purple_10.setVisibility(View.VISIBLE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("फरवरी");title_1.setText("10 - वसंत पंचमी");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("फरवरी");title_2.setText("19 - गुरु रविदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("फरवरी");title_3.setText("28 - महर्षि जयानंद सरस्वती जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("मार्च");title_1.setText("04 - महा शिवरात्रि");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("मार्च");title_2.setText("08 - रामकृष्ण जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मार्च");title_3.setText("20 - छोटी होली, होलिका दहन, हज़रत अली का जन्मदिन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("मार्च");title_4.setText("21 - होली, चैतन्य महाप्रभु जयंती, पारसी नववर्ष");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("मार्च");title_5.setText("23 - शिवाजी जयंती, शहीद दिवस");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अप्रैल");title_2.setText("06 - गुड़ी पड़वा, उगादी, झूलेलाल जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अप्रैल");title_3.setText("13 - राम नवमी * स्मार्टा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अप्रैल");title_4.setText("14 - राम नवमी * इस्कॉन, सौर नववर्ष, बैसाखी, अम्बेडकर जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.VISIBLE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("अप्रैल");title_5.setText("17 - महावीर जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अप्रैल");title_6.setText("19 - गुड फ्राइडे");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अप्रैल");title_7.setText("21 - ईस्टर");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अप्रैल");title_8.setText("30 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("मई");title_1.setText("07 - रवीन्द्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("मई");title_2.setText("09 - आदि शंकराचार्य जयंती, सूरदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मई");title_3.setText("18 - बुद्ध पूर्णिमा, बुद्ध जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("मई");title_4.setText("31 - जमात उल-विदा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("जून");title_1.setText("05 - ईद अल-फितर (रमजान)");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("जून");title_2.setText("06 - महाराणा प्रताप जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("जून");title_3.setText("17 - संत कबीरदास जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("जुलाई");title_1.setText("04 - रथ यात्रा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जुलाई");title_2.setText("16 - गुरु पूर्णिमा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("अगस्त");title_1.setText("07 - तुलसीदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("अगस्त");title_2.setText("12 - बकरीद, ईद अल-अधा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("अगस्त");title_3.setText("15 - राखी, रक्षा बंधन, स्वतंत्रता दिवस");purple_3.setVisibility(View.VISIBLE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("अगस्त");title_4.setText("24 - कृष्ण जन्माष्टमी");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("सितंबर");title_1.setText("01 - अल-हिजरा, इस्लामी नया साल");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("सितंबर");title_2.setText("02 - गणेश चतुर्थी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("सितंबर");title_3.setText("10 - आशूरा का दिन, मुहर्रम");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setText("सितंबर");title_4.setText("11 - ओणम");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("सितंबर");title_5.setText("15 - विश्वेश्वर्य जयंती");purple_5.setVisibility(View.VISIBLE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("सितंबर");title_6.setText("23 - शरद विषुव");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("सितंबर");title_7.setText("29 - महाराजा अग्रसेन जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अक्टूबर");title_2.setText("06 - दुर्गा अष्टमी, महा नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अक्टूबर");title_3.setText("08 - दशहरा, माधवाचार्य जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अक्टूबर");title_4.setText("13 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("अक्टूबर");title_5.setText("17 - करवा चौथ");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("अक्टूबर");title_6.setText("27 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setText("अक्टूबर");title_7.setText("28 - गोवर्धन पूजा");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अक्टूबर");title_8.setText("29 - भाई दूज");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.novenber);
                        month_1.setText("नवंबर");title_1.setText("02 - छठ पूजा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("नवंबर");title_2.setText("10 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setText("नवंबर");title_3.setText("12 - गुरु नानक जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("नवंबर");title_4.setText("14 - जवाहरलाल नेहरू जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("जनवरी");title_1.setText("01 - अंग्रेजी नव वर्ष");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("जनवरी");title_2.setText("02 - गुरु गोविंद सिंह जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("जनवरी");title_3.setText("06 - तैलंग स्वामी जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("जनवरी");title_4.setText("12 - स्वामी विवेकानंद जयंती");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("जनवरी");title_5.setText("14 - लोहड़ी");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.VISIBLE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("जनवरी");title_6.setText("15 - पोंगल");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("जनवरी");title_7.setText("17 - विवेकानंद जयंती * संवत");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("जनवरी");title_8.setText("23 - सुभास चंद्र बोस जयंती");purple_8.setVisibility(View.VISIBLE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.VISIBLE);title_9.setVisibility(View.VISIBLE);month_9.setText("जनवरी");title_9.setText("26 - गणतंत्र दिवस");purple_9.setVisibility(View.VISIBLE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.VISIBLE);title_10.setVisibility(View.VISIBLE);month_10.setText("जनवरी");title_10.setText("29 - वसंत पंचमी");purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.VISIBLE);
                        month_11.setVisibility(View.VISIBLE);title_11.setVisibility(View.VISIBLE);month_11.setText("जनवरी");title_11.setText("30 - गांधी पुण्यतिथि");purple_11.setVisibility(View.VISIBLE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("फरवरी");title_1.setText("09 - गुरु रविदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("फरवरी");title_2.setText("18 - महर्षि जयानंद सरस्वती जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("फरवरी");title_3.setText("21 - महा शिवरात्रि");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("फरवरी");title_4.setText("25 - रामकृष्ण जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("मार्च");title_1.setText("08 - हज़रत अली का जन्मदिन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("मार्च");title_2.setText("09 - छोटी होली, होलिका दहन, चैतन्य महाप्रभु जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("मार्च");title_3.setText("10 - होली");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("मार्च");title_4.setText("12 - शिवाजी जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("मार्च");title_5.setText("20 - पारसी नव वर्ष");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("मार्च");title_6.setText("23 - शहीद दिवस");purple_6.setVisibility(View.VISIBLE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("मार्च");title_7.setText("25 - गुड़ी पड़वा, उगादी");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("मार्च");title_8.setText("26 - झूलेलाल जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("अप्रैल");title_1.setText("01 - बैंक की छुट्टी");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अप्रैल");title_2.setText("02 - राम नवमी");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अप्रैल");title_3.setText("06 - महावीर जयंती");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("अप्रैल");title_4.setText("10 - शुभ शुक्रवार");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.VISIBLE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setText("अप्रैल");title_5.setText("12 - ईस्टर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.VISIBLE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setText("अप्रैल");title_6.setText("13 - सौर नव वर्ष, बैसाखी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.VISIBLE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setText("अप्रैल");title_7.setText("14 - अंबेडकर जयंती");purple_7.setVisibility(View.VISIBLE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setText("अप्रैल");title_8.setText("18 - वल्लभाचार्य जयंती");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.VISIBLE);title_9.setVisibility(View.VISIBLE);month_9.setText("अप्रैल");title_9.setText("28 - शंकराचार्य जयंती, सूरदास जयंती");purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.VISIBLE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("मई");title_1.setText("07 - बुद्ध पूर्णिमा, बुद्ध जयंती, रवींद्रनाथ टैगोर जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("मई");title_2.setText("22 - जमात उल-विदा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);dark_red_2.setVisibility(View.GONE);
                        month_3.setText("मई");title_3.setText("24 - ईद अल-फितर (रमजान)");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setText("मई");title_4.setText("25 - महाराणा प्रताप जयंती");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("जून");title_1.setText("05 - संत कबीरदास जयंती");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जून");title_2.setText("23 - रथ यात्रा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("जुलाई");title_1.setText("05 - गुरु पूर्णिमा");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("जुलाई");title_2.setText("27 - तुलसीदास जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("जुलाई");title_3.setText("31 - ईद अल-अधा, बकरीद");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("अगस्त");title_1.setText("03 - राखी, रक्षा बंधन");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("अगस्त");title_2.setText("11 - कृष्ण जन्माष्टमी * स्मार्टा");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("अगस्त");title_3.setText("12 - कृष्ण जन्माष्टमी * इस्कॉन");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("अगस्त");title_4.setText("15 - स्वतंत्रता दिवस");purple_4.setVisibility(View.VISIBLE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अगस्त");title_5.setText("20 - अल-हिजरा, इस्लामिक न्यूयर");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.VISIBLE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अगस्त");title_6.setText("22 - गणेश चतुर्थी");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अगस्त");title_7.setText("29 - आशूरा का दिन, मुहर्रम");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.VISIBLE);title_8.setVisibility(View.VISIBLE);month_8.setText("अगस्त");title_8.setText("31 - ओणम");purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.VISIBLE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("सितंबर");title_1.setText("15 - विश्वेश्वर्य जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("सितंबर");title_2.setText("22 - शरद विषुव");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.VISIBLE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("अक्टूबर");title_1.setText("02 - महात्मा गांधी जयंती");purple_1.setVisibility(View.VISIBLE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setText("अक्टूबर");title_2.setText("17 - महाराजा अग्रसेन जयंती");purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("अक्टूबर");title_3.setText("24 - दुर्गा अष्टमी, महा नवमी");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("अक्टूबर");title_4.setText("25 - दशहरा");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setVisibility(View.VISIBLE);title_5.setVisibility(View.VISIBLE);month_5.setText("अक्टूबर");title_5.setText("26 - माधवाचार्य जयंती");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setVisibility(View.VISIBLE);title_6.setVisibility(View.VISIBLE);month_6.setText("अक्टूबर");title_6.setText("29 - मिलाद-ए-नबी, ईद-ए-मिलाद");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.VISIBLE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.VISIBLE);title_7.setVisibility(View.VISIBLE);month_7.setText("अक्टूबर");title_7.setText("31 - वाल्मीकि जयंती, मीरा बाई जयंती");purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.VISIBLE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.novenber);
                        month_1.setText("नवंबर");title_1.setText("04 - करवा चौथ");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.VISIBLE);
                        month_2.setText("नवंबर");title_2.setText("14 - नरक चतुर्दशी, दिवाली, लक्ष्मी पूजा, जवाहरलाल नेहरू जयंती");purple_2.setVisibility(View.VISIBLE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.VISIBLE);
                        month_3.setText("नवंबर");title_3.setText("15 - गोवर्धन पूजा");purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.VISIBLE);
                        month_4.setText("नवंबर");title_4.setText("16 - भाई दूज");purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.VISIBLE);
                        month_5.setText("नवंबर");title_5.setText("20 - छठ पूजा");purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.VISIBLE);
                        month_6.setText("नवंबर");title_6.setText("30 - गुरु नानक जयंती");purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.VISIBLE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("दिसंबर");title_1.setText("25 - मेरी क्रिसमस");purple_1.setVisibility(View.GONE);dark_green_1.setVisibility(View.GONE);light_red_1.setVisibility(View.VISIBLE);light_green_1.setVisibility(View.GONE);dark_red_1.setVisibility(View.GONE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);purple_2.setVisibility(View.GONE);dark_green_2.setVisibility(View.GONE);light_red_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);dark_red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);purple_3.setVisibility(View.GONE);dark_green_3.setVisibility(View.GONE);light_red_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);dark_red_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);purple_4.setVisibility(View.GONE);dark_green_4.setVisibility(View.GONE);light_red_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);dark_red_4.setVisibility(View.GONE);
                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);purple_5.setVisibility(View.GONE);dark_green_5.setVisibility(View.GONE);light_red_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);dark_red_5.setVisibility(View.GONE);
                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);purple_6.setVisibility(View.GONE);dark_green_6.setVisibility(View.GONE);light_red_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);dark_red_6.setVisibility(View.GONE);
                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);purple_7.setVisibility(View.GONE);dark_green_7.setVisibility(View.GONE);light_red_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);dark_red_7.setVisibility(View.GONE);
                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);purple_8.setVisibility(View.GONE);dark_green_8.setVisibility(View.GONE);light_red_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);dark_red_8.setVisibility(View.GONE);
                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);purple_9.setVisibility(View.GONE);dark_green_9.setVisibility(View.GONE);light_red_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);dark_red_9.setVisibility(View.GONE);
                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);purple_10.setVisibility(View.GONE);dark_green_10.setVisibility(View.GONE);light_red_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);dark_red_10.setVisibility(View.GONE);
                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);purple_11.setVisibility(View.GONE);dark_green_11.setVisibility(View.GONE);light_red_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);dark_red_11.setVisibility(View.GONE);
                    }else {
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.novenber);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                    }
                }
            }
        });
        GridView gridview = findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = IndianCalendar.day_string.get(position);
                ((IndianCalendar) parent.getAdapter()).getPositionList(selectedGridDate, MainActivity.this);
            }

        });

    }

    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(Calendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    @SuppressLint("SetTextI18n")
    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(MainActivity.this);
        dialogs.setContentView(R.layout.theme_popup);
        TextView imgCross = dialogs.findViewById(R.id.close);

        blue = dialogs.findViewById(R.id.blue_ray);
        blue.setOnCheckedChangeListener(this);

        red = dialogs.findViewById(R.id.red_ray);
        red.setOnCheckedChangeListener(this);

        green = dialogs.findViewById(R.id.green_ray);
        green.setOnCheckedChangeListener(this);

        purple = dialogs.findViewById(R.id.purple_ray);
        purple.setOnCheckedChangeListener(this);

        pink = dialogs.findViewById(R.id.pink_ray);
        pink.setOnCheckedChangeListener(this);

        default_color = dialogs.findViewById(R.id.default_ray);
        default_color.setOnCheckedChangeListener(this);

        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogs.dismiss();
            }
        });
        dialogs.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.power) {
            logout();
            return true;
        }
        if (id == R.id.theme){
            //open_popup_window();
            popupWindow();
        }
        if (id == R.id.reminder){
            Intent intent = new Intent(MainActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(MainActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_event){
            Intent intent = new Intent(MainActivity.this, AllEventActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        System.exit(0);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.blue_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = true;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.blue_theme);
            }
            if (buttonView.getId() == R.id.red_ray) {
                blue.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = true;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.red_theme);
            }
            if (buttonView.getId() == R.id.green_ray) {
                red.setChecked(false);
                blue.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = true;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.green_theme);
            }
            if (buttonView.getId() == R.id.purple_ray) {
                red.setChecked(false);
                green.setChecked(false);
                blue.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = true;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.purple_theme);
            }
            if (buttonView.getId() == R.id.pink_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                blue.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = true;isNormal = false;
                main.setBackgroundResource(R.drawable.rose_theme);
            }
            if (buttonView.getId() == R.id.default_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                blue.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = true;

                if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                    main.setBackgroundResource(R.drawable.january);
                    //theme_layout.setBackgroundResource(R.drawable.january);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                    main.setBackgroundResource(R.drawable.february);
                    //theme_layout.setBackgroundResource(R.drawable.february);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                    main.setBackgroundResource(R.drawable.march);
                    //theme_layout.setBackgroundResource(R.drawable.march);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                    main.setBackgroundResource(R.drawable.april);
                    //theme_layout.setBackgroundResource(R.drawable.april);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                    main.setBackgroundResource(R.drawable.may);
                    //theme_layout.setBackgroundResource(R.drawable.may);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                    main.setBackgroundResource(R.drawable.june);
                    //theme_layout.setBackgroundResource(R.drawable.june);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                    main.setBackgroundResource(R.drawable.july);
                    //theme_layout.setBackgroundResource(R.drawable.july);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                    main.setBackgroundResource(R.drawable.august);
                    //theme_layout.setBackgroundResource(R.drawable.august);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                    main.setBackgroundResource(R.drawable.september);
                    //theme_layout.setBackgroundResource(R.drawable.september);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                    main.setBackgroundResource(R.drawable.october);
                    //theme_layout.setBackgroundResource(R.drawable.october);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                    main.setBackgroundResource(R.drawable.novenber);
                    //theme_layout.setBackgroundResource(R.drawable.november);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                    main.setBackgroundResource(R.drawable.december);
                    //theme_layout.setBackgroundResource(R.drawable.december);
                }
            }
        }
    }
}