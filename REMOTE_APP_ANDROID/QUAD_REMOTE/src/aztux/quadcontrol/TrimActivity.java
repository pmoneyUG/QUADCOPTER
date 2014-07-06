package aztux.quadcontrol;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TrimActivity extends Activity {
	
	
	//variables to be modified y clicking on arrows
	int rolltrim = 0;
	int pitchtrim = 0;
	
	private Button upTrimBtn,downTrimBtn,leftTrimBtn,rightTrimBtn;
	private TextView trimtext;
	
	void set_remote_trim() {
		
		QuadcontrolActivity.trimpitch = pitchtrim;
		QuadcontrolActivity.trimroll = rolltrim;
	}	
	
	void get_remote_trim() {
		
		pitchtrim = QuadcontrolActivity.trimpitch;
		rolltrim  = QuadcontrolActivity.trimroll;
	}	
	
	void print_value() {
		
		//print values on screen
		String msg = "Roll Trim :" + rolltrim 
				+", Pitch Trim : " + pitchtrim;
				
		trimtext.setText(msg);
	}
			
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.trim);
		
		//link butons to xml files
		upTrimBtn = (Button)findViewById(R.id.upTrimBtn);
		downTrimBtn = (Button)findViewById(R.id.downTrimBtn);
		rightTrimBtn = (Button)findViewById(R.id.rightTrimBtn);
		leftTrimBtn = (Button)findViewById(R.id.leftTrimBtn);
		
		//link to textview
		trimtext = (TextView)findViewById(R.id.trim_text);
		get_remote_trim();
		print_value();
		
		upTrimBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				pitchtrim += 1;
				set_remote_trim();
				print_value();
			}
		});
		
		downTrimBtn.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
			
				pitchtrim -= 1;
				set_remote_trim();
				print_value();
				}
		});
		
		rightTrimBtn.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
			
				rolltrim += 1;
				set_remote_trim();
				print_value();
			}
		});
	
		leftTrimBtn.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
			
				rolltrim -= 1;
				set_remote_trim();
				print_value();
			}
		});
	}
	
	//--------------------------------------------------------------
	//Menus
	public boolean onCreateOptionsMenu(Menu menu) 
    {
         super.onCreateOptionsMenu(menu);
         
         MenuItem Item = menu.add("PID");
         MenuItem Itemcam = menu.add("Camera");
         MenuItem Itemtrim = menu.add("Trim");
		return true;
    }
    
	public boolean onOptionsItemSelected(MenuItem item)
	{
	    	if (item.getTitle() == "PID") {
	    		Intent intent = new Intent(this, PIDActivity.class);
	    		startActivity(intent);
	    	}
	    	if (item.getTitle() == "Camera") {
	    		Intent intent = new Intent(this, CameraActivity.class);
	    		startActivity(intent);
	    	}
	    	if (item.getTitle() == "Trim") {
	    		Intent intent = new Intent(this, TrimActivity.class);
	    		startActivity(intent);
	    	}
	    	return true;
	    }
}