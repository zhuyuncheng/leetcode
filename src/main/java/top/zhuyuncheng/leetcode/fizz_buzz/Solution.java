package top.zhuyuncheng.leetcode.fizz_buzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        });
        return res;
    }

    public static void main(String[] args) {
        List<String> stringList = new Solution().fizzBuzz(15);
        System.out.println(stringList);
    }
}
