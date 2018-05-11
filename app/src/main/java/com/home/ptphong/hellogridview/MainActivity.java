package com.home.ptphong.hellogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.home.ptphong.adapters.ImageAdapter;

public class MainActivity extends AppCompatActivity {
    Integer firstSelectedItem = null, secondSelectedItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter imageAdapter = new ImageAdapter(this);
        gridview.setAdapter(imageAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Integer selectingItem = imageAdapter.getItem(position);

                if(firstSelectedItem == null) {
                    firstSelectedItem = selectingItem;
                    Toast.makeText(MainActivity.this, firstSelectedItem,
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    secondSelectedItem = selectingItem;
                    Toast.makeText(MainActivity.this, secondSelectedItem,
                            Toast.LENGTH_SHORT).show();
                }

                if(firstSelectedItem != null && secondSelectedItem != null) {
                    if (firstSelectedItem.intValue() == secondSelectedItem.intValue()) {
                        Toast.makeText(MainActivity.this, "They are the same",
                                Toast.LENGTH_SHORT).show();

                        // Phong Pham - Remove matched image

                    }
                    else {
                        Toast.makeText(MainActivity.this, "They are the difference",
                                Toast.LENGTH_SHORT).show();

                    }
                    firstSelectedItem = null;
                    secondSelectedItem = null;
                }
            }
        });
    }
}
