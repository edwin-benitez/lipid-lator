package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CholesterylEsters_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cholesteryl_esters__result_);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CholesterylEsters_Result_Activity.this, CholesterylEstersActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CholesterylEsters_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
