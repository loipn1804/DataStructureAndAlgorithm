package liophan.datastructureandalgorithm;

import java.util.Random;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since April 19, 2017
 */

public class RandomUtil {
    public static String[] sChar = new String[]{"A", "B", "C", "D", "E", "F", "J", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String randomName(Random random) {
        String name = "";
        int length = sChar.length;
        int size = random.nextInt(5) + 5;
        for (int i = 0; i < size; i++) {
            name += sChar[random.nextInt(length)];
        }
        return name;
    }
}
