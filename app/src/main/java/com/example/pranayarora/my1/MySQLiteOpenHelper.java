package com.example.pranayarora.my1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pranay Arora on 30-05-2018.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = "AdvocateDiary";
    SQLiteDatabase db;
    Context ctx;
    public  static final String TB_name ="CASE";
    public  static final String case_id="caseid";
    public  static final String case_num="casenum";
    public  static final String case_title="casetitle";
    public  static final String case_court="court";
    public  static final String case_type="type";
    public  static final String case_stage="stage";
    public  static final String case_rem="remarks";
    public  static final String fee_agreed="fee";
    public  static final String case_tag="casetag";

    public  static final String TB1_name="client";
    public  static final String client_id="id";
    public  static final String client_name="name";
    public  static final String client_email="email";
    public  static final String client_contact="contact";
    public  static final String client_alt_no="alternativeno";
    public  static final String client_address="address";

    public  static final String TB2_name="hearing";
    public  static final String id="_id";
    public  static final String caseTitle="title";
    public  static final String case_pre_date="predate";
    public  static final String case_next_date="nextdate";
    public  static final String case_fill_date="filldate";
    public  static final String opp_lawyer="opplawyer";
    public  static final String app_lawyer="applawyer";



    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        db=this.getWritableDatabase();
        ctx=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_name
                +" ( "
                +case_id +" INTEGER PRIMARY KEY , "
                +case_title+" TEXT, "
                +case_num+" TEXT, "
                +case_court+" TEXT, "
                +case_type+" TEXT, "
                +case_stage+" TEXT, "
                +case_tag+" TEXT , "
                +case_rem+" TEXT , "
                +fee_agreed+" INTEGER, "
                +client_name+" TEXT , "
                +client_email+" TEXT , "
                +client_contact+" TEXT , "
                +client_alt_no+" TEXT , "
                +client_address+" TEXT "
                +" ); "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TB_name+" IF EXISTS ");
        db.execSQL("DROP TABLE "+TB2_name+" IF EXISTS ");

    }
    public long addCase(String title, String num, String court,
                 String type, String stage, int fees, String tags,
                 String remark) {
        ContentValues val=new ContentValues();
        val.put(case_title,title);
        val.put(case_num, num);
        val.put(case_court, court);
        val.put(case_type, type);
        val.put(case_stage, stage);
        val.put(fee_agreed, fees);
        val.put(case_tag, tags);
        val.put(case_rem, remark);
        //db.execSQL("insert into "+TB_name +" values (title);");
        return db.insert(TB_name, null, val);

    }
    public long addClient(String string, String string2, String string3,
                          String string4, String string5, String string6) {
        //	Toast.makeText(ctx, string+string2+string3+string4+string5+string6, Toast.LENGTH_LONG).show();
        ContentValues val=new ContentValues();
        val.put(client_name,string2);
        val.put(client_contact, string3);
        val.put(client_alt_no, string4);
        val.put(client_email,string5);
        val.put(client_address, string6);

        return db.update(TB_name, val,case_id+"=?", new String[]{string});
        //return db.insert(TB_name, null, val);
    }
    public String[][] getallcases() {
        // TODO Auto-generated method stub
        Cursor c = db.query(TB_name, new String[]{case_id, case_title}, null, null, null, null, null);
        String z[][] = new String[c.getCount()][2];
        int i = 0;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            z[i][0] = c.getString(0);
            z[i][1] = c.getString(1);
            i++;

        }

        return z;
    }
    public String[] getCasesDetail(String id) {
        // TODO Auto-generated method stub
        Cursor c= db.query(TB_name, new String []{case_id,case_title,case_num,case_court,case_type,case_stage,fee_agreed,case_rem,client_name,client_contact,client_alt_no,client_email,client_address},case_id+"= ?", new String[]{id},null,null,null);
        String z[]=new String [12] ;
        if(c!=null)
        {
            c.moveToFirst();

            z[0]=c.getString(1);
            z[1]=c.getString(2);
            z[2]=c.getString(3);
            z[3]=c.getString(4);
            z[4]=c.getString(5);
            z[5]=c.getString(6).toString();
            z[6]=c.getString(7);
            z[7]=c.getString(8);
            z[8]=c.getString(9);
            z[9]=c.getString(10);
            z[10]=c.getString(11);
            z[11]=c.getString(12);






            return z;
        }
        else
        {
            return null;
        }
        //return new String[]{""+c.getCount()};
    }

    public long addhearing(String a, String s1, String s2,
                           String s3, String s4, String s5) {
        ContentValues val=new ContentValues();
        val.put(caseTitle, a);
        val.put(case_pre_date,s1);
        val.put(case_next_date,s2);
        val.put(case_fill_date,s3);
        val.put(opp_lawyer,s4);
        val.put(app_lawyer,s5);
        return db.insert(TB2_name, null, val);

    }
    public long update(String aa, String a, String b, String c, String d,
                       String e, String f, String g, String h, String i, String j,
                       String k, String l, String m, String n, String o, String p, String q) {
        // TODO Auto-generated method stub
        ContentValues val= new ContentValues();
        ContentValues val1=new ContentValues();
        val.put(case_title, a);
        val1.put(caseTitle, a);
        val.put(case_num, b);
        val.put(case_court, c);
        val.put(case_type, d);
        val.put(case_stage, e);
        val1.put(case_fill_date, f);
        val1.put(case_pre_date, g);
        val1.put(case_next_date, h);
        val1.put(opp_lawyer, i);
        val1.put(app_lawyer, j);
        val.put(fee_agreed, k);
        val.put(case_rem, l);
        val.put(client_name, m);
        val.put(client_contact, n);
        val.put(client_alt_no, o);
        val.put(client_email, p);
        val.put(client_address, q);

        @SuppressWarnings("unused")
        long l3=db.update(TB_name, val,case_id+"=?", new String[]{aa});
        long l1=db.insert(TB2_name, null, val1);
        return l1;


    }
    public long delete(String aa) {
        // TODO Auto-generated method stub
        return db.delete(TB_name, case_id+"=?", new String[]{aa});
    }

    public String[][] listHearing(String fromDate, String toDate, String caseTitle) {
        // TODO Auto-generated method stub
        try {
            Cursor c;
            if(caseTitle.equals("Select Case")){
                c=db.rawQuery("SELECT _id,title,predate,nextdate,filldate,opplawyer,applawyer FROM hearing WHERE predate>='"+fromDate+"'and predate<='"+toDate+"'",null);

            }
            else{
                c=db.rawQuery("SELECT _id,title,predate,nextdate,filldate,opplawyer,applawyer FROM hearing WHERE predate>='"+fromDate+"'and predate<='"+toDate+"'and title='"+caseTitle+"'",null);
            }
            String z[][]=new String [c.getCount()][2];
            int i=0;


            for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
            {
                z[i][0]=c.getString(0);
                z[i][1]="Case Title : "+c.getString(1)+"\nPrevious Date : "+c.getString(2)+"\nNext Date : "+c.getString(3)+"\nFilling Date : "+c.getString(4)+"\nOpposing Lawyer : "+c.getString(5)+"\nAppearing Lawyer : "+c.getString(6);
                i++;
            }
            return z;


        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public String[] getHearingDetail(String z2) {
        // TODO Auto-generated method stub
        Cursor c= db.query(TB2_name, new String []{case_fill_date,case_pre_date,case_next_date,opp_lawyer,app_lawyer},caseTitle+"= ?", new String[]{z2},null,null,null);
        String z[]=null;

        if(c!=null){
            z=new String [5] ;
            for(c.moveToLast();!c.isAfterLast();c.moveToNext())
            {
                z[0]=c.getString(0);
                z[1]=c.getString(1);
                z[2]=c.getString(2);
                z[3]=c.getString(3);
                z[4]=c.getString(4);
            }
        }
        return z;


    }

    public long deleteHearing(String b) {
        // TODO Auto-generated method stub
        //	Toast.makeText(ctx, b, Toast.LENGTH_LONG).show();
        return db.delete(TB2_name, id+"=?", new String[]{b});
    }

    public String[] getClient(String b) {
        // TODO Auto-generated method stub
        Cursor c= db.query(TB_name, new String []{client_name,client_contact,client_alt_no,client_email,client_address},case_id+"= ?", new String[]{b},null,null,null);
        String z[]=null;

        if(c!=null){
            z=new String [5] ;
            for(c.moveToLast();!c.isAfterLast();c.moveToNext())
            {
                z[0]=c.getString(0);
                z[1]=c.getString(1);
                z[2]=c.getString(2);
                z[3]=c.getString(3);
                z[4]=c.getString(4);
            }
        }
        return z;
    }

    public long updateWithoutHearing(String aa, String a, String b, String c,
                                     String d, String e, String k, String l, String m, String n,
                                     String o, String p, String q) {
        // TODO Auto-generated method stub
        ContentValues val= new ContentValues();
        val.put(case_title, a);

        val.put(case_num, b);
        val.put(case_court, c);
        val.put(case_type, d);
        val.put(case_stage, e);

        val.put(fee_agreed, k);
        val.put(case_rem, l);
        val.put(client_name, m);
        val.put(client_contact, n);
        val.put(client_alt_no, o);
        val.put(client_email, p);
        val.put(client_address, q);

        return db.update(TB_name, val,case_id+"=?", new String[]{aa});





    }
}


