package de.fhbielefeld.swe.stundenplan_tabbed;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayList<Fach> Katalog = new ArrayList<>();
    public ArrayList<Fach> Montag = new ArrayList<>();
    public ArrayList<Fach> Dienstag = new ArrayList<>();
    public ArrayList<Fach> Mittwoch = new ArrayList<>();
    public ArrayList<Fach> Donnerstag = new ArrayList<>();
    public ArrayList<Fach> Freitag = new ArrayList<>();

    public void addFach(String s, String n, String t, String b, String e, String r, String d, String k, boolean ak)
    {
        Fach tmpfach = new Fach(s, n, t, b, e, r, d, k, ak);
        Katalog.add(tmpfach);
    }

    private void writeBackup(){
        try {
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED))
            {
                Environment.getExternalStorageDirectory();
                File externalSD = Environment.getExternalStorageDirectory();
                File specialExternalDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            }

            SharedPreferences sf = getPreferences(0);
            SharedPreferences.Editor editor = sf.edit();
            String tmpstring;
            for (int i = 0; i < Katalog.size(); i++) {
                tmpstring = Integer.toString(i);
                editor.putString(tmpstring,Katalog.get(i).CSVtoString());
                editor.commit();
                Log.d("writeSharedPref",  sf.getString(tmpstring,"Keiner!"));
            }
            Log.d("SharedPref: ", sf.getString("0", "Failed!"));
            Log.d("SharedPref: ", sf.getString("1", "Failed!"));
        }
        catch(Exception ex) {
            Log.wtf("InternerSpeicher", "Fehler beim Lesen", ex);
        }
    }

    private void readCSV() {
        InputStream is = getResources().openRawResource(R.raw.ini_ws17);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8") ));

        String line = "";
        try {

            // Ignore first Line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity", "Line: " + line);
                // Split by ';'
                String[] tokens = line.split(";");

                //Read the data
                addFach(tokens[0], tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7], false);
                Log.d("ReadStundenplan", "Just created: " + Katalog.get(Katalog.size() - 1));

                //
            }
        }
        catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }

    private void readBackup() {
        SharedPreferences sf = getSharedPreferences("Backup", 0);
        Katalog.clear();
        int i = 0;
        String endstring = "Initialized";
        boolean check;
        Log.d("Vor While Schleife", "Test: " + endstring);
        while (true)
        {
            endstring = sf.getString(Integer.toString(i), "Keiner!");
            if (endstring.equals("Keiner!"))
            {
                // Log.d("Abbruchbedingung", "Endstring: " + endstring);
                break;
            }
            else {
                String[] tokens = endstring.split(";");
                check = Boolean.valueOf(tokens[8]);
                addFach(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], check);
                Log.d("ReadSharedPref", "Just created: " + Katalog.get(Katalog.size() - 1));
                i++;
                Log.d("In While Schleife", "Zählvariable " + i);
            }
        }
    }

    private void createStundenplan()
    {
        String cmp;
        Montag.clear();
        Dienstag.clear();
        Mittwoch.clear();
        Donnerstag.clear();
        Freitag.clear();
        for (int i = 0; i<Katalog.size();i++)
        {
               cmp = Katalog.get(i).getTag();
               if (cmp.equals("Montag"))
               {
                   Montag.add(Katalog.get(i));
               }
               else if (cmp.equals("Dienstag"))
               {
                   Dienstag.add(Katalog.get(i));
               }
               else if (cmp.equals("Mittwoch"))
               {
                   Mittwoch.add(Katalog.get(i));
               }
               else if (cmp.equals("Donnerstag"))
               {
                   Donnerstag.add(Katalog.get(i));
               }
               else if (cmp.equals("Freitag"))
               {
                   Freitag.add(Katalog.get(i));
               }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Mon"));
        tabLayout.addTab(tabLayout.newTab().setText("Die"));
        tabLayout.addTab(tabLayout.newTab().setText("Mit"));
        tabLayout.addTab(tabLayout.newTab().setText("Don"));
        tabLayout.addTab(tabLayout.newTab().setText("Fre"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
       // tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}