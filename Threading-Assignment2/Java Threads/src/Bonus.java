import java.util.Random;

class BonusMergeSort extends Thread {
	  private int[] arr;
	  private int left;
	  private int right;

	  public BonusMergeSort(int[] arr, int left, int right) {
	    this.arr = arr;
	    this.left = left;
	    this.right = right;
	  }

	  void merge(int arr[], int left, int mid, int right) {
	    // implement merge logic here
		  int leftLength = mid - left + 1;
		  int rightLength = right - mid;
		  int[]leftArr = new int[leftLength];
		  int[]rightArr = new int[rightLength];
		  for(int i=0; i<leftLength; ++i) {
			  leftArr[i] = arr[left+i];
		  }
		  for(int i=0; i<rightLength; ++i) {
			  rightArr[i] = arr[mid + 1 + i];
		  }
		  int lfIdx = 0, rtIdx = 0;
		  int newIdx = left;
		  for(;lfIdx < leftLength && rtIdx < rightLength; newIdx++) {
			  if(leftArr[lfIdx] <= rightArr[rtIdx]) {
				  arr[newIdx] = leftArr[lfIdx];
				  ++lfIdx;
			  } else {
				  arr[newIdx] = rightArr[rtIdx];
				  ++rtIdx;
			  }
		  }
		  
		  for(;lfIdx < leftLength; ++lfIdx, ++newIdx) {
			  arr[newIdx] = leftArr[lfIdx];
		  }
		  for(;rtIdx < rightLength; ++rtIdx, ++newIdx) {
			  arr[newIdx] = rightArr[rtIdx];
		  }
	  }

	  @Override
	  public void run() {
	    if (left < right) {
	      int mid = (left + right) / 2;

	      BonusMergeSort leftPartThread = new BonusMergeSort(arr, left, mid);
	      leftPartThread.run();

	      BonusMergeSort rightPartThread = new BonusMergeSort(arr, mid + 1, right);
	      rightPartThread.run();

	      try {
	        leftPartThread.join();
	        rightPartThread.join();
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }

	      merge(arr, left, mid, right);
	    }
	  }
	}
public class Bonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]bonusArr = {7,8,9,5,1,2,4,3,6,0};
		/*int[]bonusArr = new int[500];
		Random random = new Random();
		for(int i=0; i<bonusArr.length; ++i) {
			bonusArr[i] = random.nextInt(500);
		}*/
		int startTime=0, finishTime = 0;
		BonusMergeSort bonus = new BonusMergeSort(bonusArr, 0, bonusArr.length - 1);
		
		startTime = (int) System.nanoTime();
		bonus.run();
		try {
			bonus.join();
			finishTime = (int) System.nanoTime();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("SingleThreaded bonus output \n");
		for(int i=0; i<bonusArr.length; ++i) {
			System.out.print(bonusArr[i]+" ");
		}
		System.out.println();
		System.out.println("Time elapsed = "+(finishTime-startTime));
	
		
	}

}
