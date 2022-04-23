import java.util.Scanner;

public class Priority {

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
		int[]priority = new int[n];
		int[]flag = new int[n];
		int sysTime = 0, tot= 0;
		float avgwt = 0, avgta = 0;
		
		for(int i=0; i<n; ++i) {
			System.out.println("Input process "+(i+1)+"'s Arrival Time");
			arrival_time[i] = sc.nextInt();
			System.out.println("Input process "+(i+1)+"'s Burst Time");
			burst_time[i] = sc.nextInt();
			permaBurstTime[i] = burst_time[i];
			System.out.println("Input process "+(i+1)+"'s Priority");
			priority[i] = sc.nextInt();
			pid[i] = i+1;
			flag[i] = 0;
		}
		while(true) {
			int c=n;
			double min = Double.POSITIVE_INFINITY;
			if(tot == n) {
				break;
			}
			for(int i = 0; i<n ; ++i) {
				if(arrival_time[i]<=sysTime && priority[i]<min && flag[i]==0) {
					min = priority[i];
					c=i;
				}
			}
			if(c==n) {
				sysTime++;
			}
			else {
				burst_time[c]--;
				sysTime++;
				if(burst_time[c]==0) {
					flag[c]=1;
					complete_time[c] = sysTime; 
					tot++;
				}
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
