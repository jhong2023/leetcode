package array;


public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int tmp;
            if (height[i] < height[j]) {
                tmp = height[i] * (j-i);
                i++;
            } else {
                tmp = height[j] * (j-i);
                j--;
            }
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
