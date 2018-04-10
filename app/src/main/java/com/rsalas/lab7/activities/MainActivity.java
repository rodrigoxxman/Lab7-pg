package com.rsalas.lab7.activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import com.rsalas.lab7.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.btn_mic)
    ImageView btn_search;
    @OnClick(R.id.btn_mic)
    public void search(){
        String to_search = String.valueOf(search.getText());
        Intent i = new Intent(this,searchActivity.class);
        i.putExtra("word",to_search);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
