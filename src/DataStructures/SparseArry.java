package DataStructures;

class SparseArry
{
	public static void main(String[] args)
	{
		//创建一个原始的二维数组（11*11）
		int[][] arry1 = new int[11][11];
		arry1[1][3] = 2;
		arry1[2][5] = 6;


		//遍历整个数组的行
		//查询二维数组的长度只能查询到二维数组的行数
		System.out.println("原始的二维数组：");
		//把二维数组的每一行的值都赋值给一维数组
		for(int[] row:arry1){
			//遍历一维数组
			for(int data:row){
				System.out.printf("%d\t",data);
			}
			System.out.println();  //换行
		}



		//遍历数组得到非0数据的个数
		int sum =0;
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				if(arry1[i][j]!=0){
					sum++;
				}
			}
		}

		//创建稀疏数组
		int[][] sparseArry =new int[sum+1][3];
		sparseArry[0][0]=11;
		sparseArry[0][1]=11;
		sparseArry[0][2]=sum;

		//count用于记录第几个非0数据
		int count =0;
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				if(arry1[i][j]!=0){
					count++;
					sparseArry[count][0]=i;
					sparseArry[count][1]=j;
					sparseArry[count][2]=arry1[i][j];
				}
			}
		}


		//输出稀疏数组
		for(int i=0;i<sparseArry.length;i++){
			System.out.printf("%d\t%d\t%d\t",sparseArry[i][0],sparseArry[i][1],sparseArry[i][2]);
			System.out.println();
		}

		//将稀疏数组转回二维数组
		int[][] arry2=new int[sparseArry[0][0]][sparseArry[0][1]];
		for(int i=1;i<sparseArry.length;i++){
			arry2[sparseArry[i][0]][sparseArry[i][1]]=sparseArry[i][2];
		}
        //打印数组2
		for(int[] row:arry2){
			//遍历一维数组
			for(int data:row){
				System.out.printf("%d\t",data);
			}
			System.out.println();  //换行
		}


	}
}
