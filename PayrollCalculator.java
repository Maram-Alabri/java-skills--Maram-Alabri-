public class PayrollCalculator {
	public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate){
	if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid input values.");
            return 0.0;
        }
		 switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double overtime = hoursWorked - 40;
                    return (40 * hourlyRate) + (overtime * hourlyRate * 1.5);
                }
			case "PART_TIME":
			    if (hoursWorked > 25) hoursWorked = 25;
				return hoursWorked * hourlyRate;
			
			case "CONTRACTOR":
			    return hoursWorked * hourlyRate;
				
			case "INTERN":
			    if (hoursWorked > 20 ) hoursWorked = 20;
				return hoursWorked * hourlyRate * 0.8;
				
				default: 
				
				 System.out.println("Unknown employee type: " + employeeType);
                return 0.0;
		 	 }
} 
 public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0.0;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int count = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));

        double totalPay = 0.0;
        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String highestPaid = "", lowestPaid = "";
        int overtimeCount = 0;

        System.out.printf("%-10s %-12s %-6s %-6s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Gross", "Tax");

        for (int i = 0; i < count; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true); // assume all have insurance for now
            totalPay += gross;

            if (gross > maxPay) {
                maxPay = gross;
                highestPaid = names[i];
            }
            if (gross < minPay) {
                minPay = gross;
                lowestPaid = names[i];
            }
            if (hours[i] > 40) {
                overtimeCount++;
            }

            System.out.printf("%-10s %-12s %-6.1f %-6.2f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], rates[i], gross, tax);
        }

        double averagePay = totalPay / count;
        System.out.println("\nSummary:");
        System.out.println("Highest Paid: " + highestPaid + " ($" + maxPay + ")");
        System.out.println("Lowest Paid : " + lowestPaid + " ($" + minPay + ")");
        System.out.println("Average Pay : $" + String.format("%.2f", averagePay));
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        System.out.println("Testing single calculation:");
        double grossPay = calculateWeeklyPay("FULL_TIME", 45, 25.0);
        double tax = calculateTaxDeduction(grossPay, true);
        System.out.println("Gross: $" + grossPay + ", Tax: $" + tax + "\n");

        System.out.println("Processing full payroll:\n");
        processPayroll(types, hours, rates, names);
    }
}
				
				
			
