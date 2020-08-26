package com.dembla.jvm.util;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysClassParrlelOpDemo {

    public static void main(String[] args) {
        parllel();
    }

    // Java 8 Parallelized Operations
    private static void parllel() {

        // For Large Arrays on multi-core, Min size atleast 1 >> 13 = 8192
        int[] iArray = {23, 4, 59};
        Arrays.parallelSort(iArray);
        System.out.println("iArray parllel Sort: " + Arrays.toString(iArray));

        // parallel Prefix
        Arrays.parallelPrefix(iArray, new IntBinaryOperatorImpl());
        System.out.println(Arrays.toString(iArray));

        // Parallel Set All
        IntUnitaryOperatorImpl i = new IntUnitaryOperatorImpl() ;
        i.setiArray(iArray);
        Arrays.parallelSetAll(iArray, i);
        System.out.println(Arrays.toString(iArray));

    }
}


class IntBinaryOperatorImpl implements IntBinaryOperator {

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}


class IntUnitaryOperatorImpl implements IntUnaryOperator {

    int[] iArray;

    public void setiArray(int[] iArray) {
        this.iArray = iArray;
    }

    @Override // Operand is the index it passes
    public int applyAsInt(int operand) {

        if(iArray != null ){
            return iArray[operand] + 5 ;
        }else
            return operand ;
    }
}