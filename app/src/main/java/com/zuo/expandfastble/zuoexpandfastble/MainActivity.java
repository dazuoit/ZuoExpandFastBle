package com.zuo.expandfastble.zuoexpandfastble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//有A B 2种设备,A与B区分的方式是名字 ,A设备都叫A00,B设备都叫B00,B01  ,A设备是单个连接,B设备是多个连接
	}
}
