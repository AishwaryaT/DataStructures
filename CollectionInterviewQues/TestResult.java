package CollectionInterviewQues;

class TestResult {
	int studentId;
	String testDate=null;
	int testScore;
	public TestResult() {
		// TODO Auto-generated constructor stub
	}
	
	TestResult(int studentId,String tesDate, int testScore){
		this.studentId=studentId;
		this.testScore=testScore;
		this.testDate = testDate;
	}
}