package classProblems;

import java.util.*;

public class JobSchedule {

	public class Job{
		int start;
		int end;
		int index;
		public Job(int start,int end,int index){
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}
	
	public class Machine{
		public ArrayList<Job> allotedJobs;
		int maxFt;
		
		public Machine(Job j) {
			this.allotedJobs = new ArrayList<Job>();
			this.maxFt = 0;
			addJobs(j);
		}
		
		public void addJobs(Job job) {
			if(this.maxFt<job.end) {
				this.maxFt = job.end;
			}
			this.allotedJobs.add(job);
		}
		ArrayList<Job> getJobs(){
			return allotedJobs;
		}
	}
	
	public ArrayList<Job> jobs;
	public ArrayList<Machine> machines;
	
	
	public JobSchedule(ArrayList<ArrayList<Integer> > jobList) {
		
		int i=0;
		jobs  = new ArrayList<Job>();
		machines  = new ArrayList<Machine>();
		for(ArrayList<Integer> j:jobList) {
			jobs.add(new Job(j.get(0),j.get(1),i));
			i +=1;
		}
	}
	
	public void DoSchedule() {
		Collections.sort(jobs,new sortByStart());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int minFt;
		machines.add(new Machine(jobs.get(0)));
		pq.add(jobs.get(0).end);
		for(int i=1;i<jobs.size();i++) {
			Job j = jobs.get(i);
			minFt = pq.peek();
			if(minFt<j.start) {
				pq.poll();
				pq.add(j.end);
				for(Machine m:machines) {
					if(m.maxFt==minFt) {
						m.addJobs(j);
						break;
					}
				}
			}
			else {
				machines.add(new Machine(j));
				pq.add(j.end);
			}
		}
		System.out.print("Schedule\n");
		int mno = 1;
		for(Machine m:machines) {
			System.out.println("Machine "+ mno++);
			for(Job j:m.allotedJobs) {
				System.out.println("Job index : "+j.index);
			}
			System.out.println("................................................");
		}
		
	}
	
	public class sortByStart implements Comparator<Job>{
		public int compare(Job a,Job b) {
			return a.start-b.start;
		}
	}
	
	
	
}
