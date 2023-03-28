package entities;

public class TaxPayer {
    
    private double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;
    
    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        double rendaMensal = salaryIncome / 12;
        if (rendaMensal <= 3000.0) {
            return 0;
        }
        else if (rendaMensal >= 3000.0 && rendaMensal <= 5000.0) {
            return salaryIncome * 0.10;
        }
        else {
            return salaryIncome * 0.20;
        }
    }

    public double servicesTax() {
        return servicesIncome * 0.15;
    }

    public double capitalTax() {
        return capitalIncome * 0.20;
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax(); 
    }

    public double taxRebate() {
        double test = healthSpending + educationSpending;
        double result = grossTax() * 0.30;
        return Math.min(test, result);
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }

    public String toString() {
        return "Imposto bruto total: " + String.format("%.2f\n", grossTax())
                + "Abatimento: " + String.format("%.2f\n", taxRebate())
                + "Imposto devido: " + String.format("%.2f\n", netTax());
    }
}
