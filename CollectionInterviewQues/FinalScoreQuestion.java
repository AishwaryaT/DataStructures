Given a list of test results (each with a test date, Student ID, and the student’s Score), 
return the Final Score for each student.
A student’s Final Score is calculated as the average of his/her 5 highest test scores. 

package CollectionInterviewQues;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class FinalScoreQuestion {
	 
	   Map<Integer, Double> calculateFinalScores (List<TestResult> results)  {
	   		if(results == null || results.size() == 0)
	   			return null;

	   		HashMap<Integer, PriorityQueue<Integer> > id_scores = 
	   								new HashMap<Integer, PriorityQueue<Integer> > ();

	   		Comparator comp = Collections.reverseOrder();
	   		   		
	   		for(TestResult res : results) {

	   			PriorityQueue<Integer> queue = null;
	   			if(id_scores.containsKey( res.studentId ) ) {
	   				queue = id_scores.get(res.studentId);
	   			} else {
	   				queue = new PriorityQueue<Integer>(5,comp);
	   			}
	   			
	   			queue.offer(res.testScore);

	   			id_scores.put(res.studentId, queue);
	   		}

	   		Map<Integer, Double> averages = new HashMap<Integer, Double>();
	   		for(int key : id_scores.keySet()) {
	   			PriorityQueue<Integer> queue = id_scores.get(key);

	   			double avg = 0;
	   			for(int i=0; i<5 ; i++)
	   				avg += queue.poll();

	   			avg /= 5;

	   			averages.put(key, avg);
	   		}

	   		return averages;
	   }


			public static void main(String[] args) {
				List<TestResult> testResults = new ArrayList<TestResult>(0);
				testResults.add(new TestResult(1, "02-07-2013", 60));
				testResults.add(new TestResult(1, "02-07-2013", 70));
				testResults.add(new TestResult(1, "02-07-2013", 80));
				testResults.add(new TestResult(1, "02-07-2013", 90));
				testResults.add(new TestResult(1, "02-07-2013", 95));
				
				testResults.add(new TestResult(2, "02-07-2013", 60));
				testResults.add(new TestResult(2, "02-07-2013", 65));
				testResults.add(new TestResult(2, "02-07-2013", 70));
				testResults.add(new TestResult(2, "02-07-2013", 75));
				testResults.add(new TestResult(2, "02-07-2013", 80));
				
				FinalScoreQuestion finalScoreQuestion = new FinalScoreQuestion();
				System.out.println(finalScoreQuestion.calculateFinalScores(testResults));
			}
	}
