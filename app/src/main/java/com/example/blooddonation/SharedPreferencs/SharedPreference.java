package com.example.blooddonation.SharedPreferencs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedPreference {

    private static final String PREF_NAME = "PREFOFBRIDGE";
    private static final String USER_IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USER_ID = "UserId";
    public static final String KEY_USERNAME = "UserName";
    public static final String KEY_USER_EMAIL = "UserEmail";
    public static final String KEY_USER_PASSWORD = "UserPass";
    public static final String KEY_USER_CONFIRM_PASSWORD = "UserConfirmPass";
    public static final String KEY_MOBILE = "UserMobile";
    public static final String KEY_ALTER_MOBILE = "UserAltMobile";
    public static final String KEY_USER_SOCIAL = "UserSocial";
    public static final String KEY_USER_BLOOD = "UserBlood";
    public static final String KEY_USER_WEIGHT = "UserWeight";
    public static final String KEY_GENDER = "UserGender";
    public static final String KEY_USER_RELIGION = "UserReligion";
    public static final String KEY_USER_DISTRICT = "UserDistrict";
    public static final String KEY_USER_UNION = "UserUnion";
    public static final String KEY_USER_POSTOFFICE = "UserPost";
    public static final String KEY_USER_POLICE = "UserPolice";
    public static final String KEY_DATEBIRTH = "UserBirth";
    public static final String KEY_DONATIONBLOOD = "UserDonation";
    public static final String KEY_IMAGE = "UserImage";
    public static final String KEY_LAT = "UserLat";
    public static final String KEY_LONG = "UserLong";

    public static final String KEY_TOKEN = "UserToken";


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreference(Context context){
        sharedPreferences = context.getSharedPreferences("user_pref",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void setSplashStatus(boolean status){
        editor.putBoolean("status",status);
        editor.commit();

    }





    public void setUserRegisterInfo(String name,String email,String password,String mobileNumber,String alternateMobileNumber,String socialLink,
                                    String bloodGroup,String weight,String gender,String religion,String district,String unionName,String postOffice,String policeStation,
                                    String dateOfBirth, String lastBloodDonationDate,String imageLink,long longitude,long latitude){

        editor.putString(KEY_USERNAME,name);
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USER_PASSWORD,password);
        editor.putString(KEY_USER_CONFIRM_PASSWORD,password);
        editor.putString(KEY_MOBILE,mobileNumber);
        editor.putString(KEY_ALTER_MOBILE,alternateMobileNumber);
        editor.putString(KEY_USER_SOCIAL,socialLink);
        editor.putString(KEY_USER_BLOOD,bloodGroup);
        editor.putString(KEY_USER_RELIGION,religion);
        editor.putString(KEY_USER_DISTRICT,district);
        editor.putString(KEY_USER_UNION,unionName);
        editor.putString(KEY_USER_POSTOFFICE,postOffice);
        editor.putString(KEY_USER_POLICE,policeStation);
        editor.putString(KEY_DATEBIRTH,dateOfBirth);
        editor.putString(KEY_DONATIONBLOOD,lastBloodDonationDate);
        editor.putString(KEY_IMAGE,imageLink);
        editor.putLong(KEY_LAT,longitude);
        editor.putLong(KEY_LONG,latitude);
        editor.commit();
    }


    public void saveUserEmail(String email,String password,String conFirmPassword){


        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USER_PASSWORD,password);
        editor.putString(KEY_USER_CONFIRM_PASSWORD,conFirmPassword);
        editor.commit();
    }


    public void saveUserPhone(String phone,String altPhone,String socialLink){


        editor.putString(KEY_MOBILE,phone);
        editor.putString(KEY_ALTER_MOBILE,altPhone);
        editor.putString(KEY_USER_SOCIAL,socialLink);
        editor.commit();
    }


    public void saveBlood(String blood){


        editor.putString(KEY_USER_BLOOD,blood);
        editor.commit();
    }

    public void saveGender(String gender){
        editor.putString(KEY_GENDER,gender);
        editor.commit();
    }


    public void saveWeight(int weight){
        editor.putInt(KEY_USER_WEIGHT,weight);
        editor.commit();
    }

    public int getWeight(){
        return sharedPreferences.getInt(KEY_USER_WEIGHT,0);
    }


    public void saveToken(String token){
        editor.putString(KEY_TOKEN,token);
        editor.commit();
    }

    public String getToken(){
        return sharedPreferences.getString(KEY_TOKEN,null);
    }
    public void saveAddress(String district,String union,String postOffice,String policeStation){


        editor.putString(KEY_USER_DISTRICT,district);
        editor.putString(KEY_USER_UNION,union);
        editor.putString(KEY_USER_POSTOFFICE,postOffice);
        editor.putString(KEY_USER_POLICE,policeStation);
        editor.commit();
    }


    public void saveBirthDate(String dateOfBirth){


        editor.putString(KEY_DATEBIRTH,dateOfBirth);
        editor.commit();
    }


    public void saveImage(String image){


        editor.putString(KEY_IMAGE,image);
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put(KEY_USER_EMAIL, sharedPreferences.getString(KEY_USER_EMAIL, null));
        userData.put(KEY_USER_PASSWORD, sharedPreferences.getString(KEY_USER_PASSWORD, null));
        userData.put(KEY_USER_CONFIRM_PASSWORD, sharedPreferences.getString(KEY_USER_CONFIRM_PASSWORD, null));
        userData.put(KEY_MOBILE, sharedPreferences.getString(KEY_MOBILE, null));
        userData.put(KEY_ALTER_MOBILE, sharedPreferences.getString(KEY_ALTER_MOBILE, null));
        userData.put(KEY_USER_SOCIAL, sharedPreferences.getString(KEY_USER_SOCIAL, null));
        userData.put(KEY_USER_BLOOD, sharedPreferences.getString(KEY_USER_BLOOD, null));

        userData.put(KEY_GENDER, sharedPreferences.getString(KEY_GENDER, null));
        userData.put(KEY_DATEBIRTH, sharedPreferences.getString(KEY_DATEBIRTH, null));
        userData.put(KEY_USER_DISTRICT, sharedPreferences.getString(KEY_USER_DISTRICT, null));
        userData.put(KEY_USER_UNION, sharedPreferences.getString(KEY_USER_UNION, null));
        userData.put(KEY_USER_POSTOFFICE, sharedPreferences.getString(KEY_USER_POSTOFFICE, null));
        userData.put(KEY_USER_POLICE,sharedPreferences.getString(KEY_USER_POLICE, null));

        userData.put(KEY_IMAGE,sharedPreferences.getString(KEY_IMAGE, null));
        userData.put(KEY_DONATIONBLOOD,sharedPreferences.getString(KEY_DONATIONBLOOD, null));
        userData.put(KEY_USER_RELIGION, sharedPreferences.getString(KEY_USER_RELIGION, null));
        userData.put(KEY_LAT,sharedPreferences.getString(KEY_LAT, null));
        userData.put(KEY_LONG,sharedPreferences.getString(KEY_LONG, null));

        return userData;
    }


    public boolean getSplashStatus(){
        return sharedPreferences.getBoolean("status",false);
    }
}
