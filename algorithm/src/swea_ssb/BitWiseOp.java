package swea_ssb;

/**
 * sw expert academy
 * self sturdy book 1 - array 3차시 - 비트 연산자, 검색, 대표문제-집합의 합
 * 
 */
public class BitWiseOp {
	public static void main(String[] args) {
		
		
		
	}
	
	// 이진 검색
	int binarySearch(int arr[], int num, int key)
	{
		int up = num -1;
		int down = 0;
		int mid;
		
		for (int i = 0; i < arr.length; i++) {
			mid = (up + down) / 2;
			
			if(arr[mid] == key)
				return mid;
			if(arr[mid] > key){
				up = mid -1;
			}else {
				down = mid + 1;
			}			
			if(up < down)
				break;
		}
		return -1;
	}
}
