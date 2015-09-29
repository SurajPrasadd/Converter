package com.suraj.converter;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.suraj.converter.R;

public class MainActivity extends Activity {
	EditText input1,input2;
	Button convert;
	TextView result;
	Spinner roll;
	String enterinput1;
	String enterinput2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input1=(EditText) findViewById(R.id.editTextinput1);
        input2=(EditText) findViewById(R.id.editTextinput2);
        convert=(Button) findViewById(R.id.buttonconvert);
        result=(TextView) findViewById(R.id.textView);
        roll=(Spinner) findViewById(R.id.spinner);
        
        String[] option={"Temperature ","Distance","Currency"};
        
        
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, option);
        roll.setAdapter(adapter);
        roll.setOnItemSelectedListener(new OnItemSelectedListener() {
        	

	      @Override
		 	public void onItemSelected(AdapterView<?> arg0, final View arg1,int position, long arg3) 
	      
	      {
	    	  
                            switch(position){
                            
                                     case 0: input1.setHint("Celsius(C) ");
				                             input2.setHint("Fahrenheit(F)");
				                             convert.setOnClickListener(new OnClickListener() {
							
						                      	@Override
						                           	public void onClick(View arg0) {
						                         		temper(arg1);
								
					                               		}
					                        	});
				                             reset();
				                             
				         
				                              break;
				                     case 1: input1.setHint("Kilometers(km) ");
		                                     input2.setHint("Meter(m)");
		                                     convert.setOnClickListener(new OnClickListener() {
					
				                             	@Override
			                                  		public void onClick(View arg0) {
		                                               distance(arg1);
			                                      		}
				                                   });
		                                     reset();
				                               break;
				                      case 2:input1.setHint("US Dollar($)");
		                                     input2.setHint("Indian Rupee(Rs)");
                                              convert.setOnClickListener(new OnClickListener() {
					
			                                		@Override
			                               		public void onClick(View arg0) {
		                                              curren(arg1);
			                                       		}
                                                  });
                                              reset();
		                                           break;
		                                           
				                             }
				
			}

			private void reset() {
				input1.setText("");
                input2.setText("");
                result.setText("Answer");
			
		}

			private void curren(View arg1) {
				enterinput1=input1.getText().toString();
				enterinput2=input2.getText().toString();
				if(enterinput1.length()==0 && enterinput2.length()==0)
				{
					
					Toast.makeText(MainActivity.this, "please enter $ or Rs value", Toast.LENGTH_SHORT).show();
				}
				else if (enterinput2.length()==0){
					Double n=Double.parseDouble(enterinput1);
					result.setText("Rs "+(Double.toString(n * 61)));
				}
				else if(enterinput1.length()==0){
					Double n=Double.parseDouble(enterinput2);
					result.setText("$ "+(Double.toString(n/61)));
					}
				else  if(enterinput1.length()>0 && enterinput2.length()>0){
					 input1.setText("");
					 input2.setText("");
					 result.setText("Answer");
					 Toast.makeText(MainActivity.this, "please enter in any one text box", Toast.LENGTH_SHORT).show();
				 }
							
			}

			private void distance(View arg1) {
				enterinput1=input1.getText().toString();
				enterinput2=input2.getText().toString();
				if(enterinput1.length()==0 && enterinput2.length()==0)
				{
					
					Toast.makeText(MainActivity.this, "please enter km or m value", Toast.LENGTH_SHORT).show();
				}
				else if (enterinput2.length()==0){
					Double n=Double.parseDouble(enterinput1);
					result.setText((Double.toString(n * 1000))+"meter");
				}
				else if(enterinput1.length()==0){
					Double n=Double.parseDouble(enterinput2);
					result.setText((Double.toString(n/1000))+"Kilometer");
					}
				else  if(enterinput1.length()>0 && enterinput2.length()>0){
					 input1.setText("");
					 input2.setText("");
					 result.setText("Answer");
					 Toast.makeText(MainActivity.this, "please enter in any one text box", Toast.LENGTH_SHORT).show();
				 }
				
			}

			private void temper(View arg1) {
				enterinput1=input1.getText().toString();
				enterinput2=input2.getText().toString();
				
				if(enterinput1.length()==0 && enterinput2.length()==0)
				{

					Toast.makeText(MainActivity.this, "please enter C or F value", Toast.LENGTH_SHORT).show();
				}
				else if (enterinput2.length()==0){
					int n=Integer.parseInt(enterinput1);
					result.setText((Double.toString((n * 9/5) + 32))+" F");
				}
				else if(enterinput1.length()==0){
					int n=Integer.parseInt(enterinput2);
					result.setText(Double.toString(((n - 32) * 5/9))+" C");
				}
				else  if(enterinput1.length()>0 && enterinput2.length()>0){
					 input1.setText("");
					 input2.setText("");
					 result.setText("Answer");
					 Toast.makeText(MainActivity.this, "please enter in any one text box", Toast.LENGTH_SHORT).show();
				 }
				
				 
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}