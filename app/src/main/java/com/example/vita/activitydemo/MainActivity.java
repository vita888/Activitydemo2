package com.example.vita.activitydemo;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private EditText mEditText;
    private RadioButton mBtnWomen;
    private RadioButton mBtnman;
    private RadioGroup mRd;
    private String sex;

    public MainActivity() {
        super();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getExtras().getString("result");
                Log.i("******************", result);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.register);
        mEditText = (EditText) findViewById(R.id.etxt);
        mRd = (RadioGroup) findViewById(R.id.rd);
        mRd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                sex = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public void onClick(View v) {
                String string = mEditText.getText().toString();
                Intent it = new Intent(MainActivity.this, MyActivity.class);
                Bundle bd = new Bundle();
                bd.putCharSequence("name", string);
                bd.putCharSequence("sex", sex);
                it.putExtras(bd);
                startActivityForResult(it, 1);


            }
        });

    }
}
