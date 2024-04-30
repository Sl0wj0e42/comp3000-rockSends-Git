package com.example.rocksends11_nodatabase_makeingitlooknice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class routesPage extends AppCompatActivity {

    final ArrayList<String> climbNamesNCodes = new ArrayList<String>();
    final ArrayList<Bitmap> imagesBitmap = new ArrayList<Bitmap>();
    Bitmap glass_bottom_rock_main, cleverdondismount, woodlousestatic, lefttorighttraverse_orrighttolefttraverse__, cleverdondive, fastnet_lookout_main, direct, fastnettodraingullytraverse_part1_, rolexclimb, sladesleopard, drain_gully_area_main, fastnettodraingullyterverse_part2_, leftwall, overhangcentral, overhangcentral_sitstart, overhangtraverse, rightarete, rightarete_crouchingstart, slabs_area_main, deathorglory, fastnettodraingullytraverse_part3_, gloryarete, groove, gloryordeath, leftofarete, leftofarete_veriation, sealegs;

    Button routeBtn, mapBtn, logOutBtn;
    TableRow routeRow;
    TableLayout stk;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_page);
        mapBtn = findViewById(R.id.mapButton);

        mapBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_one));
        mapBtn.setTextColor(getResources().getColor(R.color.honnyOrange));

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dashboard = new Intent(routesPage.this, mapPage.class);
                startActivity(Dashboard);
            }
        });

        logOutBtn = findViewById(R.id.logOut);

        logOutBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_one));
        logOutBtn.setTextColor(getResources().getColor(R.color.honnyOrange));

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dashboard = new Intent(routesPage.this, MainActivity.class);
                startActivity(Dashboard);
            }
        });

        id = getIntent().getExtras().getString("tryPullThis");

        if (id.equals("7890")) {
            addGlassBottomRockMain(climbNamesNCodes);
        } else if(id.equals("6789")){
            addFastnetLookoutMain(climbNamesNCodes);
        } else if(id.equals("5678")){
            addDrainGullyArea(climbNamesNCodes);
        } else if(id.equals("4567")){
            demo(climbNamesNCodes);
        }
        else{
            Toast.makeText(this, "Error: " + id + " isnt ready yet", Toast.LENGTH_SHORT).show();
        }
        addtable(climbNamesNCodes);
    }

    public ArrayList addGlassBottomRockMain(ArrayList<String> climbNamesNCodes){
        ImageView imageview1 = new ImageView(this), imageView2 = new ImageView(this), imageview3 = new ImageView(this), imageview4 = new ImageView(this), imageview5 = new ImageView(this);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        glass_bottom_rock_main = BitmapFactory.decodeResource(getResources(), R.drawable.glass_bottom_rock_main);
        cleverdondismount = BitmapFactory.decodeResource(getResources(), R.drawable.cleverdondismount);
        woodlousestatic = BitmapFactory.decodeResource(getResources(), R.drawable.woodlousestatic);
        lefttorighttraverse_orrighttolefttraverse__ = BitmapFactory.decodeResource(getResources(), R.drawable.lefttorighttraverse_orrighttolefttraverse__);
        cleverdondive = BitmapFactory.decodeResource(getResources(), R.drawable.cleverdondive);

        imageview1.setImageBitmap(Bitmap.createScaledBitmap(glass_bottom_rock_main, 1500, 1000, false));
        imageView2.setImageBitmap(Bitmap.createScaledBitmap(cleverdondismount, 1500, 1000, false));
        imageview3.setImageBitmap(Bitmap.createScaledBitmap(woodlousestatic, 1500, 1000, false));
        imageview4.setImageBitmap(Bitmap.createScaledBitmap(lefttorighttraverse_orrighttolefttraverse__, 1500, 1000, false));
        imageview5.setImageBitmap(Bitmap.createScaledBitmap(cleverdondive, 1500, 1000, false));

        int imageView1Id = 1234, imageView2Id = 2345, imageView3Id = 3456, imageView4Id = 4567, imageView5Id = 5678;

        imageview1.setId(imageView1Id);
        imageView2.setId(imageView2Id);
        imageview3.setId(imageView3Id);
        imageview4.setId(imageView4Id);
        imageview5.setId(imageView5Id);

        climbNamesNCodes.add(0, "cleverdondive," + cleverdondive.toString() + "," + imageView5Id);
        climbNamesNCodes.add(1, "cleverdondismount," + cleverdondismount.toString() + "," + imageView2Id);
        climbNamesNCodes.add(2, "woodlousestatic," + woodlousestatic.toString() + "," + imageView3Id);
        climbNamesNCodes.add(3, "left to right traverse(or right to left traverse)," + lefttorighttraverse_orrighttolefttraverse__.toString() + "," + imageView4Id);

        relativeLayout.addView(imageview1, layoutParams);
        relativeLayout.addView(imageView2, layoutParams);
        relativeLayout.addView(imageview3, layoutParams);
        relativeLayout.addView(imageview4, layoutParams);
        relativeLayout.addView(imageview5, layoutParams);

        return climbNamesNCodes;
    }

    public ArrayList addFastnetLookoutMain(ArrayList<String> climbNamesNCodes){
        ImageView imageview1 = new ImageView(this), imageView2 = new ImageView(this), imageview3 = new ImageView(this), imageview4 = new ImageView(this), imageview5 = new ImageView(this);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        fastnet_lookout_main = BitmapFactory.decodeResource(getResources(), R.drawable.fastnet_lookout_main);
        direct = BitmapFactory.decodeResource(getResources(), R.drawable.direct);
        fastnettodraingullytraverse_part1_ = BitmapFactory.decodeResource(getResources(), R.drawable.fastnettodraingullytraverse_part1_);
        rolexclimb = BitmapFactory.decodeResource(getResources(), R.drawable.rolexclimb);
        sladesleopard = BitmapFactory.decodeResource(getResources(), R.drawable.sladesleopard);

        imageview1.setImageBitmap(Bitmap.createScaledBitmap(fastnet_lookout_main, 1500, 1000, false));
        imageView2.setImageBitmap(Bitmap.createScaledBitmap(direct, 1500, 1000, false));
        imageview3.setImageBitmap(Bitmap.createScaledBitmap(fastnettodraingullytraverse_part1_, 1500, 1000, false));
        imageview4.setImageBitmap(Bitmap.createScaledBitmap(rolexclimb, 1500, 1000, false));
        imageview5.setImageBitmap(Bitmap.createScaledBitmap(sladesleopard, 1500, 1000, false));

        int imageView1Id = 1234, imageView2Id = 2345, imageView3Id = 3456, imageView4Id = 4567, imageView5Id = 5678;

        imageview1.setId(imageView1Id);
        imageView2.setId(imageView2Id);
        imageview3.setId(imageView3Id);
        imageview4.setId(imageView4Id);
        imageview5.setId(imageView5Id);

        climbNamesNCodes.add(0, "Direct," + direct.toString() + "," + imageView5Id);
        climbNamesNCodes.add(1, "Fast Net To Drain Gully Traverse(Part 1)," + fastnettodraingullytraverse_part1_.toString() + "," + imageView2Id);
        climbNamesNCodes.add(2, "Rolex Climb," + rolexclimb.toString() + "," + imageView3Id);
        climbNamesNCodes.add(3, "Slades Leopard," + sladesleopard.toString() + "," + imageView4Id);

        relativeLayout.addView(imageview1, layoutParams);
        relativeLayout.addView(imageView2, layoutParams);
        relativeLayout.addView(imageview3, layoutParams);
        relativeLayout.addView(imageview4, layoutParams);
        relativeLayout.addView(imageview5, layoutParams);

        return climbNamesNCodes;
    }

    public ArrayList addDrainGullyArea(ArrayList<String> climbNamesNCodes){
        ImageView imageview1 = new ImageView(this), imageView2 = new ImageView(this), imageview3 = new ImageView(this), imageview4 = new ImageView(this), imageview5 = new ImageView(this), imageview6 = new ImageView(this), imageview7 = new ImageView(this), imageview8 = new ImageView(this);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        drain_gully_area_main = BitmapFactory.decodeResource(getResources(), R.drawable.drain_gully_area_main);
        fastnettodraingullyterverse_part2_ = BitmapFactory.decodeResource(getResources(), R.drawable.fastnettodraingullyterverse_part2_);
        leftwall = BitmapFactory.decodeResource(getResources(), R.drawable.leftwall);
        overhangcentral = BitmapFactory.decodeResource(getResources(), R.drawable.overhangcentral);
        overhangcentral_sitstart = BitmapFactory.decodeResource(getResources(), R.drawable.overhangcentral_sitstart);
        overhangtraverse = BitmapFactory.decodeResource(getResources(), R.drawable.overhangtraverse);
        rightarete = BitmapFactory.decodeResource(getResources(), R.drawable.rightarete);
        rightarete_crouchingstart = BitmapFactory.decodeResource(getResources(), R.drawable.rightarete_crouchingstart);

        imageview1.setImageBitmap(Bitmap.createScaledBitmap(drain_gully_area_main, 1500, 1000, false));
        imageView2.setImageBitmap(Bitmap.createScaledBitmap(fastnettodraingullyterverse_part2_, 1500, 1000, false));
        imageview3.setImageBitmap(Bitmap.createScaledBitmap(leftwall, 1500, 1000, false));
        imageview4.setImageBitmap(Bitmap.createScaledBitmap(overhangcentral, 1500, 1000, false));
        imageview5.setImageBitmap(Bitmap.createScaledBitmap(overhangcentral_sitstart, 1500, 1000, false));
        imageview6.setImageBitmap(Bitmap.createScaledBitmap(overhangtraverse, 1500, 1000, false));
        imageview7.setImageBitmap(Bitmap.createScaledBitmap(rightarete, 1500, 1000, false));
        imageview8.setImageBitmap(Bitmap.createScaledBitmap(rightarete_crouchingstart, 1500, 1000, false));


        int imageView1Id = 1234, imageView2Id = 2345, imageView3Id = 3456, imageView4Id = 4567, imageView5Id = 5678, imageView6Id = 6789, imageView7Id = 7890, imageView8Id = 8901;

        imageview1.setId(imageView1Id);
        imageView2.setId(imageView2Id);
        imageview3.setId(imageView3Id);
        imageview4.setId(imageView4Id);
        imageview5.setId(imageView5Id);
        imageview6.setId(imageView6Id);
        imageview7.setId(imageView7Id);
        imageview8.setId(imageView8Id);

        climbNamesNCodes.add(0, "Fastnet To Drain Gully Terverse (Part 2)," + fastnettodraingullyterverse_part2_.toString() + "," + imageView2Id);
        climbNamesNCodes.add(1, "Left Wall," + leftwall.toString() + "," + imageView3Id);
        climbNamesNCodes.add(2, "Overhang Central," + overhangcentral.toString() + "," + imageView4Id);
        climbNamesNCodes.add(3, "Overhang Central (Sit Start)," + overhangcentral_sitstart.toString() + "," + imageView5Id);
        climbNamesNCodes.add(4, "Overhang Traverse," + overhangtraverse.toString() + "," + imageView6Id);
        climbNamesNCodes.add(5, "Right Arete," + rightarete.toString() + "," + imageView7Id);
        climbNamesNCodes.add(6, "Right Arete (Crouching Start)," + rightarete_crouchingstart.toString() + "," + imageView8Id);

        relativeLayout.addView(imageview1, layoutParams);
        relativeLayout.addView(imageView2, layoutParams);
        relativeLayout.addView(imageview3, layoutParams);
        relativeLayout.addView(imageview4, layoutParams);
        relativeLayout.addView(imageview5, layoutParams);
        relativeLayout.addView(imageview6, layoutParams);
        relativeLayout.addView(imageview7, layoutParams);
        relativeLayout.addView(imageview8, layoutParams);

        return climbNamesNCodes;
    }

    public ArrayList demo(ArrayList<String> climbNamesNCodes){
        ImageView imageview1 = new ImageView(this), imageView2 = new ImageView(this), imageview3 = new ImageView(this), imageview4 = new ImageView(this), imageview5 = new ImageView(this), imageview6 = new ImageView(this), imageview7 = new ImageView(this), imageview8 = new ImageView(this), imageview9 = new ImageView(this);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        slabs_area_main = BitmapFactory.decodeResource(getResources(), R.drawable.slabs_area_main);
        deathorglory = BitmapFactory.decodeResource(getResources(), R.drawable.deathorglory);
        fastnettodraingullytraverse_part3_ = BitmapFactory.decodeResource(getResources(), R.drawable.fastnettodraingullytraverse_part3_);
        gloryarete = BitmapFactory.decodeResource(getResources(), R.drawable.gloryarete);
        groove = BitmapFactory.decodeResource(getResources(), R.drawable.groove);
        gloryordeath = BitmapFactory.decodeResource(getResources(), R.drawable.gloryordeath);
        leftofarete = BitmapFactory.decodeResource(getResources(), R.drawable.leftofarete);
        leftofarete_veriation = BitmapFactory.decodeResource(getResources(), R.drawable.leftofarete_veriation);
        sealegs = BitmapFactory.decodeResource(getResources(), R.drawable.sealegs);

        imageview1.setImageBitmap(Bitmap.createScaledBitmap(slabs_area_main, 1500, 1000, false));
        imageView2.setImageBitmap(Bitmap.createScaledBitmap(deathorglory, 1500, 1000, false));
        imageview3.setImageBitmap(Bitmap.createScaledBitmap(gloryordeath, 1500, 1000, false));
        imageview4.setImageBitmap(Bitmap.createScaledBitmap(gloryarete, 1500, 1000, false));
        imageview5.setImageBitmap(Bitmap.createScaledBitmap(fastnettodraingullytraverse_part3_, 1500, 1000, false));
        imageview6.setImageBitmap(Bitmap.createScaledBitmap(groove, 1500, 1000, false));
        imageview7.setImageBitmap(Bitmap.createScaledBitmap(leftofarete, 1500, 1000, false));
        imageview8.setImageBitmap(Bitmap.createScaledBitmap(leftofarete_veriation, 1500, 1000, false));
        imageview9.setImageBitmap(Bitmap.createScaledBitmap(sealegs, 1500, 1000, false));

        int imageView1Id = 1234, imageView2Id = 2345, imageView3Id = 3456, imageView4Id = 4567, imageView5Id = 5678, imageView6Id = 6789, imageView7Id = 7890, imageView8Id = 8901, imageView9Id = 9012;

        imageview1.setId(imageView1Id);
        imageView2.setId(imageView2Id);
        imageview3.setId(imageView3Id);
        imageview4.setId(imageView4Id);
        imageview5.setId(imageView5Id);
        imageview6.setId(imageView6Id);
        imageview7.setId(imageView7Id);
        imageview8.setId(imageView8Id);
        imageview9.setId(imageView9Id);

        climbNamesNCodes.add(0, "Death Or Glory," + deathorglory.toString() + "," + imageView2Id);
        climbNamesNCodes.add(1, "Glory Or Death," + gloryordeath.toString() + "," + imageView3Id);
        climbNamesNCodes.add(2, "Glory Arete," + gloryarete.toString() + "," + imageView4Id);
        climbNamesNCodes.add(3, "Fastnet To Drain Gully Traverse (Part 3)," + fastnettodraingullytraverse_part3_.toString() + "," + imageView5Id);
        climbNamesNCodes.add(4, "Groove," + groove.toString() + "," + imageView6Id);
        climbNamesNCodes.add(5, "Left Of Arete," + leftofarete.toString() + "," + imageView7Id);
        climbNamesNCodes.add(6, "Left Of Arete (Veriation)," + leftofarete_veriation.toString() + "," + imageView8Id);
        climbNamesNCodes.add(6, "Sea Legs," + sealegs.toString() + "," + imageView8Id);

        relativeLayout.addView(imageview1, layoutParams);
        relativeLayout.addView(imageView2, layoutParams);
        relativeLayout.addView(imageview3, layoutParams);
        relativeLayout.addView(imageview4, layoutParams);
        relativeLayout.addView(imageview5, layoutParams);
        relativeLayout.addView(imageview6, layoutParams);
        relativeLayout.addView(imageview7, layoutParams);
        relativeLayout.addView(imageview8, layoutParams);
        relativeLayout.addView(imageview9, layoutParams);

        return climbNamesNCodes;
    }

    public ArrayList addtable(ArrayList<String> climbNamesNCodes){
        stk = (TableLayout) findViewById(R.id.table_main);

        int hold = climbNamesNCodes.size();

        for(int i = 0; i<climbNamesNCodes.size(); i++){
            routeRow = new TableRow(this);

            String[] climbingRoutes = climbNamesNCodes.get(i).split(",");

            routeBtn = new Button(this);
            routeBtn.setText(" "+climbingRoutes[0]+" ");
            final String routeBtnStr = climbingRoutes[2];
            routeBtn.setGravity(Gravity.CENTER);
            routeBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_one));
            routeBtn.setTextColor(getResources().getColor(R.color.honnyOrange));

            routeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    climbingRouteVisibality(routeBtnStr);

                }
            });

            routeRow.addView(routeBtn);

            stk.addView(routeRow);
        }

        return climbNamesNCodes;
    }

    public void climbingRouteVisibality(String climbingRouteId){
        try {
            int idInt = Integer.parseInt(climbingRouteId);
            //int climbingRoutesId = Integer.parseInt(climbingRoutes[2]);
            ImageView iv = findViewById(idInt);

            if (iv.getVisibility() == View.INVISIBLE) {
                iv.setVisibility(View.VISIBLE);
            } else {
                iv.setVisibility(View.INVISIBLE);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error: " + climbingRouteId + " is unknown", Toast.LENGTH_SHORT).show();
        }
    }
}