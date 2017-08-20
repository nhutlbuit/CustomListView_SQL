package com.example.nhutl.sqlexample.activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.ViewColumnAdapter;
import com.example.nhutl.sqlexample.db.DBHelper;
import com.example.nhutl.sqlexample.dto.Column;

import java.util.ArrayList;
import java.util.List;

public class ListProduct extends AppCompatActivity {
    ListView listView;
    private Context context;
    List<Column> listcolumns= new ArrayList<Column>();
    DBHelper dbHelper;
    Column column;
    ViewColumnAdapter adapter;
    EditText edtCot2,edtCot3,edtCot4,edtUpdateCot2,edtUpdateCot3,edtUpdateCot4;
    Dialog dialog;
    Button btnAdd,btnCancel,btnUpdate,btnCancelUpdate;
    String valueCot2,valueCot3,valueCot4;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }

    private void initialize(){
        dbHelper = new DBHelper(ListProduct.this);
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ViewColumnAdapter(this,R.layout.item_row,listcolumns);
        listView.setAdapter(adapter);
        dbHelper.CreateTableSanPham();
        queryAllDataFromTbleSanPham();
    }

    private void queryAllDataFromTbleSanPham(){
        listcolumns.clear();
        listcolumns.addAll(dbHelper.queryfromTableSanPham(column));
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_sanpham, menu);
        toolbar.setTitle("List Product");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                    dialogAdd();
                break;
            case android.R.id.home:
                    this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialogAdd(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_san_pham);
        btnAdd = (Button) dialog.findViewById(R.id.btnAdd) ;
        btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        handleEvent();
        dialog.show();
    }

    private void initData(Dialog dialog){
        edtCot2 = (EditText) dialog.findViewById(R.id.ed2);
        edtCot3 = (EditText) dialog.findViewById(R.id.ed3);
        edtCot4 = (EditText) dialog.findViewById(R.id.ed4);

        valueCot2 = edtCot2.getText().toString();
        valueCot3 = edtCot3.getText().toString();
        valueCot4 = edtCot4.getText().toString();
    }

    private void handleEvent(){
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData(dialog);
                if("".equals(valueCot2) && "".equals(valueCot3) && "".equals(valueCot4)){
                    Toast.makeText(ListProduct.this, "Please enter the value!", Toast.LENGTH_SHORT).show();
                }else{
                    /*Insert data to table SanPham*/
                    column = new Column(
                            null,
                            valueCot2,
                            valueCot3,
                            valueCot4);

                    dbHelper.insertIntoTableSanPham(column);
                    dialog.dismiss();
                    /*Query all data from table SanPham*/
                    queryAllDataFromTbleSanPham();
                }
            }
        });
    }


    public void dialogUpdate(final Column column1){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_update_product);

        btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate) ;
        btnCancelUpdate = (Button) dialog.findViewById(R.id.btnCancelUpdate);

        edtUpdateCot2 = (EditText) dialog.findViewById(R.id.edUpdate2);
        edtUpdateCot3 = (EditText) dialog.findViewById(R.id.edUpdate3);
        edtUpdateCot4 = (EditText) dialog.findViewById(R.id.edUpdate4);

        edtUpdateCot2.setText(column1.getCot2().toString());
        edtUpdateCot3.setText(column1.getCot3().toString());
        edtUpdateCot4.setText(column1.getCot4().toString());

        btnCancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 column = new Column(
                         column1.getCot1(),
                         edtUpdateCot2.getText().toString(),
                         edtUpdateCot3.getText().toString(),
                        edtUpdateCot4.getText().toString());
                dbHelper.UpdateTableSanPham(column);
                dialog.dismiss();
               queryAllDataFromTbleSanPham();
            }
        });

        dialog.show();
    }
    public  void deleteSanPham(final Column column2){

        dialog = new Dialog(this);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Are you want sure delete?");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbHelper.DeleteDataFromTableSanPham(column2);
                /*Query all data from table SanPham*/
                queryAllDataFromTbleSanPham();
                Toast.makeText(ListProduct.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }
}
