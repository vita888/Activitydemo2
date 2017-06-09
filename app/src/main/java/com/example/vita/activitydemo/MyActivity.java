package com.example.vita.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by vita on 2017/6/5.
 */

public class MyActivity extends Activity {
    private String name;
    private String sex;
    private TextView mTextView;
   private CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

         checkBox     =(CheckBox)findViewById(R.id.cb);
        mTextView = (TextView) findViewById(R.id.newtxt);

        Intent it ;
        Bundle bd ;
        it = getIntent();
        bd = it.getExtras();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean ck = checkBox.isChecked();
                Intent otherit = new Intent();
                otherit.putExtra("result","the checkbox is checked"+ck);
                MyActivity.this.setResult(RESULT_OK,otherit);
                MyActivity.this.finish();
            }
        });
        name = bd.getCharSequence("name").toString();
        sex = bd.getCharSequence("sex").toString();
        mTextView.setText("欢迎 "+name+sex+"士");
    }
}
