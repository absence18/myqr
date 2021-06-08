package com.example.myqr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new IntentIntegrator(this).initiateScan();
        // Scanner 객체 생성 .. App실행 -> Scanner 실행
        // MainActivity 내부에 카메라Scanner 생성
    }
    @Override // MainActivity랑 CameraScanner랑 통신하는 method.. 스캔되면 메소드 실행.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) { // 스캔, 데이터 없으면 Cancelled 출력 됨
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { // 스캔 성공하면 qr데이타 출력
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}