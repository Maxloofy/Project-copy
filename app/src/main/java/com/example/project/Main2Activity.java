package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class Main2Activity extends AppCompatActivity {
    Spinner SpFirst, SpSecond;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        final Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"الكويت","السعودية","العراق"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);





        SpFirst = findViewById(R.id.SpFirst);
        final Spinner SpSecond = findViewById(R.id.SpSecond);

        SpFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = SpFirst.getSelectedItem().toString();
                int idSpinner = getResources().getIdentifier(name, "array", Main2Activity.this.getPackageName());
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(idSpinner));
                SpSecond.setAdapter(spinnerArrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        ImageView imageView = findViewById(R.id.imageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                animationDrawable.start();




         Button b3 = findViewById(R.id.button3);



         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String text = SpSecond.getSelectedItem().toString();
                 String tetxt1 = dropdown.getSelectedItem().toString();

                 if(text.equals("بناء مساجد")&& tetxt1.equals("الكويت")){
                     Intent intent = new Intent(Main2Activity.this, Test.class);
                     startActivity(intent);
                 }if(text.equals("زراعة الاعضاء")&& tetxt1.equals("الكويت")){
                     Intent intent1 = new Intent(Main2Activity.this, test2.class);
                     startActivity(intent1);
                 }if(text.equals("بناء مدارس و مراكز تعليم")&& tetxt1.equals("الكويت")){
                     Intent intent2 = new Intent(Main2Activity.this, test3.class);
                     startActivity(intent2);
                 }if(text.equals("تحفيظ القرآن")&& tetxt1.equals("الكويت")){
                     Intent intent3 = new Intent(Main2Activity.this, test4.class);
                     startActivity(intent3);
                 }if(text.equals("زراعة الأطراف الصناعية")&& tetxt1.equals("الكويت")){
                     Intent intent4 = new Intent(Main2Activity.this, test5.class);
                     startActivity(intent4);
                 }if(text.equals("توفير الأدوية و اللقاحات")&& tetxt1.equals("الكويت")){
                     Intent intent5 = new Intent(Main2Activity.this, test6.class);
                     startActivity(intent5);
                 }if(text.equals("ترميم مساجد")&& tetxt1.equals("الكويت")){
                     Intent intent6 = new Intent(Main2Activity.this, test7.class);
                     startActivity(intent6);
                 }if(text.equals("رعاية المساجد التراثة")&& tetxt1.equals("الكويت")){
                     Intent intent7 = new Intent(Main2Activity.this, test8.class);
                     startActivity(intent7);
                 }if(text.equals("طباعة الكتب التعليمية")&& tetxt1.equals("الكويت")){
                     Intent intent8 = new Intent(Main2Activity.this, test9.class);
                     startActivity(intent8);
                 }if(text.equals("تسجيل الطلبة في الجامعات")&& tetxt1.equals("الكويت")){
                     Intent intent9 = new Intent(Main2Activity.this, test10.class);
                     startActivity(intent9);
                 }if(text.equals("طباعة المصاحف")&& tetxt1.equals("الكويت")){
                     Intent intent10 = new Intent(Main2Activity.this, test11.class);
                     startActivity(intent10);
                 }if(text.equals("علوم القرآن")&& tetxt1.equals("الكويت")){
                     Intent intent11 = new Intent(Main2Activity.this, test12.class);
                     startActivity(intent11);
                 }

             }
         });















        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("الصفحة الرئيسية").withIcon(R.drawable.ic_home_black_24dp);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("الملف الشخصي").withIcon(R.drawable.ic_person_black_24dp);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("الاعدادات").withIcon(R.drawable.ic_settings_black_24dp);
        Toolbar tool = findViewById(R.id.toolbar2);
        new DrawerBuilder().withActivity(this)
                .withToolbar(tool)
                .addDrawerItems(item1)
                .addDrawerItems(item2)
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(item3)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem.getIdentifier() == 2) {
                            Intent i = new Intent(Main2Activity.this, Profile.class);
                            startActivity(i);
                        }
                        if(drawerItem.getIdentifier() == 3) {
                            Intent i = new Intent(Main2Activity.this, Logout.class);
                            startActivity(i);
                        }
                        return false;
                    }
                })
                .build();























    }

}
