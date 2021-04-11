package ru.skillbench.tasks.basics.math;

import java.math.BigDecimal;
import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {
    public double[] array;

    public static void  main(String[] args) {
        ArrayVectorImpl arrayVector = new ArrayVectorImpl();
        arrayVector.set(2.3, 3, 2);
        ArrayVectorImpl arrayVector2 = new ArrayVectorImpl();
        arrayVector2.set(2.3, 3, 2, 7);
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.10)));

        //arrayVector.set(6, 3.4);
        //System.out.println(Arrays.toString(arrayVector.sum(arrayVector2).get()));
        /*System.out.println(arrayVector.scalarMult(arrayVector2));
        System.out.println(arrayVector.getNorm());*/
        //System.out.println(arrayVector.array.length);
        //Arrays.stream(arrayVector.array).forEach(System.out::println);

        int i = 0;

        //System.out.println(i);

        String s = "1";
        Object c = '1';
        if ("1" == c);

    }

    public void set(double... elements) {
        array = elements;
    }

    public double[] get() {
        return array;
    }

    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVectorImpl();
        arrayVector.set(this.array.clone());
        return arrayVector;
    }

    public int getSize() {
        return array.length;
    }

    public void set(int index, double value) {
        if (index >= 0){
            if (index >= array.length) {
                array = Arrays.copyOf(array, index + 1);
            }
            array[index] = value;
        }
    }

    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }

    public double getMax() {
        double max = Double.MIN_VALUE;
        for (double d : array){
            if (d > max)
                max = d;
        }
        return max;
    }

    public double getMin() {
        double min = Double.MAX_VALUE;
        for (double d : array){
            if (d < min)
                min = d;
        }
        return min;
    }

    public void sortAscending() {
        Arrays.sort(array);
    }

    public void mult(double factor) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= factor;
        }
    }

    public ArrayVector sum(ArrayVector anotherVector) {
        if (anotherVector.get().length >= array.length) {
            for (int i = 0; i < anotherVector.get().length; i++) {
                if (i == array.length) {
                    break;
                }
                anotherVector.get()[i] += array[i];
            }
            array = anotherVector.get().clone();
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (i == anotherVector.get().length) {
                    break;
                }
                array[i] += anotherVector.get()[i];
            }
        }
        return this;
    }

    public double scalarMult(ArrayVector anotherVector) {
        double scalarSum = 0;
        int minSize = Math.min(array.length, anotherVector.get().length);
        for (int i = 0; i < minSize; i++) {
            if (array.length == i || anotherVector.get().length == i)
                break;
             scalarSum += array[i] * anotherVector.get()[i];
        }
        return scalarSum;
    }

    public double getNorm() {
        return Math.sqrt(scalarMult(this.clone()));
    }
}
