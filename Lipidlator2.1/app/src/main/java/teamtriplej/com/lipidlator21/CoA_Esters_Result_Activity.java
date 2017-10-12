package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CoA_Esters_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_a_esters_result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        TextView ionResult = (TextView) findViewById(R.id.tvIonResult);
        TextView acylResult = (TextView) findViewById(R.id.tvAcylChainResult);
        TextView abvResult = (TextView) findViewById(R.id.tvAbbreviationResult);
        TextView formulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView molarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);

        int ionIndex = getIntent().getExtras().getInt("ionIndex");
        int acylIndex = getIntent().getExtras().getInt("acylIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String acylSelected = getIntent().getExtras().getString("acylSelected");

        Calculations calc = new Calculations();
        double mass = calc.calculateCoABasicMass(acylIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ionIndex, mass) * 10000d)/ 10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());

        molarMassResult.setText(Double.toString(molarMass));
        formulaResult.setText(formula);
        ionResult.setText(ionSelected);
        acylResult.setText(acylSelected);
        abvResult.setText("CoA(" + acylSelected + ")");

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoA_Esters_Result_Activity.this, CoA_EstersActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoA_Esters_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}