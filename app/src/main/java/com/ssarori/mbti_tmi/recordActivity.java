package com.ssarori.mbti_tmi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class recordActivity extends AppCompatActivity {

    Spinner spinMBTI;
    String MBTI[] = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
    ListView dbList;
    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    EditText edtName;
    myDBHelper myDB;
    SQLiteDatabase sqlDB; //데이터베이스를 조작하는 일(INSERT, SELECT, UPDATE, DELETE) - SQL문 실행
    ArrayList<String> arrayList; //크기가 정해져있지 않은 동적 배열
    ArrayAdapter<String> adapter, mbtiAdapter;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        spinMBTI = (Spinner)findViewById(R.id.spinMBTI);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnSelect = (Button)findViewById(R.id.btnSelect);
        edtName = (EditText)findViewById(R.id.edtName);
        dbList = (ListView)findViewById(R.id.dbList);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(recordActivity.this, android.R.layout.simple_list_item_1, arrayList);
        dbList.setAdapter(adapter);

        myDB = new myDBHelper(recordActivity.this);

        mbtiAdapter = new ArrayAdapter<String>(recordActivity.this, android.R.layout.simple_spinner_dropdown_item, MBTI);
        spinMBTI.setAdapter(mbtiAdapter);

        bar = getSupportActionBar();
        bar.setTitle("친구 MBTI 리스트");

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDB.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO mbtiTBL VALUES('" + edtName.getText().toString() + "','" + spinMBTI.getSelectedItem().toString() + "');");
                sqlDB.close();
                showToast("자료가 입력되었습니다.");
                edtName.setText("");
                btnSelect.callOnClick();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clear();
                sqlDB = myDB.getReadableDatabase();
                Cursor cursor; //추출한 데이터베이스에 위치를 가져다주는 인터페이스(자료가 여러개일 때)
                cursor = sqlDB.rawQuery("SELECT * FROM mbtiTBL WHERE name LIKE '" + edtName.getText().toString() + "%';", null); //검색한 것만 나오게 수정
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(0) + cursor.getString(1));
                } //데이터베이스는 while문을 많이 씀, 몇개인 지 모르니까
                adapter.notifyDataSetChanged();
                cursor.close();
                sqlDB.close();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDB.getWritableDatabase();
                if(edtName.getText().toString().equals("")) {
                    showToast("수정할 친구 이름을 입력해 주세요");
                }else {
                    sqlDB.execSQL("UPDATE mbtiTBL SET mbti='" + spinMBTI.getSelectedItem().toString() + "' WHERE name='" + edtName.getText().toString() +"';");
                    sqlDB.close();
                    showToast("수정 되었습니다.");
                    btnSelect.callOnClick();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDB.getWritableDatabase();
                if(edtName.getText().toString().equals("")) {
                    showToast("삭제할 친구를 입력해 주세요");
                }else {
                    sqlDB.execSQL("DELETE FROM mbtiTBL WHERE name='" + edtName.getText().toString() +"';");
                    sqlDB.close();
                    showToast("삭제 되었습니다.");
                    edtName.setText("");
                    btnSelect.callOnClick();
                }
            }
        });
    }

    void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public class myDBHelper extends SQLiteOpenHelper {
        //생성자 : DB를 생성하는 기능
        public myDBHelper(@Nullable Context context) {
            super(context, "mbtiDB", null, 1);
        } //장소, 저장될 이름, 팩토리, 버전

        // Oncreate 메소드 : 테이블 생성을 담당하는 메소드
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE mbtiTBL (name TEXT PRIMARY KEY, mbti TEXT);");
        }

        // onUpgrade 메소드 : 만들어진 테이블을 삭제 후 다시 생성하는 메소드
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS mbtiTBL");
            onCreate(db);
        }
    } //데이터 베이스 활용하는 클래스 생성, SQLiteOpenHelper 클래스 : 데이터베이스에 관련된 기능을 하는 클래스(db생성과 테이블생성 담당)
}
