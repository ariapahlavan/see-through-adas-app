package team6.see_throughadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Options extends AppCompatActivity {

    public static int videoOption = 3;
    CheckBox annotated;
    CheckBox stitched;
  //  CheckBox original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);


        stitched = (CheckBox) findViewById(R.id.stitched);
  //      original = (CheckBox) findViewById(R.id.original);
        annotated = (CheckBox) findViewById(R.id.annotated);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, videoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (annotated.isChecked()) {
                    videoOption = 1;
                    startActivity(intent);
                }
                else if (stitched.isChecked()) {
                    videoOption = 2;
                    startActivity(intent);
                }
                else{
                    videoOption = 3;
                    startActivity(intent);
                }
            }
        });
    }
}
