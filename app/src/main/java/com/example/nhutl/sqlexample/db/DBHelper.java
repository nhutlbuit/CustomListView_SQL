package com.example.nhutl.sqlexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nhutl.sqlexample.db.DBTable.TestCreate4Column;
import com.example.nhutl.sqlexample.dto.Column;
import com.example.nhutl.sqlexample.util.Constant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhutl on 7/23/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context context;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.db = this.getWritableDatabase();
    }
   /* using this contructor*/
    public DBHelper(Context context) {
        super(context, Constant.DB_NAME , null, Constant.DB_VERSION);
        this.db = this.getWritableDatabase();
        this.context = context;
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public void Close() {
        if (this.db.isOpen()) {
            this.db.close();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CreateTableSanPham() {
        String sqlString = (String
                .format(" CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s VARCHAR(50),%s VARCHAR(50),%s VARCHAR(50))",
                        TestCreate4Column.TABLE_NAME,
                        TestCreate4Column.COLUMN_ID,
                        TestCreate4Column.COLUMN_SP1,
                        TestCreate4Column.COLUMN_SP2,
                        TestCreate4Column.COLUMN_SP3));
        Log.i("CreateTableSanPham: ",sqlString);
        this.db.execSQL(sqlString);
    }

    public void insertIntoTableSanPham(Column colums) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(TestCreate4Column.COLUMN_ID, colums.getCot1());
        contentValue.put(TestCreate4Column.COLUMN_SP1,colums.getCot2());
        contentValue.put(TestCreate4Column.COLUMN_SP2,colums.getCot3());
        contentValue.put(TestCreate4Column.COLUMN_SP3,colums.getCot4());
        this.db.insert(TestCreate4Column.TABLE_NAME, null, contentValue);
    }

    public List<Column> queryfromTableSanPham(Column colums) {
        List<Column> list = new ArrayList<Column>();
        Cursor cursor;
        String sqlString = (String
                .format("SELECT * FROM %s ",
                        TestCreate4Column.TABLE_NAME));
        cursor = this.db.rawQuery(sqlString, null);
        Log.i("queryfromTableSanPham: ",sqlString);
        while (cursor.moveToNext()) {
                Column element = new Column();
                element.setCot1(cursor.getString(0));
                element.setCot2(cursor.getString(1));
                element.setCot3(cursor.getString(2));
                element.setCot4(cursor.getString(3));
                list.add(element);
            }
        cursor.close();
        return list;
    }

    public void UpdateTableSanPham(Column column) {
        String sqlString = (String
                .format(" UPDATE %s SET %s = '%s' , %s = '%s' , %s ='%s'  WHERE %s = %s ",
                        TestCreate4Column.TABLE_NAME,
                        TestCreate4Column.COLUMN_SP1,column.getCot2(),
                        TestCreate4Column.COLUMN_SP2,column.getCot3(),
                        TestCreate4Column.COLUMN_SP3,column.getCot4(),
                        TestCreate4Column.COLUMN_ID,column.getCot1()
                       ));
        Log.i("UpdateTableSanPham: ",sqlString);
        this.db.execSQL(sqlString);
    }

    public void DeleteDataFromTableSanPham(Column column) {
        String sqlString = (String
                .format(" DELETE FROM %s WHERE %S = %s ",
                        TestCreate4Column.TABLE_NAME,
                        TestCreate4Column.COLUMN_ID,column.getCot1()
                ));
        Log.i("DeleteData: ",sqlString);
        this.db.execSQL(sqlString);
    }

}
