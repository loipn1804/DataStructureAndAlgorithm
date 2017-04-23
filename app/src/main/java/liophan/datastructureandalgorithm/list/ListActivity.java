package liophan.datastructureandalgorithm.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import liophan.datastructureandalgorithm.R;
import liophan.datastructureandalgorithm.RandomUtil;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since April 19, 2017
 */

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.btnAction)
    Button btnAction;

    private List<String> mArrayList = new ArrayList<>();
    private List<String> mLinkedList = new LinkedList<>();

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
        Random random = new Random();

        int i = 0;
        while (i < 10000) {
            String name = RandomUtil.randomName(random);
            mArrayList.add(name);
            mLinkedList.add(name);
            i++;
        }

        long start = System.currentTimeMillis();
        i = 0;
        while (i < 1000) {
            i++;
            mArrayList.remove(i);
        }
        Log.e("LIO", "mArrayList " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        i = 0;
        while (i < 1000) {
            i++;
            mLinkedList.remove(i);
        }
        Log.e("LIO", "mLinkedList " + (System.currentTimeMillis() - start));
    }
}
