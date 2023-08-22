package Test;

public class Result {
	public String result=null;
	public int mar,hindi,eng,math,sci,soSci;
	public Result(int mar,int hindi,int eng,int math,int sci,int soSci) {
		this.mar=mar;
		this.hindi=hindi;
		this.eng=eng;
		this.math=math;
		this.sci=sci;
		this.soSci=soSci;
	}
	public String getResult(float per) {
		if(per>=35) {
			result="Pass";
		}else {
			result="Fail";
		}
		return result;
	}
}
