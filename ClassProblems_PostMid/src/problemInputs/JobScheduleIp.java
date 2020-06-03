package problemInputs;
import classProblems.JobSchedule;
import java.util.*;

public class JobScheduleIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> jobs = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> j1 = new ArrayList<Integer>();
		ArrayList<Integer> j2 = new ArrayList<Integer>();
		ArrayList<Integer> j3 = new ArrayList<Integer>();
		ArrayList<Integer> j4 = new ArrayList<Integer>();
		ArrayList<Integer> j5 = new ArrayList<Integer>();
		j1.add(5);
		j1.add(12);
		j2.add(8);
		j2.add(15);
		j3.add(13);
		j3.add(18);
		j4.add(17);
		j4.add(20);
		j5.add(19);
		j5.add(23);
		
		jobs.add(j1);
		jobs.add(j2);
		jobs.add(j3);
		jobs.add(j4);
		jobs.add(j5);
		JobSchedule jb = new JobSchedule(jobs);
		jb.DoSchedule();
	}

}
