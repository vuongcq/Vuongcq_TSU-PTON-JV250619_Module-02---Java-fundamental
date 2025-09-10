package Session8.Ex4;

public class BankAccount implements IBank {
    private String acccountId;
    private double balance;
    private String userName;
    private String phoneNumber;
    private double amount;

    // Constructor
    public BankAccount (String acccountId, String userName, String phoneNumber){
        this.acccountId =acccountId;
        this.userName =userName;
        this.phoneNumber = phoneNumber;
    }

    // ghi đè phương thức deposit()
    @Override
    public void deposit (double amount){
        balance =balance + amount;
        System.out.printf("Đã nhận tiền: %.1f \n", amount);
//        System.out.printf("Số dư tài khoản: %.1f \n", balance);
    }

    @Override
    public void withdraw (double amount){
        if (amount< balance){
            balance =balance - amount;
            System.out.printf("Đã rút tiền: %.1f \n", amount);
//            System.out.printf("Số dư tài khoản: %.1f \n", balance);

        } else {
            System.out.println("Số dư không đủ.");
        }
    }

    // hiển thị số dư
    public void displayBallance (){
        System.out.printf("Số dư tài khoản (%s): %.1f \n", acccountId, balance);
    }

    public String getAcccountId() {
        return acccountId;
    }

    public void setAcccountId(String acccountId) {
        this.acccountId = acccountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
