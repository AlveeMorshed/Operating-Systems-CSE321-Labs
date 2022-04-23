import java.util.Random;

class MergeSort extends Thread {
  private int[] arr;
  private int left;
  private int right;

  public MergeSort(int[] arr, int left, int right) {
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

      MergeSort leftPartThread = new MergeSort(arr, left, mid);
      leftPartThread.start();

      MergeSort rightPartThread = new MergeSort(arr, mid + 1, right);
      rightPartThread.start();

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

/*class BonusMergeSort extends Thread {
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
*/
public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]inpArr = {7,8,9,5,1,2,4,3,6,0};
		/*int[]inpArr = new int[500];
		Random random = new Random();
		for(int i=0; i<inpArr.length; ++i) {
			inpArr[i] = random.nextInt(500);
		}*/
		int startTime=0, finishTime = 0;
		MergeSort mrg = new MergeSort(inpArr, 0, inpArr.length - 1);
		
		startTime = (int) System.nanoTime();
		mrg.start();
		
		try {
			mrg.join();
			finishTime = (int) System.nanoTime();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("MultiThreaded output \n");
		for(int i=0; i<inpArr.length; ++i) {
			System.out.print(inpArr[i]+" ");
		}
		System.out.println();
		System.out.println("Time elapsed = "+(finishTime-startTime));
		
		
			
	}

}
