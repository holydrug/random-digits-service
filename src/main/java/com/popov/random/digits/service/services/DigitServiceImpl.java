package com.popov.random.digits.service.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DigitServiceImpl implements DigitService {
    @Override
    public String output(int size) {
        int[] array1 = createArray(size);
        int[] array2 = createArray(size);
        int[] array3 = createArray(size);
        int[] array4 = createArray(size);
        int[] array5 = createArray(size);

        return getRandom(array1) + "\n"
                + getRandom(array2) + "\n"
                + getRandom(array3) + "\n"
                + getRandom(array4) + "\n"
                + getRandom(array5);
    }


    private List<?> getRandom(int[] array) {
        List<Integer> six = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int temp;
            do {
                temp = new Random().nextInt(array.length);
            } while (six.contains(temp));
            six.add(i, temp);
        }
        return six;
    }



    private int[] createArray(int size) {
        int[] value = new int[size];
        boolean[] valuesCreated = new boolean[size + 1];
        int randnum;
        Random num = new Random();

        for (int x = 0; x < value.length; x++) {
            do {
                randnum = (num.nextInt(value.length)) + 1;
            } while (valuesCreated[randnum]);

            value[x] = randnum;
            valuesCreated[randnum] = true;
        }
        return value;
    }
}
