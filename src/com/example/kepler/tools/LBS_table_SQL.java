package com.example.kepler.tools;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;

import com.example.kepler.object.LBSInfo;
import com.example.kepler.object.POI_Info;

public class LBS_table_SQL {
static SQLiteDatabase db;
static String username;
	public static void init(String userid,Context context)
	{
		username = userid;
		String SDCardPath = Environment.getExternalStorageDirectory().getPath();
		File dirFile = new File( SDCardPath +"/"+"tables");
		if (!dirFile.exists()) { 
			dirFile.mkdirs();
		}
		db = SQLiteDatabase.openOrCreateDatabase(
				dirFile+"/lbs_table.db3",
				null);
	}
	
	public static void add(LBSInfo lbs)
	{
		try
		{
			db.execSQL("insert into poi values(?,?,?,?,?,?,?)",
					new String[]{
					      lbs.lbsid, 
					      username,
						  String.valueOf(lbs.lat),
						  String.valueOf(lbs.lng),
						  null,
						  String.valueOf(lbs.accuracy),
						  String.valueOf(lbs.haspois)
					}
			);
			//+ poi.id+ ","
			//+ String.valueOf(poi.lat)+ ","
			//+ String.valueOf(poi.lon)+ ","
			//+ poi.name+ ","
			//+ poi.Type+ ","
			//+ "1400"+ ")");
			//Cursor cursor = db.rawQuery("", null);
		}
		catch(SQLiteException e)
		{
			db.execSQL("create table if not exists lbs"
					  + "(id varchar(25)," 
					  + " userid varchar(25)," 
					  + " latitude double,"
					  + " longitude double,"
					  + " CreatedTime CreatedTime TimeStamp NOT NULL DEFAULT (datetime('now','localtime'))," 
					  + " accuracy double," 
					  + " haspois boolean,"
					  + " primary key(id,CreatedTime))");
					  //db.execSQLs("alter table poi_table.poi add id int primary key");
					  //db.execSQL("alter table poi_table.poi add latitude double");
					  //db.execSQL("alter table poi_table.poi add longitude double");
					  //db.execSQL("alter table poi_table.poi add name varchar(25)");
					  //db.execSQL("alter table poi_table.poi add type varchar(25)");
					  //db.execSQL("alter table poi_table.poi add score int");
		}
	}
	
	public static ArrayList<LBSInfo> search(){
		
		Cursor cursor = db.rawQuery("select * form poi", null);
		ArrayList<LBSInfo> lbss = new ArrayList<LBSInfo>();
		while(cursor.moveToNext()){
			LBSInfo lbs = new LBSInfo();
			lbs.lbsid = cursor.getString(0);
			lbs.lat = cursor.getDouble(1);
			lbs.lng = cursor.getDouble(2);
			lbs.date = cursor.getString(3);
			lbs.accuracy = cursor.getDouble(4);
			lbss.add(lbs);
		}
		return lbss;
	}
}
