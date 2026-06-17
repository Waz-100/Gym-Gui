


/**
 * Write a description of class GymGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class GymGui implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // Clear Regular Member form fields
        if (src == cle1) {
            idf.setText("");
            namef.setText("");
            locof.setText("");
            phonef.setText("");
            emailf.setText("");
            group.clearSelection(); // clear gender radio buttons
            yer.setSelectedItem(null); // clear date of birth combo boxes
            mon.setSelectedItem(null);
            day.setSelectedItem(null);
            yer1.setSelectedItem(null); // clear membership start date combo boxes
            mon1.setSelectedItem(null);
            day1.setSelectedItem(null);
            reff.setText("");
            trainf.setText("");
            remf.setText("");
            JOptionPane.showMessageDialog(null, "Clean up duty done", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        // Clear Premium Member form fields
        if (src == cle) {
            idf.setText("");
            namef.setText("");
            locof.setText("");
            phonef.setText("");
            emailf.setText("");
            group.clearSelection();
            yer.setSelectedItem(null);
            mon.setSelectedItem(null);
            day.setSelectedItem(null);
            yer1.setSelectedItem(null);
            mon1.setSelectedItem(null);
            day1.setSelectedItem(null);
            reff.setText("");
            trainf.setText("");
            remf.setText("");
            bux.setSelectedItem(null); // clear plan selection
            JOptionPane.showMessageDialog(null, "Clean up duty done ,  my king ", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        // Navigation buttons: switch between screens
        if (src == but4) { 
            frame.dispose();
            premium(); 
        }
        if (src == but2) { frame.dispose(); 
            regular();
        }
        if (src == hom)  { 
            frame.dispose(); 
            home();   
        }
        if (src == but5) { 
            frame1.dispose(); 
            premium(); 
        }
        if (src == but6) { 
            frame1.dispose(); 
            regular(); 
        }

        // Revert Regular Member to Basic Plan
        if (src == rev) {
            if (idf.getText().isEmpty() || remf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID and reason", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof RegularMember) {
                            RegularMember rm = (RegularMember) m;
                            rm.revertRegularMember(remf.getText().trim());
                            JOptionPane.showMessageDialog(null, "Regular member reverted to basic plan");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Regular member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Remove Regular Member
        if (src == rem) {
            if (idf.getText().isEmpty() || remf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter ID and reason to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof RegularMember) {
                            arr.remove(i);
                            JOptionPane.showMessageDialog(null, "Bye bye hope you find a better gym", "Info", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Regular member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Revert Premium Member (reset payment and trainer info)
        if (src == revp) {
            if (idf.getText().isEmpty() || remf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID and reason", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) m;
                            pm.revertPremiumMember();
                            JOptionPane.showMessageDialog(null, "MYY KINGG your wish is my command you have been REVERTED");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Premium member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Remove Premium Member
        if (src == remp) {
            if (idf.getText().isEmpty() || remf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter ID and reason to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            arr.remove(i);
                            JOptionPane.showMessageDialog(null, "BYE BYE MY KINGGGGGGG", "Info", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Premium member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Activate Membership
        if (src == acti) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum) {
                            m.activatemembership();
                            JOptionPane.showMessageDialog(null, "Welcome to the club");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Deactivate Membership
        if (src == deac) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum) {
                            m.deactivatemembership();
                            JOptionPane.showMessageDialog(null, "See ya later alligator");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Add Regular Member
        if (src == but) {
            if (idf.getText().isEmpty() || namef.getText().isEmpty() || locof.getText().isEmpty() ||
            phonef.getText().isEmpty() || emailf.getText().isEmpty() || reff.getText().isEmpty() ||
            yer.getSelectedItem() == null || mon.getSelectedItem() == null || day.getSelectedItem() == null ||
            yer1.getSelectedItem() == null || mon1.getSelectedItem() == null || day1.getSelectedItem() == null ||
            (!male.isSelected() && !fem.isSelected() && !lg.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    // Check duplicate ID
                    boolean exists = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getid() == idNum) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        JOptionPane.showMessageDialog(null, "ID already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String gender = male.isSelected() ? "Male" : fem.isSelected() ? "Female" : "Other";
                    String dob = yer.getSelectedItem() + "-" + mon.getSelectedItem() + "-" + day.getSelectedItem();
                    String startDate = yer1.getSelectedItem() + "-" + mon1.getSelectedItem() + "-" + day1.getSelectedItem();
                    RegularMember newMember = new RegularMember(
                            idNum,
                            namef.getText().trim(),
                            locof.getText().trim(),
                            phonef.getText().trim(),
                            emailf.getText().trim(),
                            gender,
                            dob,
                            startDate,
                            reff.getText().trim()
                        );
                    arr.add(newMember);
                    JOptionPane.showMessageDialog(null, "Regular member added successfully looks like another joins the party", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Add Premium Member
        if (src == but1) {
            if (idf.getText().isEmpty() || namef.getText().isEmpty() || locof.getText().isEmpty() ||
            phonef.getText().isEmpty() || emailf.getText().isEmpty() || trainf.getText().isEmpty() ||
            yer.getSelectedItem() == null || mon.getSelectedItem() == null || day.getSelectedItem() == null ||
            yer1.getSelectedItem() == null || mon1.getSelectedItem() == null || day1.getSelectedItem() == null ||
            (!male.isSelected() && !fem.isSelected() && !lg.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    // Check duplicate ID
                    boolean exists = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getid() == idNum) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        JOptionPane.showMessageDialog(null, "ID already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String gender = male.isSelected() ? "Male" : fem.isSelected() ? "Female" : "Other";
                    String dob = yer.getSelectedItem() + "-" + mon.getSelectedItem() + "-" + day.getSelectedItem();
                    String startDate = yer1.getSelectedItem() + "-" + mon1.getSelectedItem() + "-" + day1.getSelectedItem();
                    PremiumMember newMember = new PremiumMember(
                            idNum,
                            namef.getText().trim(),
                            locof.getText().trim(),
                            phonef.getText().trim(),
                            emailf.getText().trim(),
                            gender,
                            dob,
                            startDate,
                            trainf.getText().trim()
                        );
                    arr.add(newMember);
                    JOptionPane.showMessageDialog(null, "KING member added successfully Welcome to your PAlace", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Mark attendance for Regular Member
        if (src == mark) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof RegularMember) {
                            ((RegularMember)m).markattendance();
                            JOptionPane.showMessageDialog(null, "Present Sir", "Info", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Regular member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Mark attendance for Premium Member
        if (src == markp) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            ((PremiumMember)m).markattendance();
                            JOptionPane.showMessageDialog(null, "My KING you have blessed us with your presences", "Info", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "KING member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Upgrade plan for Regular Member
        if (src == upg) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    String selectedPlan = ((String) bux.getSelectedItem()).toLowerCase();
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof RegularMember) {
                            RegularMember rm = (RegularMember) m;
                            if (!rm.getactiveStatus()) {
                                JOptionPane.showMessageDialog(null, "Member is not active and cannot upgrade", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else {
                                rm.upgradePlan(selectedPlan);
                                JOptionPane.showMessageDialog(null, "Plan upgraded");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Regular member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Pay due amount for Premium Member
        if (src == pay) {
            if (idf.getText().isEmpty() || payf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID and amount", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    double amount = Double.parseDouble(payf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) m;
                            pm.payDueAmount(amount);
                            JOptionPane.showMessageDialog(null, "Payment received", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Premium member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for ID or amount", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Calculate discount for Premium Member
        if (src == disc) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) m;
                            pm.calculateDiscount();
                            double discount = pm.getdiscountAmount();
                            if (discount > 0) {
                                JOptionPane.showMessageDialog(null, "Discount: " + discount);
                            } else {
                                JOptionPane.showMessageDialog(null, "No discount applicable", "Info", JOptionPane.INFORMATION_MESSAGE);
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Premium member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Display Regular Member Details
        if (src == dis) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof RegularMember) {
                            showRegularMemberDetails((RegularMember) m);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Regular member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Display Premium Member Details
        if (src == disp) {
            if (idf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int idNum = Integer.parseInt(idf.getText().trim());
                    boolean found = false;
                    for (int i = 0; i < arr.size(); i++) {
                        GymMember m = arr.get(i);
                        if (m.getid() == idNum && m instanceof PremiumMember) {
                            showPremiumMemberDetails((PremiumMember) m);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Premium member not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        // **Save to File (all members)**
        if (src == sav || src == savp) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("MemberDetails.txt"));
                for (GymMember m : arr) {
                    if (m instanceof RegularMember) {
                        RegularMember rm = (RegularMember) m;
                        bw.write("Regular Member"); bw.newLine();
                        bw.write("ID: " + rm.getid()); bw.newLine();
                        bw.write("Name: " + rm.getname()); bw.newLine();
                        bw.write("Location: " + rm.getlocation()); bw.newLine();
                        bw.write("Phone: " + rm.getphone()); bw.newLine();
                        bw.write("Email: " + rm.getemail()); bw.newLine();
                        bw.write("Plan: " + rm.getplan()); bw.newLine();
                        bw.write("Referred By: " + rm.getreferredby()); bw.newLine();
                        bw.write("Eligible For Upgrade: " + rm.getisEligibleForUpgrade()); bw.newLine();
                        bw.write("Attendance: " + rm.getattendance()); bw.newLine();
                        bw.write("Loyalty Points: " + rm.loyaltyPoints); bw.newLine();
                        bw.write("Active: " + rm.getactiveStatus()); bw.newLine();
                        bw.write("-------------------------------"); bw.newLine();
                    } else if (m instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) m;
                        bw.write("Premium Member"); bw.newLine();
                        bw.write("ID: " + pm.getid()); bw.newLine();
                        bw.write("Name: " + pm.getname()); bw.newLine();
                        bw.write("Location: " + pm.getlocation()); bw.newLine();
                        bw.write("Phone: " + pm.getphone()); bw.newLine();
                        bw.write("Email: " + pm.getemail()); bw.newLine();
                        bw.write("Personal Trainer: " + pm.personalTrainer); bw.newLine();
                        bw.write("Paid Amount: " + pm.paidAmount); bw.newLine();
                        bw.write("Full Payment: " + pm.isFullPayment); bw.newLine();
                        bw.write("Remaining Amount: " + pm.remainingAmount); bw.newLine();
                        bw.write("Discount Amount: " + pm.discountAmount); bw.newLine();
                        bw.write("Attendance: " + pm.attendance); bw.newLine();
                        bw.write("Loyalty Points: " + pm.loyaltyPoints); bw.newLine();
                        bw.write("-------------------------------"); bw.newLine();
                    }
                }
                bw.close();
                JOptionPane.showMessageDialog(null, "Member details saved to file.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving to file: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
                // **Read from File (display file contents)**
        if (src == read) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("MemberDetails.txt"));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                br.close();
                JFrame fileFrame = new JFrame("Member Details");
                JTextArea ta = new JTextArea(content.toString());
                ta.setEditable(false);
                JScrollPane sp = new JScrollPane(ta);
                fileFrame.add(sp);
                fileFrame.setSize(400, 400);
                fileFrame.setLocationRelativeTo(null);
                fileFrame.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        
    }


    ArrayList<GymMember> arr=new ArrayList<GymMember>();
    private JLabel warning;
    private JLabel idWarning;
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private JButton but;
    private JButton but1;
    private JLabel slash;
    private JComboBox bux;
    private JLabel reg;
    private JLabel bord;
    private JLabel bord1;
    private JLabel bord2;
    private JLabel bord3;
    private JLabel bord4;
    private JLabel bord5;
    private JLabel bord6;
    private JLabel bio;
    private JLabel name;
    private JTextField namef;
    private JLabel id;
    private JTextField idf;
    private JLabel dob;
    private JTextField dobf;
    private JLabel loco;
    private JTextField  locof;
    private JLabel email;
    private JTextField  emailf;
    private JLabel ref;
    private JTextField  reff;
    private JLabel phone;
    private JTextField phonef;
    private JLabel train;
    private JTextField trainf;
    private JLabel gend;
    private JRadioButton male;
    private JRadioButton fem;
    private JRadioButton lg;
    private JButton acti;
    private JLabel mem;
    private JComboBox yer;
    private JComboBox mon;
    private JComboBox day;
    private JButton deac;
    private JLabel bas;
    private JLabel stan;
    private JLabel del;
    private JTextField basf;
    private JTextField stanf;
    private JTextField delf;
    private JButton dis;
    private JButton disp;
    private JButton rev;
    private JButton revp;
    private JButton sav;
    private JButton savp;
    private JButton hom;
    private JButton rem;
    private JButton remp;
    private JButton cle;
    private JButton upg;
    private JTextField remf;
    private JLabel remv;
    private JButton mark;
    private JButton markp;
    private ButtonGroup group;
    private JComboBox yer1;
    private JComboBox mon1;
    private JComboBox day1;
    private JButton but2;
    private JButton but4;
    private JFrame frame1;
    private JPanel panel1;
    private JButton disc;
    private JButton pay;
    private JTextField payf;
    private JButton read;

    public void regular(){
        this.frame = new JFrame();
        frame.setTitle("GYm.exe");
        frame.setSize(1600, 750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 1600, 750);
        panel.setBackground(Color.gray);
        panel.setLayout(null);

        label = new JLabel("GYM ARK");
        label.setBounds(10, 10, 250, 50);
        label.setFont(new Font("Monospaced", Font.BOLD, 50));

        slash =  new JLabel("/");
        slash.setBounds(910, 10, 55, 55);
        slash.setFont(new Font("SansSerif", Font.BOLD, 45));

        bio = new JLabel("Bio Data of MemberShip");
        bio.setBounds(750, 90, 400, 40);
        bio.setFont(new Font("SansSerif", Font.BOLD, 30));

        name =  new JLabel("Name");
        name.setBounds(500, 170, 50, 40);
        name.setFont(new Font("Monospaced", Font.BOLD, 15));

        namef = new JTextField();
        namef.setBounds(560, 170, 100, 40);

        id =  new JLabel("ID");
        id.setBounds(500, 220, 50, 40);
        id.setFont(new Font("Monospaced", Font.BOLD, 15));

        idf = new JTextField();
        idf.setBounds(560, 220, 100, 40);

        email =  new JLabel("Email");
        email.setBounds(750, 220, 50, 40);
        email.setFont(new Font("Monospaced", Font.BOLD, 15));

        emailf =  new JTextField();
        emailf.setBounds(810, 220, 100, 40);

        warning = new JLabel("Please fill in all required fields!");
        warning.setForeground(Color.RED);
        warning.setBounds(500, 550, 300, 30);  
        warning.setVisible(false);
        panel.add(warning);

        idWarning = new JLabel("ID must be a number!");
        idWarning.setForeground(Color.RED);
        idWarning.setBounds(500, 580, 200, 30); 
        idWarning.setVisible(false);
        panel.add(idWarning);

        dob = new JLabel("DOB");
        dob.setBounds(440, 270, 30, 40);
        dob.setFont(new Font("Monospaced", Font.BOLD, 15));

        String [] Year = {"2010","2009","2008","2007","2006","2005","2004","2003","2002",
                "2001","2000","1999","1998","1997","1996","1995","1994","1993",
                "1992","1991","1990"};
        yer = new JComboBox(Year);
        yer.setBounds(475, 270,80 , 40);

        String [] Month = {"January","Feburary","March","April","May","June"
            ,"July", "August", "September","October","November","December"};
        mon= new JComboBox(Month);
        mon.setBounds(555, 270, 80, 40);

        String [] Day = { "1", "2", "3", "4", "5", "6", "7" ,"8", "9" ,"10"
            ,"11", "12", "13", "14", "15", "16" ,"17", "18" ,"19" ,"20" 
            ,"21" ,"22" ,"23" ,"24", "25", "26" ,"27", "28" ,"29", "30", "31"};
        day = new JComboBox(Day);
        day.setBounds(635, 270, 40, 40);

        gend = new JLabel("Gender");
        gend.setBounds(510, 330, 60, 40);
        gend.setFont(new Font("Monospaced", Font.BOLD, 15));

        acti = new JButton("ActivateMembership");
        acti.setBounds(1100, 335, 200, 50);

        deac = new JButton("DeactivateMembership");
        deac.setBounds(1100, 385, 200, 50);

        dis = new JButton("DISPLAY");
        dis.setBounds(1100, 435, 200, 50);
        dis.setFont(new Font("Monospaced", Font.BOLD, 20));

        rev = new JButton("REVERT R");
        rev.setBounds(1100, 485, 200, 50);
        rev.setFont(new Font("Monospaced", Font.BOLD, 20));

        //MEMBER SHIP JOINED

        mem = new JLabel("Membership Join Date");
        mem.setBounds(510, 390, 200, 40);
        mem.setFont(new Font("Monospaced", Font.BOLD, 15));

        String [] Year1 = {"2025","2024","2023","2022","2021","2020","2019"
            ,"2018","2017","2016","2015","2014","2013","2012","2011",
                "2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};
        yer1 = new JComboBox(Year1);
        yer1.setBounds(710, 390,80 , 40);

        String [] Month1 = {"January","Feburary","March","April","May","June"
            ,"July", "August", "September","October","November","December"};
        mon1= new JComboBox(Month1);
        mon1.setBounds(790, 390, 100, 40);

        String [] Day1 = { "1", "2", "3", "4", "5", "6", "7" ,"8", "9" ,"10"
            ,"11", "12", "13", "14", "15", "16" ,"17", "18" ,"19" ,"20" 
            ,"21" ,"22" ,"23" ,"24", "25", "26" ,"27", "28" ,"29", "30", "31"};
        day1 = new JComboBox(Day1);
        day1.setBounds(890, 390, 80, 40);

        //GENDER  

        group = new ButtonGroup();

        male =  new JRadioButton("male");
        male.setBounds(580, 340, 70, 20);
        group.add(male);

        fem =  new JRadioButton("female");
        fem.setBounds(660, 340, 80, 20);
        group.add(fem);

        lg = new JRadioButton("LGBTQ+");
        lg.setBounds(750, 340, 80, 20);
        group.add(lg);

        //OTHER

        ref = new JLabel("referral by");
        ref.setBounds(690, 270, 120, 40);
        ref.setFont(new Font("Monospaced", Font.BOLD, 16));

        reff = new JTextField();
        reff.setBounds(810, 270, 100, 40);

        loco = new JLabel("Location");
        loco.setBounds(720, 170, 80, 40);
        loco.setFont(new Font("Monospaced", Font.BOLD, 16));

        locof = new JTextField();
        locof.setBounds(810, 170, 100, 40);

        phone = new JLabel("Phone");
        phone.setBounds(1000, 170, 60, 40);
        phone.setFont(new Font("Monospaced", Font.BOLD, 16));

        phonef = new JTextField();
        phonef.setBounds(1060, 170, 100, 40);

        train = new JLabel("Trained By");
        train.setBounds(950, 230, 100, 40);
        train.setFont(new Font("Monospaced", Font.BOLD, 16));

        trainf = new JTextField();
        trainf.setBounds(1060, 230, 100, 40);

        but = new JButton("ADD a Regular Member");
        but.setBounds(470, 10, 400, 50);
        but.setFont(new Font("SansSerif", Font.BOLD, 19));

        but4 = new JButton("Change to Premium Member");
        but4.setBounds(970, 10, 400, 50);
        but4.setFont(new Font("SansSerif", Font.BOLD, 19));

        remf = new JTextField();
        remf.setBounds(670, 445, 400, 50);

        remv = new JLabel("Removal Reason");
        remv.setBounds(530, 445, 150, 50);
        remv.setFont(new Font("Monospaced", Font.BOLD, 15));

        //remaining Buttons

        sav = new JButton("Save to File");
        sav.setBounds(220, 420, 150, 60);
        sav.setFont(new Font("SansSerif", Font.BOLD, 17));

        hom = new JButton("<= Home");
        hom.setBounds(20, 75, 150, 50);
        hom.setFont(new Font("SansSerif", Font.BOLD, 20));

        cle = new JButton("CLEAR!!");
        cle.setBounds(1302, 385, 200, 50);
        cle.setFont(new Font("Monospaced", Font.BOLD, 20));

        upg = new JButton("Upgrade the plan");
        upg.setBounds(1302, 435, 200, 50);

        rem = new JButton("Remove MemberShip");
        rem.setBounds(710, 505, 200, 50);
        rem.setFont(new Font("Monospaced", Font.BOLD, 15));

        mark = new JButton("Mark Attendance");
        mark.setBounds(710, 605, 200, 70);
        mark.setFont(new Font("Monospaced", Font.BOLD, 17));

        read = new JButton("Read from File");
        read.setBounds(505, 625, 200, 50);
        read.setFont(new Font("Monospaced", Font.BOLD, 17));

        //THE BOX

        reg =  new JLabel("REGULAR MEMEBERSHIP");
        reg.setBounds(10, 185, 400, 50);
        reg.setFont(new Font("SansSerif", Font.BOLD, 30));

        bas = new JLabel("Basic =");
        bas.setBounds(10, 270, 90, 40);
        bas.setFont(new Font("Monospaced", Font.BOLD, 18));

        stan = new JLabel("Standard =");
        stan.setBounds(5, 330, 110, 40);
        stan.setFont(new Font("Monospaced", Font.BOLD, 18));

        del = new JLabel("Deluxe =");
        del.setBounds(10, 390, 90, 40);
        del.setFont(new Font("Monospaced", Font.BOLD, 18));

        basf =  new JTextField("6500");
        basf.setBounds(110, 270, 50,  50);
        basf.setEditable(false);

        stanf = new JTextField("8500");
        stanf.setBounds(110, 330, 50, 50);
        stanf.setEditable(false);

        delf = new JTextField("12500");
        delf.setBounds(110, 390, 50, 50);
        delf.setEditable(false);

        String[] plan = {"Basic","Standard","Deluxe"};

        bux = new JComboBox(plan);
        bux.setBounds(220, 250, 150, 50);
        bux.setFont(new Font("SansSerif", Font.BOLD, 20));

        //decoration
        bord = new JLabel("|");
        bord.setBounds(430, 190, 40, 55);
        bord.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord1= new JLabel("|");
        bord1.setBounds(430, 270, 40, 55);
        bord1.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord2= new JLabel("- - - - - - - - - - - - - - ");
        bord2.setBounds(10, 500, 450, 40);
        bord2.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord3= new JLabel("- - - - - - - - - - - - - - ");
        bord3.setBounds(10, 130, 450, 40);
        bord3.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord4= new JLabel("|");
        bord4.setBounds(430, 350, 40, 55);
        bord4.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord5= new JLabel("|");
        bord5.setBounds(430, 430, 40, 55);
        bord5.setFont(new Font("SansSerif", Font.BOLD, 50));     

        but.addActionListener(this);
        but4.addActionListener(this);
        acti.addActionListener(this);
        deac.addActionListener(this);
        dis.addActionListener(this);
        rev.addActionListener(this);
        sav.addActionListener(this);
        hom.addActionListener(this);
        cle.addActionListener(this);
        upg.addActionListener(this);
        rem.addActionListener(this);
        mark.addActionListener(this);
        read.addActionListener(this);
        panel.add(read);
        panel.add(mark);
        panel.add(rem);
        panel.add(remf);
        panel.add(remv);
        panel.add(sav);
        panel.add(train);
        panel.add(trainf);
        panel.add(hom);
        panel.add(upg);
        panel.add(cle);
        panel.add(dis);
        panel.add(rev);
        panel.add(delf);
        panel.add(stanf);
        panel.add(basf);
        panel.add(stan);
        panel.add(del);
        panel.add(bas);
        panel.add(deac);
        panel.add(acti);
        panel.add(bord4);
        panel.add(bord5);
        panel.add(day);
        panel.add(mem);
        panel.add(yer);
        panel.add(mon);
        panel.add(gend);
        panel.add(male);
        panel.add(lg);
        panel.add(fem);
        panel.add(phonef);
        panel.add(phone);
        panel.add(reff);
        panel.add(ref);
        panel.add(bord3);
        panel.add(email);
        panel.add(emailf);
        panel.add(loco);
        panel.add(locof);
        panel.add(dob);
        panel.add(yer1);
        panel.add(mon1);
        panel.add(day1);
        panel.add(id);
        panel.add(idf);
        panel.add(name);
        panel.add(namef);
        panel.add(bio);
        panel.add(bord2);
        panel.add(bord1);
        panel.add(bord);
        panel.add(bux);
        panel.add(reg);
        panel.add(slash);
        panel.add(but4);
        panel.add(but);
        panel.add(label);
        frame.add(panel);

    }
    private JButton cle1;

    public void premium(){
        this.frame = new JFrame();
        frame.setTitle("GYm.exe");
        frame.setSize(1600, 750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //rgb cause more color variation
        Color wa = new Color(241, 212, 123);

        panel = new JPanel();
        panel.setBounds(0, 0, 1600, 750);
        panel.setBackground(wa);
        panel.setLayout(null);

        label = new JLabel("GYM ARK");
        label.setBounds(10, 10, 250, 50);
        label.setFont(new Font("Monospaced", Font.BOLD, 50));

        slash =  new JLabel("/");
        slash.setBounds(910, 10, 55, 55);
        slash.setFont(new Font("SansSerif", Font.BOLD, 45));

        bio = new JLabel("Bio Data of MemberShip");
        bio.setBounds(750, 90, 400, 40);
        bio.setFont(new Font("SansSerif", Font.BOLD, 30));

        name =  new JLabel("Name");
        name.setBounds(500, 170, 50, 40);
        name.setFont(new Font("Monospaced", Font.BOLD, 15));

        namef = new JTextField();
        namef.setBounds(560, 170, 100, 40);

        id =  new JLabel("ID");
        id.setBounds(500, 220, 50, 40);
        id.setFont(new Font("Monospaced", Font.BOLD, 15));

        idf = new JTextField();
        idf.setBounds(560, 220, 100, 40);

        warning = new JLabel("Please fill in all required fields!");
        warning.setForeground(Color.RED);
        warning.setBounds(500, 550, 300, 30);  
        warning.setVisible(false);
        panel.add(warning);

        idWarning = new JLabel("ID must be a number!");
        idWarning.setForeground(Color.RED);
        idWarning.setBounds(500, 580, 200, 30); 
        idWarning.setVisible(false);
        panel.add(idWarning);

        email =  new JLabel("Email");
        email.setBounds(750, 220, 50, 40);
        email.setFont(new Font("Monospaced", Font.BOLD, 15));

        emailf =  new JTextField();
        emailf.setBounds(810, 220, 100, 40);

        dob = new JLabel("DOB");
        dob.setBounds(440, 270, 30, 40);
        dob.setFont(new Font("Monospaced", Font.BOLD, 15));

        String [] Year = {"2010","2009","2008","2007","2006","2005","2004","2003","2002",
                "2001","2000","1999","1998","1997","1996","1995","1994","1993",
                "1992","1991","1990"
            };
        yer = new JComboBox(Year);
        yer.setBounds(475, 270,80 , 40);

        String [] Month = {"January","Feburary","March","April","May","June"
            ,"July", "August", "September","October","November","December"};
        mon= new JComboBox(Month);
        mon.setBounds(555, 270, 80, 40);

        String [] Day = { "1", "2", "3", "4", "5", "6", "7" ,"8", "9" ,"10"
            ,"11", "12", "13", "14", "15", "16" ,"17", "18" ,"19" ,"20" 
            ,"21" ,"22" ,"23" ,"24", "25", "26" ,"27", "28" ,"29", "30", "31"};
        day = new JComboBox(Day);
        day.setBounds(635, 270, 40, 40);

        gend = new JLabel("Gender");
        gend.setBounds(510, 330, 60, 40);
        gend.setFont(new Font("Monospaced", Font.BOLD, 15));

        acti = new JButton("ActivateMembership");
        acti.setBounds(1100, 335, 200, 50);

        deac = new JButton("DeactivateMembership");
        deac.setBounds(1100, 385, 200, 50);

        disp = new JButton("DISPLAY");
        disp.setBounds(1100, 435, 200, 50);
        disp.setFont(new Font("Monospaced", Font.BOLD, 20));

        revp = new JButton("REVERT P");
        revp.setBounds(1100, 485, 200, 50);
        revp.setFont(new Font("Monospaced", Font.BOLD, 20));

        //MEMBER SHIP JOINED

        mem = new JLabel("Membership Join Date");
        mem.setBounds(510, 390, 200, 40);
        mem.setFont(new Font("Monospaced", Font.BOLD, 15));

        String [] Year1 = {"2025","2024","2023","2022","2021","2020","2019","2018","2017","2016",
                "2015","2014","2013","2012","2011","2010","2009",
                "2008","2007","2006","2005","2004","2003","2002","2001","2000"};
        yer1 = new JComboBox(Year1);
        yer1.setBounds(710, 390,80 , 40);

        String [] Month1 = {"January","Feburary","March","April","May","June"
            ,"July", "August", "September","October","November","December"};
        mon1= new JComboBox(Month1);
        mon1.setBounds(790, 390, 100, 40);

        String [] Day1 = { "1", "2", "3", "4", "5", "6", "7" ,"8", "9" ,"10"
            ,"11", "12", "13", "14", "15", "16" ,"17", "18" ,"19" ,"20" 
            ,"21" ,"22" ,"23" ,"24", "25", "26" ,"27", "28" ,"29", "30", "31"};
        day1 = new JComboBox(Day1);
        day1.setBounds(890, 390, 80, 40);

        //GENDER  
        group = new ButtonGroup();
        male =  new JRadioButton("male");
        male.setBounds(580, 340, 70, 20);
        group.add(male);

        fem =  new JRadioButton("female");
        fem.setBounds(660, 340, 80, 20);
        group.add(fem);

        lg = new JRadioButton("LGBTQ+");
        lg.setBounds(750, 340, 80, 20);
        group.add(lg);

        //OTHER
        ref = new JLabel("referral by");
        ref.setBounds(690, 270, 120, 40);
        ref.setFont(new Font("Monospaced", Font.BOLD, 16));

        reff = new JTextField();
        reff.setBounds(810, 270, 100, 40);

        loco = new JLabel("Location");
        loco.setBounds(720, 170, 80, 40);
        loco.setFont(new Font("Monospaced", Font.BOLD, 16));

        locof = new JTextField();
        locof.setBounds(810, 170, 100, 40);

        phone = new JLabel("Phone");
        phone.setBounds(1000, 170, 60, 40);
        phone.setFont(new Font("Monospaced", Font.BOLD, 16));

        phonef = new JTextField();
        phonef.setBounds(1060, 170, 100, 40);

        train = new JLabel("Trained By");
        train.setBounds(950, 230, 100, 40);
        train.setFont(new Font("Monospaced", Font.BOLD, 16));

        trainf = new JTextField();
        trainf.setBounds(1060, 230, 100, 40);

        but2 = new JButton("Change to Regular Member");
        but2.setBounds(470, 10, 400, 50);
        but2.setFont(new Font("SansSerif", Font.BOLD, 19));

        but1 = new JButton("Add a Premium Member");
        but1.setBounds(970, 10, 400, 50);
        but1.setFont(new Font("SansSerif", Font.BOLD, 19));

        remf = new JTextField();
        remf.setBounds(670, 445, 400, 50);

        remv = new JLabel("Removal Reason");
        remv.setBounds(530, 445, 150, 50);
        remv.setFont(new Font("Monospaced", Font.BOLD, 15));

        //remaining Buttons

        savp = new JButton("Save to File");
        savp.setBounds(140, 450, 150, 60);
        savp.setFont(new Font("SansSerif", Font.BOLD, 17));

        read = new JButton("Read from File");
        read.setBounds(120, 390, 200, 50);
        read.setFont(new Font("Monospaced", Font.BOLD, 17));

        hom = new JButton("<= Home");
        hom.setBounds(20, 75, 150, 50);
        hom.setFont(new Font("SansSerif", Font.BOLD, 20));

        cle1 = new JButton("CLEAR!!");
        cle1.setBounds(1302, 385, 200, 50);
        cle1.setFont(new Font("Monospaced", Font.BOLD, 20));

        upg = new JButton("Upgrade the plan");
        upg.setBounds(1302, 435, 200, 50);

        remp = new JButton("Remove MemberShip");
        remp.setBounds(710, 505, 200, 50);
        remp.setFont(new Font("Monospaced", Font.BOLD, 15));

        markp = new JButton("Mark Attendance");
        markp.setBounds(710, 605, 200, 70);
        markp.setFont(new Font("Monospaced", Font.BOLD, 17));

        disc = new JButton("Discount");
        disc.setBounds(460, 605, 200, 70);
        disc.setFont(new Font("Monospaced", Font.BOLD, 17));

        pay = new JButton("Pay Amount");
        pay.setBounds(960,  605, 200, 70);
        pay.setFont(new Font("Monospaced", Font.BOLD, 17));

        payf = new JTextField("");
        payf.setBounds(1170,  625, 300, 50);
        payf.setFont(new Font("Monospaced", Font.BOLD, 17));

        //THE BOX

        reg =  new JLabel("PREMIUM MEMEBERSHIP");
        reg.setBounds(10, 185, 400, 50);
        reg.setFont(new Font("SansSerif", Font.BOLD, 30));

        stan = new JLabel("Premium =");
        stan.setBounds(150, 290, 110, 40);
        stan.setFont(new Font("Monospaced", Font.BOLD, 18));

        stanf = new JTextField("50000");
        stanf.setBounds(270, 290, 50, 50);
        stanf.setEditable(false);

        //decoration
        bord = new JLabel("|");
        bord.setBounds(430, 190, 40, 55);
        bord.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord1= new JLabel("|");
        bord1.setBounds(430, 270, 40, 55);
        bord1.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord2= new JLabel("- - - - - - - - - - - - - - ");
        bord2.setBounds(10, 500, 450, 40);
        bord2.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord3= new JLabel("- - - - - - - - - - - - - - ");
        bord3.setBounds(10, 130, 450, 40);
        bord3.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord4= new JLabel("|");
        bord4.setBounds(430, 350, 40, 55);
        bord4.setFont(new Font("SansSerif", Font.BOLD, 50));

        bord5= new JLabel("|");
        bord5.setBounds(430, 430, 40, 55);
        bord5.setFont(new Font("SansSerif", Font.BOLD, 50));     

        markp.addActionListener(this);
        disc.addActionListener(this);
        but1.addActionListener(this);
        but2.addActionListener(this);
        pay.addActionListener(this);
        acti.addActionListener(this);
        deac.addActionListener(this);
        disp.addActionListener(this);
        revp.addActionListener(this);
        savp.addActionListener(this);
        hom.addActionListener(this);
        cle1.addActionListener(this);
        upg.addActionListener(this);
        remp.addActionListener(this);
        read.addActionListener(this);
        panel.add(read);
        panel.add(payf);
        panel.add(disc);
        panel.add(pay);
        panel.add(markp);
        panel.add(remp);
        panel.add(remf);
        panel.add(remv);
        panel.add(savp);
        panel.add(train);
        panel.add(trainf);
        panel.add(hom);
        panel.add(upg);
        panel.add(cle1);
        panel.add(disp);
        panel.add(revp);

        panel.add(stanf);

        panel.add(stan);

        panel.add(deac);
        panel.add(acti);
        panel.add(bord4);
        panel.add(bord5);
        panel.add(day);
        panel.add(mem);
        panel.add(yer);
        panel.add(mon);
        panel.add(gend);
        panel.add(male);
        panel.add(lg);
        panel.add(fem);
        panel.add(phonef);
        panel.add(phone);
        panel.add(reff);
        panel.add(ref);
        panel.add(bord3);
        panel.add(email);
        panel.add(emailf);
        panel.add(loco);
        panel.add(locof);
        panel.add(dob);
        panel.add(yer1);
        panel.add(mon1);
        panel.add(day1);
        panel.add(id);
        panel.add(idf);
        panel.add(name);
        panel.add(namef);
        panel.add(bio);
        panel.add(bord2);
        panel.add(bord1);
        panel.add(bord);

        panel.add(reg);
        panel.add(slash);
        panel.add(but2);
        panel.add(but1);
        panel.add(label);
        frame.add(panel);
    }

    private JButton but5;
    private JButton but6;
    public void home(){
        this.frame1 = new JFrame();
        frame1.setTitle("GYm.exe");
        frame1.setSize(800, 400);
        frame1.setResizable(false);
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        //rgb cause more color variation
        Color ja = new Color(66, 135, 245);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 800, 400);
        panel1.setBackground(ja);
        panel1.setLayout(null);

        but5 = new JButton("Change to Premium Member");
        but5.setBounds(300, 200, 300, 50);
        but5.setFont(new Font("SansSerif", Font.BOLD, 19));

        but6 = new JButton("Change to Regular Member");
        but6.setBounds(300,100, 300, 50);
        but6.setFont(new Font("SansSerif", Font.BOLD, 19));

        but5.addActionListener(this);
        but6.addActionListener(this);
        panel1.add(but5);
        panel1.add(but6);
        frame1.add(panel1);
    }

    public static void main(String[] args) {
        GymGui obj = new GymGui();
        obj.home();
    }

    public void showRegularMemberDetails(RegularMember rm) {
        String info = "";
        info += "ID: " + rm.getid() + "\n";
        info += "Name: " + rm.getname() + "\n";
        info += "Location: " + rm.getlocation() + "\n";
        info += "Phone: " + rm.getphone() + "\n";
        info += "Email: " + rm.getemail() + "\n";
        info += "Gender: " + rm.gender + "\n";
        info += "Date of Birth: " + rm.DOB + "\n";
        info += "Membership Start: " + rm.membershipStartDate + "\n";
        info += "Attendance: " + rm.getattendance() + "\n";
        info += "Loyalty Points: " + rm.loyaltyPoints + "\n";
        info += "Active Status: " + rm.getactiveStatus() + "\n";
        info += "Plan: " + rm.getplan() + "\n";
        info += "Price: " + rm.getprice() + "\n";
        info += "Referred By: " + rm.getreferredby() + "\n";
        info += "Eligible for Upgrade: " + rm.getisEligibleForUpgrade() + "\n";

        JFrame frame = new JFrame("Regular Member Details");
        JTextArea area = new JTextArea(info);
        area.setEditable(false);
        frame.add(new JScrollPane(area));
        frame.setSize(350, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void showPremiumMemberDetails(PremiumMember pm) {
        String info = "";
        info += "ID: " + pm.getid() + "\n";
        info += "Name: " + pm.getname() + "\n";
        info += "Location: " + pm.getlocation() + "\n";
        info += "Phone: " + pm.getphone() + "\n";
        info += "Email: " + pm.getemail() + "\n";
        info += "Gender: " + pm.gender + "\n";
        info += "Date of Birth: " + pm.DOB + "\n";
        info += "Membership Start: " + pm.membershipStartDate + "\n";
        info += "Attendance: " + pm.getattendance() + "\n";
        info += "Loyalty Points: " + pm.loyaltyPoints + "\n";
        info += "Active Status: " + pm.getactiveStatus() + "\n";
        info += "Trainer: " + pm.personalTrainer + "\n";
        info += "Paid Amount: " + pm.paidAmount + "\n";
        info += "Full Payment: " + pm.isFullPayment + "\n";
        info += "Remaining: " + (pm.premiumCharge - pm.paidAmount) + "\n";
        if (pm.isFullPayment) {
            info += "Discount: " + pm.discountAmount + "\n";
        }

        JFrame frame = new JFrame("Premium Member Details");
        JTextArea area = new JTextArea(info);
        area.setEditable(false);
        frame.add(new JScrollPane(area));
        frame.setSize(350, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
