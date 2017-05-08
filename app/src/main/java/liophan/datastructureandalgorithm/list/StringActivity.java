package liophan.datastructureandalgorithm.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
 * @since April 26, 2017
 */

public class StringActivity extends AppCompatActivity {
    @BindView(R.id.btnAction)
    Button btnAction;
    @BindView(R.id.btnImmutable)
    Button btnImmutable;
    @BindView(R.id.btnStringBuffer)
    Button btnStringBuffer;
    @BindView(R.id.btnStringBuilder)
    Button btnStringBuilder;

    private StringBuffer mStringBuffer;
    private StringBuilder mStringBuilder;
    private Random mRandom = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
        ButterKnife.bind(this);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compare();
            }
        });

        btnImmutable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                immutable();
            }
        });

        mStringBuffer = new StringBuffer(RandomUtil.randomName(mRandom));
        btnStringBuffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuffer();
            }
        });

        mStringBuilder = new StringBuilder(RandomUtil.randomName(mRandom));
        btnStringBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuilder();
            }
        });
    }

    private void compare() {
        String a = "LIO";

        String b = new String("LIO");

        String c = "LIO";

        String d = new String("LIO");

        String e = "LIOPHAN";

        String f = new String("PHAN");
        f = a + f; // f become "LIOPHAN"

        Log.e("LIO", "a == b " + (a == b)); // false
        Log.e("LIO", "a equal b " + (a.equals(b))); // true

        Log.e("LIO", "a == c " + (a == c)); // true
        Log.e("LIO", "a equal c " + (a.equals(c))); // true

        Log.e("LIO", "b == d " + (b == d)); // false
        Log.e("LIO", "b equal d " + (b.equals(d))); // true

        Log.e("LIO", "e == f " + (e == f)); // false
        Log.e("LIO", "e equal f " + (e.equals(f))); // true
    }

    private void immutable() {
        String a = "abc";
        String b = doubleString(a);

        Log.e("LIO", "a " + a);
        Log.e("LIO", "b " + b);

        int n = 2;
        int m = doubleInt(n);

        Log.e("LIO", "n " + n);
        Log.e("LIO", "m " + m);

        StringBuilder bd1 = new StringBuilder("builder");
        StringBuilder bd2 = doubleStringBuilder(bd1);

        Log.e("LIO", "bd1 " + bd1);
        Log.e("LIO", "bd2 " + bd2);

        StringBuffer bf1 = new StringBuffer("buffer");
        StringBuffer bf2 = doubleStringBuffer(bf1);

        Log.e("LIO", "bf1 " + bf1);
        Log.e("LIO", "bf2 " + bf2);
    }

    private void stringBuffer() {
        mStringBuffer.append(RandomUtil.randomName(mRandom));
        Log.e("LIO", "stringBuffer length " + mStringBuffer.length() + " - capacity " + mStringBuffer.capacity() + " - " + mStringBuffer);
    }

    private void stringBuilder() {
        mStringBuilder.append(RandomUtil.randomName(mRandom));
        Log.e("LIO", "stringBuilder length " + mStringBuilder.length() + " - capacity " + mStringBuilder.capacity() + " - " + mStringBuilder);
    }

    private String doubleString(String s) {
        return s.concat(s);
    }

    private StringBuilder doubleStringBuilder(StringBuilder builder) {
        return builder.append(builder);
    }

    private StringBuffer doubleStringBuffer(StringBuffer buffer) {
        return buffer.append(buffer);
    }

    private int doubleInt(int i) {
        return i + i;
    }
}
