package com.mschultheiss.charmeapp.Helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import com.mschultheiss.charmeapp.R;

import org.json.JSONArray;

/**
 * Created by ms on 10/8/15.
 */
public class GroupTools {

    public static int getImageByReceivers(JSONArray receivers, Context context) {

        try {

            String a = "";
            for (int i = 0; i<receivers.length(); i++)
                a += receivers.getString(i);


            int[] numImages = {0, 0, 4, 2,4, 1,1}; // The available images for each peope count

            int receiverNumber = receivers.length();

            if (receiverNumber>numImages.length)
                return R.drawable.i91;
            else
            {

                int hah = a.hashCode()%numImages[receivers.length()];
                if (hah<0)
                    hah=hah*-1;
                hah+=1;


                String index = String.valueOf(receivers.length())+String.valueOf(hah);


                Resources resources = context.getResources();
                 int resourceId = resources.getIdentifier("i"+index, "drawable",
                        context.getPackageName());

                if (resourceId == 0)
                    resourceId = R.drawable.i91;

                return resourceId;
            }



        }
        catch(Exception x) {
            System.out.println(x.toString());
            return R.drawable.i91;
        }

    }

    public static String getNameByReceivers(JSONArray names) {

        // TODO: Do not display my own name!
        
        try {
            String all = "";

            for (int i = 0; i < names.length(); i++) {

                if (i<3) {
                    String s =  names.getJSONObject(i).getString("name");
                    String firstWord = null; // Only first name
                    if(s.contains(" ")){
                        s= s.substring(0, s.indexOf(" "));
                    }
                    all += s;
                    if (i < 2 && i<(names.length()-1))
                        all = all + ", ";
                }

            }

            if (names.length() > 2)
                all += " and more";

            return all;
        }

        catch(Exception x) {
            System.out.println(x.toString());

            return "";
        }




    }
}