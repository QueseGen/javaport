import model.Customers;
import model.Tickets;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

class BoardingPass {

  //Helper Class Phone
  static class PhoneO {
    private long number;
    private String phrased;

    void setNumber(long num){ number=num;}
    long getNumber(){return number;}
    void setPhrased(String num){ phrased=num;}
    String getPhrased(){return phrased;}

    void setBoth(long num, String ph){
      number=num;
      phrased=ph;
    }
  }
  //Validator Method
    public static boolean isValid(String email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

    //Customer Helper Methods
    public static String[] Name(){
        Scanner input = new Scanner(System.in);
        System.out.print("Whats your first and last name: Ex.(John Doe) \n");
        String full_name;
        String[] name = null;
        while ( name==null ||name.length!=2) {
          full_name=input.nextLine();
          name=full_name.split("[\\s]");
          if (name.length!=2){
            System.out.println(full_name+" "+name.length+" ");
            //System.out.println("Please, only enter first and last name in this format:\n John Doe\nOR\nJane Doe\nTHEN press ENTER.");
          full_name = input.nextLine();
          name=full_name.split("[\\s]");}
        }
        return name;
    }
    public static String Email(){
        Scanner input = new Scanner(System.in);
        System.out.print("Whats your email: Ex.(xyz@gmail.com) \n");
        String email=input.next();
        boolean result = isValid(email);
        while (!result){
            System.out.println("Provided email address "+ email+ " is invalid.\n Please try again in proper format: Ex.(xyz@gmail.com) \n");
            email=input.next();
            result=isValid(email);
        }
        return email;
    }
    public static PhoneO Phone(){
        PhoneO phone=new PhoneO();
        System.out.println("Enter digits of phone number");
        long phoneNumber=0;
        String phrase="";
        while (phoneNumber<1000000000){
            try {
                Scanner scnr = new Scanner(System.in);
                phoneNumber = scnr.nextLong(); //user will input number here
                long lineNumber = phoneNumber % 10000; //the last 4 digits of phone
                long areaCode = phoneNumber / 10000000; // the first 3 digits of phone.
                long prefix = areaCode % 1000;  // this is where I'm going wrong. How do I get the 3 middle numbers?
                if(phoneNumber<1000000000){System.out.println("Got (" + areaCode + ")" + " " + prefix + "-" +
                  lineNumber+ "\nPlease enter actual Phone Number." );}
                phrase="(" + areaCode + ")" + " " + prefix + "-" + lineNumber;
            } catch (Exception e){
                System.out.println("Please enter a phone number \n"+ e);
                phoneNumber=0;
            }
        }
        phone.setBoth(phoneNumber, phrase);
        return phone;
    }
    public static String Gender(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Gender: ");
        String gender=input.nextLine();
        gender=gender.substring(0, 1).toUpperCase() + gender.substring(1);
        return gender;
    }
    public static int Age(){
    int age=0;
    while(age<=12){
      System.out.println("Please enter Age: 12+ \n");
    Scanner input = new Scanner(System.in);
    age=input.nextInt();}

    return age;
  }

    //Ticket Helper Methods
    public static String[] Destinationtime(String destination, Map<String, String[]> ticketss){
    boolean isValid=false;
    while(true){
    for (String place: ticketss.keySet()){
      if (place.equals(destination)) {
        return ticketss.get(destination);
      } else{
        System.out.println("Sorry, we only offer what is on the left side. Try again.");
        Scanner input = new Scanner(System.in);
        destination=input.nextLine();
        break;
      }
      }} }

        public static String deportTime(String[] times){
        Scanner input = new Scanner(System.in);
        String time= input.nextLine();
        while(true){
          for (String avail: times){
            if (time.equals(avail)) {
              return time;
            } else{
              System.out.println("Sorry, we only offer what is above. Try again.");
              input = new Scanner(System.in);
              time=input.nextLine();
              break;
            }
          }}
      }

  //Ticket Helper Methods
  public static String locationTime(Set<String> places){
    Scanner input = new Scanner(System.in);
    String location= input.nextLine();

    while(true){
      for (String place: places){
        if (place.equals(location)) {
          return location;
        } else{
          System.out.println("Sorry, we only offer what is on the left side. Try again.");
          Scanner iput = new Scanner(System.in);
          location=iput.nextLine();
          break;
        }
      }} }

    public static void main(String[] args) throws IOException {

      ///GET NAME
      String[] full_name = Name();
      String first_name = full_name[0];
      String last_name = full_name[1];

      System.out.println("Name entered: " + first_name + " " + last_name);
      //CLOSING

      ///GET EMAIL
      String email = Email();
      System.out.println(email + " , you valid.");
      //CLOSING

      ///GET PHONE
      PhoneO phoneNumber = Phone();
      System.out.println("Repeat: " + phoneNumber.getPhrased());
      //CLOSING

      ///GET GENDER
      String gender = Gender();
      System.out.println("Respectfully: " + gender);
      //CLOSING

      ///GET EMAIL
      int age = Age();
      System.out.println(age + " , you valid.");
      //CLOSING

      Customers customers = new Customers(first_name, last_name, email, gender, phoneNumber.getPhrased());

      System.out.println("Hello " + customers.getFirst() + " where would you like to go?");

      Tickets tickets = new Tickets();
      Map<String, String> ticketss = tickets.getLocations();
      Set<String> locations = ticketss.keySet();

      // Printing all elements of a Map
      //ticketss.forEach(
      //  (key, value)
      //    -> System.out.printf("%-15s %5S %10s\n", key, "| times: ", Arrays.toString(value)));

      System.out.println("Okay, where would you like to go: ");
      String[] departing = {locationTime(locations), ticketss.get(locationTime(locations))};

      System.out.println("Where to? ");
      String[] arriving = {locationTime(locations), ticketss.get(locationTime(locations))};

      String callQ = "https://airlabs.co/api/v9/schedules?dep_iata=" + departing[1] + "&arr_iata=" + arriving[1] + "&api_key=" + tickets.getAPIkey();

  }
}


