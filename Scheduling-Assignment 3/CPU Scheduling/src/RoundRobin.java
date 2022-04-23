import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of process: ");
		int n = sc.nextInt();
		int[]pid = new int[n];
		int[]arrival_time = new int[n];
		int[]burst_time = new int[n];
		int[]permaBurstTime = new int[n];
		int[]complete_time = new int[n];
		int[]turnaround_time = new int[n];
		int[]waiting_time = new int[n];
		int[]flag = new int[n];
		int sysTime = 0, tot= 0;
		float avgwt = 0, avgta = 0;
		Queue<Integer>waitQueue = new LinkedList<Integer>();
		System.out.println("Input Time Quantum");
		int tQ = sc.nextInt();
		for(int i=0; i<n; ++i) {
			System.out.println("Input process "+(i+1)+"'s Arrival Time");
			arrival_time[i] = sc.nextInt();
			System.out.println("Input process "+(i+1)+"'s Burst Time");
			burst_time[i] = sc.nextInt();
			permaBurstTime[i] = burst_time[i];
			pid[i] = i+1;
			flag[i] = 0;
		}
		
		while(true) {
			int c=n;
			if(tot == n) {
				break;
			}
			for(int i = 0; i<n ; ++i) {
				if(arrival_time[i]<=sysTime && flag[i]==0 && !waitQueue.contains(i)) {
					waitQueue.add(i);
				}
				
			}
			
			if(!waitQueue.isEmpty()) {
				c=waitQueue.peek();
				if(burst_time[c]>tQ) {
					burst_time[c]-=tQ;
					sysTime+=tQ;
					for(int i = 0; i<n ; ++i) {
						if(arrival_time[i]<=sysTime && flag[i]==0 && !waitQueue.contains(i)) {
							waitQueue.add(i);
						}
						
					}
					waitQueue.remove();
					waitQueue.add(c);
					
				}else {
					sysTime+=burst_time[c];
					burst_time[c]=0;
					flag[c]=1;
					complete_time[c] = sysTime; 
					tot++;
					waitQueue.remove();
				}
			}
			else{
				sysTime++;
			}
			
		}
		for(int i=0; i<n; ++i) {
			turnaround_time[i]=complete_time[i]-arrival_time[i];
			avgta+=turnaround_time[i];
			waiting_time[i]=turnaround_time[i]-permaBurstTime[i];
			avgwt+=waiting_time[i];
		}
		avgta/=n;avgwt/=n;
		System.out.println("\npid  arrival brust  complete turn waiting");
		for(int i=0; i<n; ++i) {
			System.out.println(pid[i]+"\t"+arrival_time[i]+"\t"+permaBurstTime[i]+"\t"+complete_time[i]+"\t"+turnaround_time[i]+"\t"+waiting_time[i]);
		}
		System.out.println("Average Turnaround Time = "+avgta+"\nAverage Waiting Time = "+avgwt);
		sc.close();
	
	}

}






