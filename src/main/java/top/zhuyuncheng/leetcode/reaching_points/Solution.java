package top.zhuyuncheng.leetcode.reaching_points;

/**
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
 *
 * <p>
 * 示例:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: True
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: False
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: True
 *
 * <p>
 * 注意:
 * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
 */
public class Solution {
    /*
     * 反向推导该题，(tx, ty)通过 ty = ty - tx 或者 tx = tx - ty 的方式判断是否等于 sx, sy
     * if : tx > ty then : tx = tx % ty
     * if : tx < ty then : ty = ty % tx
     *
     * 但是sx, sy, tx, ty 是范围在 [1, 10^9] 的整数， ty = 10 ^ 9  tx = 3, 采用减法的方式需要 10 ^ 9 / 3 次循环，
     * 非常耗费时间，可见我注释的代码，而采用 % 的方式可以一次性得到结果 1
     *
     * 总结：有时候 减法 比 加法 好用，魔除 比 减法 好用哟，基本功很重要呀，好好学习吧。
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }

        if (tx == sx) {
            return (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return (tx - sx) % ty == 0;
        }
        return false;
    }

    /*public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        if (tx > 1 && ty > 1 && ty == tx) {
            return false;
        }
        while (tx >= sx && ty >= sy) {
            System.out.println(tx + "  ..  " + ty);
            if (ty > tx) {
                ty -= tx;
            } else if (tx > ty) {
                tx -= ty;
            } else {
                return false;
            }
            if (sx == tx && sy == ty) {
                return true;
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
//        boolean flag = new Solution().reachingPoints(1, 1, 2, 2);
//        boolean flag = new Solution().reachingPoints(9, 5, 12, 8);
//        boolean flag = new Solution().reachingPoints(2, 1, 17, 7);
        boolean flag = new Solution().reachingPoints(1, 1, (int) Math.pow(10, 9), 3);
        System.out.println(flag);
    }
}
