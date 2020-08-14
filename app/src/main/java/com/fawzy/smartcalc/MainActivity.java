package com.fawzy.smartcalc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    double mValueOne, mValueTwo ;
    double ans = 0, a;
    boolean mAddition, mSubtract, mMultiplication, mDivision, mReminder,
            istpower2ndno, mArithmetic ;
  //  boolean piecheck = false;

    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.cubroot)
    Button cuberoot;
    @BindView(R.id.xfactorialbtn)
    Button xfactorialbtn;
    @BindView(R.id.logbtn)
    Button logbtn;
    @BindView(R.id.epowerbtn)
    Button epowerbtn;
    @BindView(R.id.lnbtn)
    Button lnbtn;
    @BindView(R.id.squarerootbtn)
    Button squarerootbtn;
    @BindView(R.id.istpower2nd)
    Button istpower2nd;
    @BindView(R.id.sinbtn)
    Button sinbtn;
    @BindView(R.id.cosbtn)
    Button cosbtn;
    @BindView(R.id.tanbtn)
    Button tanbtn;
    @BindView(R.id.onedividebtn)
    Button onedividebtn;
    @BindView(R.id.sinhbtn)
    Button sinhbtn;
    @BindView(R.id.coshbtn)
    Button coshbtn;
    @BindView(R.id.tanhbtn)
    Button tanhbtn;
    @BindView(R.id.squarebtn)
    Button squarebtn;
    @BindView(R.id.byten)
    Button byten;
    @BindView(R.id.plusorplus)
    Button plusorminus;
    @BindView(R.id.expbtn)
    Button expbtn;
    @BindView(R.id.percentbtn)
    Button percentbtn;
    @BindView(R.id.xcubebtn)
    Button xcubebtn;
    @BindView(R.id.sevenbtn)
    Button sevenbtn;
    @BindView(R.id.eightbtn)
    Button eightbtn;
    @BindView(R.id.ninebtn)
    Button ninebtn;
    @BindView(R.id.deletebtn)
    Button deletebtn;
    @BindView(R.id.clearrbtn)
    Button clearrbtn;
    @BindView(R.id.fourbtn)
    Button fourbtn;
    @BindView(R.id.fivebtn)
    Button fivebtn;
    @BindView(R.id.sixbtn)
    Button sixbtn;
    @BindView(R.id.plusbtn)
    Button plusbtn;
    @BindView(R.id.minusbtn)
    Button minusbtn;
    @BindView(R.id.onebtn)
    Button onebtn;
    @BindView(R.id.twobtn)
    Button twobtn;
    @BindView(R.id.threebtn)
    Button threebtn;
    @BindView(R.id.multiplybtn)
    Button multiplybtn;
    @BindView(R.id.dividebtn)
    Button dividebtn;
    @BindView(R.id.zerobtn)
    Button zerobtn;
    @BindView(R.id.pointbtn)
    Button pointbtn;
    @BindView(R.id.piebtn)
    Button piebtn;
    @BindView(R.id.ansbtn)
    Button ansbtn;
    @BindView(R.id.equalbtn)
    Button equalbtn;
    @BindView(R.id.spinner)
    Spinner spinner;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        View decorview = getWindow().getDecorView();
        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
         mAdView = findViewById(R.id.adView);
         AdRequest adRequest = new AdRequest.Builder().build();
         mAdView.loadAd(adRequest);
         mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            //    Toast.makeText(MainActivity.this, "loaded", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
             //   Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
              //  Toast.makeText(MainActivity.this, "opened", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }
            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }
            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        clearrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("");
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str;
                    str = txt.getText().toString();
                    str = str.substring(0, str.length() - 1);
                    txt.setText(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        pointbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    txt.setText(txt.getText().toString() + ".");
                    mArithmetic = true ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        zerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "0");
            }
        });

        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "1");
            }
        });

        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "2");
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "3");
            }
        });

        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "4");
            }
        });

        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "5");
            }
        });

        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "6");
            }
        });

        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "7");
            }
        });

        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "8");
            }
        });

        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + "9");
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mValueOne = Float.parseFloat(txt.getText().toString());
                    txt.setText("");
                    mAddition = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(txt.getText().toString());
                    txt.setText("");
                    mSubtract = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(txt.getText().toString());
                    mMultiplication = true;
                    txt.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Double.parseDouble(txt.getText().toString());
                    mDivision = true;
                    txt.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        final ArrayList<String> sp1 = new ArrayList<>();
        sp1.add("");
        sp1.add("299792458");
        sp1.add("9.8");
        sp1.add("0.511");
        sp1.add("96490");
        sp1.add("8.314");
        sp1.add("939.565");
        sp1.add("1838.68");
        sp1.add("1.0014");
        sp1.add("1836.15");
        sp1.add("299790000");
        final ArrayList<String>sp = new ArrayList<>();
        sp.add("");
        sp.add("Speed of Light");
        sp.add("Acceleration due to gravity");
        sp.add("Electron mass energy");
        sp.add("Faraday constant");
        sp.add("Gas constant");
        sp.add("Neutron mass energy (MeV)");
        sp.add("Neutron-electron mass ratio");
        sp.add("Neutron-proton mass ratio");
        sp.add("proton-electron mass ratio");
        sp.add("Speed of Light in Vacuum");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sp);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt.setText(""+sp1.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        xfactorialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = factorial(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans = Double.parseDouble(txt.getText().toString());
            }
        });

        squarebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.pow(Double.parseDouble(txt.getText().toString()), 2);
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans = Double.parseDouble(txt.getText().toString());
            }
        });

        xcubebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a= Math.pow(Double.parseDouble(txt.getText().toString()),3);
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                }catch (Exception e){
                    e.printStackTrace();
                }
                ans = Double.parseDouble(txt.getText().toString());
            }
        });

        squarerootbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sqrt(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        cuberoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.cbrt(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        onedividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = 1/Double.parseDouble(txt.getText().toString());
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        epowerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double n= Double.parseDouble(txt.getText().toString());
                    Double exp =  Math.pow(2.718281828, n);
                    txt.setText(exp+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        tanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.tan(Math.toRadians(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        cosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.cos(Math.toRadians(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans = Double.parseDouble(txt.getText().toString());
            }
        });

        sinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sin(Math.toRadians(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        tanhbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.toDegrees(Math.atan(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        coshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.toDegrees(Math.acos(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        sinhbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.toDegrees(Math.asin(Double.parseDouble(txt.getText().toString())));
                    txt.setText("");
                    txt.setText(txt.getText().toString()+a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.log10(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        lnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a= Math.log(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.abs(Double.parseDouble(txt.getText().toString()));
                    txt.setText("");
                    txt.setText(txt.getText().toString() + a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

        piebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    txt.setText(Math.PI + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ansbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    txt.setText(ans + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        plusorminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                  double a = Double.parseDouble(txt.getText().toString()) ;
                  txt.setText(a*-1+"");
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        });

        byten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(txt.getText()+"")*10 ;
                    istpower2ndno = true;
                    txt.setText(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        istpower2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(txt.getText() + "");
                    istpower2ndno = true;
                    txt.setText(null);
                } catch (Exception e) {
                    e.printStackTrace();
                } }
        });

        percentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueOne = Float.parseFloat(txt.getText() + "");
                    mReminder = true;
                    txt.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        equalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (mAddition == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        txt.setText(mValueOne + mValueTwo+"");
                        mAddition=false;
                    }
                    if (mSubtract == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        txt.setText(mValueOne-mValueTwo+"");
                        mSubtract =  false ;
                    }
                    if (mMultiplication == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        txt.setText(mValueOne*mValueTwo+"");
                        mMultiplication = false ;
                    }
                    if (mDivision == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        txt.setText(mValueOne/mValueTwo+"");
                        mDivision = false ;
                    }
                    if (mReminder == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        txt.setText(mValueOne % mValueTwo +"");
                        mReminder=false;
                    }
                    if (istpower2ndno == true){
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        int exp = (int) Math.pow(mValueOne, mValueTwo);
                        txt.setText(exp+"");
                        istpower2ndno=false;
                    }
                    if (istpower2ndno == true) {
                        mValueTwo = Float.parseFloat(txt.getText().toString());
                        int exp = (int) Math.pow(mValueOne, mValueTwo);
                        txt.setText(exp+"");
                        istpower2ndno=false;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                ans=Double.parseDouble(txt.getText().toString());
            }
        });

    }

    public double factorial(double a) {
        if (a >= 2) {
            return a * factorial(a - 1);
        } else {
            return 1;
        }
    }




}
