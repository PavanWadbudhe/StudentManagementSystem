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
			if(mar<35 || hindi<35 || eng<35 || math<35 || sci<35 || soSci<35) {
				result ="Fail";
			}else {
				result="Pass";
			}
			
		}else {
			result="Fail";
		}
		return result;
	}
}
