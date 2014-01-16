You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

public class Solution {
    // see local java code: compare rotate matrix VS rotate square
    public void rotate(int[][] a) {
        if(a == null || a.length == 0)
            return;
		int n = a.length;
		for(int layer = 0; layer< n/2; layer ++){
			int start = layer;
			int end = n-1-layer;
			for(int i = start; i < end ; i++){
				int tmp = a[start][i];  // save the top left element
				a[start][i] = a[n-1-i][start]; // move the left border to top
				a[n-1-i][start] = a[end][n-1-i]; // move the bottom border to left
				a[end][n-1-i] = a[i][end]; // move right to bottom;
				a[i][end] = tmp;  // move top to right;
			}
		}
    }
}
