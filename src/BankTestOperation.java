
@FunctionalInterface
public interface BankTestOperation {
		void execute() throws InvalidAmountException, InsufficientFundsException;
}
