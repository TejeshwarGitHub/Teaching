package group_1.com.teaching;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerLoading extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add_data;
    EditText add_data_edit_text;
    ArrayList<String> data = new ArrayList<>();
    MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_loading);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        add_data = (Button) findViewById(R.id.add_data_button);
        add_data_edit_text = (EditText) findViewById(R.id.data_add_edit_text);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (!(add_data_edit_text.getText().toString().isEmpty())){
                   addData(add_data_edit_text.getText().toString());
                   add_data_edit_text.setText(null);
               }else {
                   Toast.makeText(RecyclerLoading.this,"enter some valid data",Toast.LENGTH_LONG).show();
               }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        for (int i = 0;i<data.size();i++){
            Log.d("arraylist data",data.get(i));
        }
        myRecyclerAdapter = new MyRecyclerAdapter(data);
        recyclerView.setAdapter(myRecyclerAdapter);
        myRecyclerAdapter.notifyDataSetChanged();
    }

    private void addData(String s) {
        data.add(s);
        myRecyclerAdapter.notifyDataSetChanged();
    }
}
