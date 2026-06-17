
/**
 * Write a description of class RegularMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegularMember extends GymMember
{
     private final int attendancelimit;
     private String removalreason , plan , referredby;
     private double price;
     private boolean isEligibleForUpgrade;
     //setting attirbute
     
    public RegularMember(int id, String name, String location, String phone, String email,
                     String gender, String DOB, String membershipStartDate, String referredBy){
         super(id , name , location , phone , email , gender , DOB, membershipStartDate); //calling the gymmember 
         this.attendancelimit=30;
         this.removalreason=removalreason;
         this.plan="basic";
         this.referredby=referredby;
         this.isEligibleForUpgrade=false;
         //giving value to attribute
     }
     
    public final int getattendancelimit(){
        return this.attendancelimit;
    }
    
    public String getremovalreason(){
        return this.removalreason;
    }
    
    public String getplan(){
        return this.plan;
    }
    
    public double getprice() {
    return this.price;
    }

    
    public String getreferredby(){
        return this.referredby;
    }
     
    public boolean getisEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }
    
    public void markattendance(){
        this.attendance++;
        this.loyaltyPoints+=5;
        if(getattendance()>=attendancelimit) {
            System.out.println("you have to re-subscribe or upgrade the plan");
            this.isEligibleForUpgrade=true;
        }
    }
    
    public double getplanprice(String plan){
        switch(plan.toLowerCase()){
            case"basic":
            return 6500;
            case"standard"://
            return 12500;
            case"deluxe" :
            return 18500;
            default : 
                return -1; // this is for invaild plans haru
        }
    }
    
    public String upgradePlan(String plan) {
    if (!isEligibleForUpgrade) {
        return "Member is not eligible to upgrade the plan.";
    }
    if (this.plan.equalsIgnoreCase(plan)) {
        return "Selected plan is the same as the current one.";
    }
    double newPrice = getplanprice(plan);
    if (newPrice == -1) {
        return "Invalid plan selected.";
    }
    this.plan = plan;         
    this.price = newPrice;    
    return "Plan upgraded to " + plan + " at price " + newPrice;    
    }

    
    public void revertRegularMember(String removalreason){
                        super.resetmember();
    this.isEligibleForUpgrade = false;
    this.plan = "basic";
    this.price = 6500; 
    this.removalreason=removalreason;
    }
    
    public void displayRegularMembers(){
                     super.display();
     System.out.println("Plan: " + plan);
     System.out.println("Price: " + price);
     System.out.println("Removal Reason: " + removalreason);  
    }
}
 