package entities;

public class ImportedProduct extends Product{
	private double customsFee;
	
	public ImportedProduct(){
	}

	public ImportedProduct(String name, Double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName() +
				" $ " +
				String.format("%.2f",  getPrice()+ customsFee) +
				" (Custom fee: $ " +
				String.format("%.2f", customsFee) +
				")";
	}
}
