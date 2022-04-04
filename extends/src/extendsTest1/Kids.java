package extendsTest1;

public class Kids extends ManKind{
	
	private int yearOld;
	
	public Kids(int sex, int salary, int yearOld) {
		super(sex, salary);
		this.yearOld = yearOld;
	}
	
	public int getYearOld() {
		return yearOld;
	}

	public void setYearOld(int yearOld) {
		this.yearOld = yearOld;
	}

	public void printAge(){
		System.out.println(yearOld);
	}

}
