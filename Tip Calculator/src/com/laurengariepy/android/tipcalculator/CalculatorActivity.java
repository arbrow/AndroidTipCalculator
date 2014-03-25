package com.laurengariepy.android.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

	private EditText etBill;
	private Button   btnSmallTip;
	private Button   btnMediumTip;
	private Button   btnLargeTip;
	private TextView tvTip;
	
	private String   tip;
	private String   smallTip  = "0.10";
	private String   mediumTip = "0.15";
	private String   largeTip  = "0.20"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		etBill       = (EditText) findViewById(R.id.etBill); 
		btnSmallTip  = (Button) findViewById(R.id.btnSmallTip);
		btnMediumTip = (Button) findViewById(R.id.btnMediumTip);
		btnLargeTip  = (Button) findViewById(R.id.btnLargeTip);
		tvTip        = (TextView) findViewById(R.id.tvTip); 
		
		setupBtnSmallTipListener();
		setupBtnMediumTipListener();
		setupBtnLargeTipListener();
	}
	
	private void setupBtnSmallTipListener() {
		btnSmallTip.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tip = Tip.computeTip(smallTip, getBill());
				if (tip.equals("-0.00"))  {
					displayToast(); 
					tip = "n/a";
				}
				tvTip.setText("Tip is: " + tip);
			}
		});
	}
	
	private void setupBtnMediumTipListener() {
		btnMediumTip.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tip = Tip.computeTip(mediumTip, getBill());
				if (tip.equals("-0.00")) {
					displayToast();
					tip = "n/a";
				}	
				tvTip.setText("Tip is: " + tip);
			}
		});
	}
	
	private void setupBtnLargeTipListener() {
		btnLargeTip.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tip = Tip.computeTip(largeTip, getBill());
					if (tip.equals("-0.00")) {
						displayToast();
						tip = "n/a";
					}
				tvTip.setText("Tip is: " + tip);
			}
		});
	}
	
	private String getBill() {
		String bill = etBill.getText().toString();
		if (bill != null) 
			return bill;
		else { 
			displayToast();
			return "0.00";
		}
	}
	
	private void displayToast() {
		Toast.makeText(this, "Enter valid bill amount", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

}	
