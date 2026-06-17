
/**
 * Write a description of class PremiumMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PremiumMember extends GymMember
{
    double paidAmount;
    final double premiumCharge;
    String personalTrainer;
    boolean isFullPayment;
    double discountAmount;
    public PremiumMember(int id, String name, String location, String phone, String email,
    String gender, String DOB, String membershipStartDate,
    String personalTrainer) {

        super(id, name, location, phone, email, gender, DOB, membershipStartDate); // now works!

        this.premiumCharge = 50000;
        this.paidAmount = 0;
        this.isFullPayment = false;
        this.discountAmount = 0;
        this.personalTrainer = personalTrainer;
    }

    public double getpremiumCharge()
    {
        return this.premiumCharge;
    }

    public String getpersonalTrainer()
    {
        return this.personalTrainer;
    }

    public boolean getisFullPayment()
    {
        return this.isFullPayment;
    }

    public double getpaidAmount()
    {
        return this.paidAmount;
    }

    public double getdiscountAmount()
    {
        return this.discountAmount;
    }

    double remainingAmount;

    public String payDueAmount(double paidAmount1) {
        if (isFullPayment) {
            return "Payment has already been completed.";
        }

        if (paidAmount1 <= 0) {
            return "Invalid payment amount.";
        }

        this.paidAmount += paidAmount1; 

        if (this.paidAmount > this.premiumCharge) {
            this.paidAmount -= paidAmount1;  // rollback
            return "Payment amount exceeds premium charge.";
        }

        remainingAmount = premiumCharge - this.paidAmount;

        if (remainingAmount == 0) {
            isFullPayment = true;
            return "Full payment completed. No remaining amount.";
        } else {
            isFullPayment = false;
            return "Partial payment received. Remaining amount: " + remainingAmount;
        }
    }

    public void calculateDiscount()
    {
        if(isFullPayment==true)
        {
            discountAmount=0.1*this.premiumCharge;//10% discount given
            System.out.println("Your discount is: " +discountAmount);
        }

        else
        {
            System.out.println("No discount allowed");
        }
    }    

    public void revertPremiumMember()
    {
        super.resetmember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0;
        discountAmount = 0;
    }

    public void markattendance()
    {
        attendance++;
        this.loyaltyPoints+=10;
    }

    public void displayPremiumMembers()
    {
        super.display();
        System.out.println("Personal Trainer : " + personalTrainer);
        System.out.println("Paid Amount : " + paidAmount);
        System.out.println("Full Payment : " + isFullPayment);
        System.out.println("Remaining Amount : " +remainingAmount);
        if(isFullPayment == true)
        {
            System.out.println("Discount Amount : " + discountAmount);
        }
    }
}

