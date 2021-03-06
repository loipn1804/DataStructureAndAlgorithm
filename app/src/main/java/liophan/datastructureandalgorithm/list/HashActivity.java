package liophan.datastructureandalgorithm.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import liophan.datastructureandalgorithm.R;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since April 23, 2017
 */

public class HashActivity extends AppCompatActivity {
    @BindView(R.id.btnAction)
    Button btnAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
            }
        });
    }

    private void action() {
        String a = "LIO";
        String b = "PHAN";
        String c = "LIO";

        Log.e("LIO", "a " + a.hashCode());
        Log.e("LIO", "b " + b.hashCode());
        Log.e("LIO", "c " + c.hashCode());

        Log.e("LIO", "index a " + (a.hashCode() & 15) + " " + (456789&15));
    }
}
