package BookExample;
/*功能简介：螺旋方阵是将从1开始的自然数由方阵的最外围向内以内螺旋的方式顺序排列而成。
         4阶螺旋方阵排列形式如下。要求采用二维数组存储并输出该螺旋方阵
          1   2   3   4
          12  13  14  5
          11  16  15  6
          10  9   8   7
 */
public class SpiralMatrix {
	public static void main(String args[]){
		int n=4;          //阶数
		int mat[][]=new int [n][n];
		int i,j,k=0;
		for(i=0;i<(n+1)/2;i++)                //i控制生成方阵的圈数，
		{                                     //j控制生成一条表的数据
			for(j=i;j<=n-i-1;j++)             //顶边，从左到右，行不变列变
				mat[i][j]=++k;                //k从1递增到n*n
			for(j=i+1;j<=n-i-1;j++)           //右边，从上到下，行变列不变
				mat[j][n-i-1]=++k;            
			for(j=n-i-2;j>=i;j--)             //底边，从右到左，行不变列变
				mat[n-i-1][j]=++k;
			for(j=n-1-2;j>=i+1;j++)           //左边，从下到上行变列不变
				mat[j][i]=++k;
		}
		for(i=0;i<mat.length;i++)             //输出二位数组元素
		{
			for(j=0;j<mat[i].length;j++)
				System.out.print(mat[i][j]+"\t");
			System.out.println();
		}
	}
}
