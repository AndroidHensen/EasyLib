package com.hensen.easyutils.junjunjun1.random;

import java.util.Arrays;
import java.util.Random;

public class WeightRandom {
    private PP[] options;
    private double[] cumulativeProbabilities;
    private Random rnd;

    public WeightRandom(PP[] options) {
        this.options = options;
        this.rnd = new Random();
        prepare();
    }

    /**
     * prepare()方法计算每个选项的累计概率，保存在数组cumulativeProbabilities中
     */
    private void prepare() {
        int weights = 0;
        for (PP pair : options) {
            weights += pair.getWeight();
        }
        cumulativeProbabilities = new double[options.length];
        int sum = 0;
        for (int i = 0; i < options.length; i++) {
            sum += options[i].getWeight();
            cumulativeProbabilities[i] = sum / (double) weights;
        }
    }

    /**
     * nextItem()方法根据权重随机选择一个，具体就是，首先生成一个0～1的数，
     * 然后使用二分查找，如果没找到，返回结果是-（插入点）-1，所以-index-1就是插入点，插入点的位置就对应选项的索引。
     *
     * @return
     */
    public Object nextItem() {
        double randomValue = rnd.nextDouble();
        int index = Arrays.binarySearch(cumulativeProbabilities, randomValue);
        if (index < 0) {
            index = -index - 1;
        }
        return options[index].getItem();
    }
}