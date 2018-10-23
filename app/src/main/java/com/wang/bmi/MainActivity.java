package com.wang.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//快捷鍵:CTRL+ALT+F       CTRL+P(提醒)        AIT+SHIFT(移動換行)
// CTRL+ALT+M(Extract Method)   CTRL+Y(刪除一行)    ALT+ENTER(String Resourse)
public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private  void findViews(){
        //取得輸入方塊內資料，轉換成string
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
help.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Log.d("MainActivity","OnClickListener");
new AlertDialog.Builder(MainActivity.this)
        .setMessage(R.string.bmi_information)
        .setPositiveButton(R.string.ok,null)
        .show();
    }
});
    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStar");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }

    public void bmi(View view){
        Log.d("MainActivity" , "bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity" , w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity" , bmi +"");
        //切換到另一個視窗呈現
        Intent intent = new Intent(this,resultActivity.class);
        intent.putExtra("BMI",bmi);
        startActivity(intent);

        /*//小懸浮視窗
        Toast.makeText(this,"Your BMI is "+bmi,Toast.LENGTH_LONG).show();
        //對話框
        new AlertDialog.Builder(this)
                .setMessage("Your BMI is : "+bmi)
                .setTitle("BMI")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText("");
                        edHeight.setText("");
                    }
                })
                .show();*/
    }
}
