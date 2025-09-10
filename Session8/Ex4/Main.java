package Session8.Ex4;public class Main {
    public static void main(String[] args) {
        BankAccount AccountA =new BankAccount("01", "Nguyễn Văn A", "0123456789");
        BankAccount AccountB =new BankAccount("02", "Nguyễn Văn B", "0123789456");

        // nạp tiền vào tài khoản A
        AccountA.deposit(1000);

        // Chuyển tiền từ tài khoản A sang B
        double trans = 300;
        AccountA.withdraw(trans);
        AccountB.deposit(trans);

        // Hiển thị số dư tài khoản
        AccountA.displayBallance();
        AccountB.displayBallance();

    }
}
