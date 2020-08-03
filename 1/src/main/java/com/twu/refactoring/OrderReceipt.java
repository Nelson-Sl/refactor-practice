package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;
    private static final double SALES_TAX_RATE = 0.1;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		printOrderHeader(output);
		printCustomerInformation(output, order);
		printLineItemsTotalAndSalesTax(output,order);

		return output.toString();
	}

	public static void printOrderHeader(StringBuilder output) {
		output.append("======Printing Orders======\n");
	}

	public static void printCustomerInformation(StringBuilder output, Order order) {
		//        output.append("Date - " + order.getDate();
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
		//        output.append(order.getCustomerLoyaltyNumber());
	}

	public static void printLineItemsTotalAndSalesTax(StringBuilder output, Order order) {
		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			addTab(output);
			output.append(lineItem.getPrice());
			addTab(output);
			output.append(lineItem.getQuantity());
			addTab(output);
			output.append(lineItem.totalAmount());
			switchLine(output);

			double salesTax = lineItem.totalAmount() * SALES_TAX_RATE;
			totalSalesTax += salesTax;

			total += lineItem.totalAmount() + salesTax;
		}

		printSalesTax(output,totalSalesTax);

		printTotalAmount(output, total);
	}

	private static void printSalesTax(StringBuilder output, double totalSalesTax) {
		output.append("Sales Tax").append('\t').append(totalSalesTax);
	}

	private static void printTotalAmount(StringBuilder output, double totalAmount) {
		output.append("Total Amount").append('\t').append(totalAmount);
	}

	private static void addTab(StringBuilder output) {
    	output.append("\t");
	}

	private static void switchLine(StringBuilder output) {
    	output.append("\n");
	}
}