package group_1.com.teaching;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText first,second;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        first= (EditText) findViewById(R.id.first_number);
        second= (EditText) findViewById(R.id.second_number);
        result  = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = first.getText().toString();
                String two = second.getText().toString();
                double sum= Double.parseDouble(one) + Double.parseDouble(two);
                calculate.setText(sum+"");
                Toast.makeText(Main2Activity.this,"Calculation successful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
