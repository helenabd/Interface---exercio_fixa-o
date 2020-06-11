package modal.services;

import java.time.LocalDate;

import modal.entities.Contract;
import modal.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double parcela = contract.getTotalValue() / months;
		for(int i=1; i<=months; i++) {
			LocalDate date = addMonths(contract.getDate(), i);
			double updateParcela = parcela + onlinePaymentService.interest(parcela, i);
			double parcelaTotal = updateParcela + onlinePaymentService.paymentFee(updateParcela);
			contract.addInstallment(new Installment(date, parcelaTotal));
		}
	}
	
	public LocalDate addMonths(LocalDate date, int n) {
		LocalDate cal = date;
		cal = cal.plusMonths(n);
		return cal;
	}
}
