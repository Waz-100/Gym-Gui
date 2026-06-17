
/**
 * Write a description of class GymMembe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract class GymMember{
    protected int id,attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    protected String name,location,phone,email,gender,DOB,membershipStartDate;

    public GymMember(int id, String name, String location, String phone, String email,
    String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;

        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = true;  // Members start active by default
    }

    public int getid(){
        return this.id;
    }

    public int getattendance()
    {
        return this.attendance;
    }

    public String getname()
    {
        return this.name;
    }

    public String getlocation()
    {
        return this.location;
    }

    public String getphone()
    {
        return this.phone;
    }

    public String getemail()
    {
        return this.email;
    }

    public String getgender()
    {
        return this.gender;
    }

    public String getDOB()
    {
        return this.DOB;
    }

    public String getmembershipStartDate()
    {
        return this.membershipStartDate;
    }

    public double getloyaltyPoints()
    {
        return this.loyaltyPoints;
    }

    public boolean getactiveStatus()
    {
        return this.activeStatus;
    }

    abstract void markattendance();

    public void activatemembership(){
        this.activeStatus=true;
        System.out.println("congrats man you one of the boys");
        if( this.activeStatus=true) {
            System.out.println("you already in the house dwag");
        }
    }

    public void deactivatemembership(){
        this.activeStatus=false;
        System.out.println("Thanks for sweating with us see you");
        if( this.activeStatus=false) {
            System.out.println("you are already deactivated");
        }
    }

    public void resetmember(){
        this.activeStatus=false;
        this.attendance=0;
        this.loyaltyPoints=0;
    }

    public void display()
    {
        System.out.println("Member id: " +id);
        System.out.println("Member name: " +name);
        System.out.println("Member location: "+location);
        System.out.println("Member phone: "+phone);
        System.out.println("Member email: "+email);
        System.out.println("Member gender: " +gender);
        System.out.println("Member Date of Birth: " +DOB);
        System.out.println("Membership purchase date: " +membershipStartDate);
        System.out.println("Member attendance score: " +attendance);
        System.out.println("Member loyalty points: " +loyaltyPoints);
        System.out.println("Member activity status: " +activeStatus);
    }
}
