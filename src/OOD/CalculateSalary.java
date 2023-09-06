package OOD;

public class CalculateSalary {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(OverLoadTest.a);
		Income[] incomes = new Income[] {
				new Income(3000),
				new Salary(7500),
				new stateConcilSpecialAllowance(15000),
		};
		System.out.print(totalTax(incomes));
	}
	public static double totalTax(Income... incomes) {
		double total = 0;
		for (Income income : incomes) {
			total = total + income.getTax();
		}
		return total;
	}
	

}
enum Weekday{
	UN, MON, TUE, WED, THU, FRI, SAT;
}
enum Color {
    RED , GREEN, BLUE;
}
class Income {
	protected double income;
	public Income(double income) {
		this.income = income;
	}
	public double getTax() {
		return income * 0.1;
	}
}
class Salary extends Income{
	double income;
	public Salary(double income) {
		super(income);
		this.income = income;
	}
	@Override
	public double getTax() {
		if (income <= 5000)
			return 0;
		else return (income - 5000) * 0.2;
	}
}
class stateConcilSpecialAllowance extends Income {
	double income;
	public stateConcilSpecialAllowance(double income) {
		super(income);
	}
	@Override
	public double getTax() {
		return 0;
	}
}