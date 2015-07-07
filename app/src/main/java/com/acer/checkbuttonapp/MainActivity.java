package com.acer.checkbuttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {
    RadioGroup rg;
    TextView show;
    CheckBox cbred;
    CheckBox cbblue;
    CheckBox cbgreen;
    TextView showCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 獲得 UI 上的 RadioGroup 和 TextView 兩個 Component
        rg = (RadioGroup) findViewById(R.id.rg);
        show = (TextView) findViewById(R.id.show);
        // 為 RadioGroup 綁定事件監聽器
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 根據 User 點選的單選按鈕來動態改變 TextView 的值
                String tip = checkedId == R.id.male ? "性別：男" : "性別：女";
                // 修改 TextView 裡面的內容
                show.setText(tip);
            }
        });

        showCheck = (TextView) findViewById(R.id.showCheck);
        cbred = (CheckBox) findViewById(R.id.red);
        cbred.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    showCheck.setText("顏色：選擇紅色");
                } else {
                    showCheck.setText("顏色：取消選擇紅色");
                }
            }
        });

        cbblue = (CheckBox) findViewById(R.id.blue);
        cbblue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    showCheck.setText("顏色：選擇藍色");
                } else {
                    showCheck.setText("顏色：取消選擇藍色");
                }
            }
        });

        cbgreen = (CheckBox) findViewById(R.id.green);
        cbgreen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    showCheck.setText("顏色：選擇綠色");
                } else {
                    showCheck.setText("顏色：取消選擇綠色");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
