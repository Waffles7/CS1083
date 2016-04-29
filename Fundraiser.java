public class Fundraiser implements Comparable<Fundraiser>, java.io.Serializable {

   /**
    *The person's full name.
   **/
   private String name;

   /**
    *The total amount of money that this person has raised so far.
   **/
   private double moneyRaised;
   
   public Fundraiser (String nameIn) {
     name = nameIn;
     moneyRaised = 0.0;
   }

   public String getName() { return name; }

   public void setName (String nameIn) {
      name = nameIn;
   }

   public double getMoneyRaised() { return moneyRaised; }

   public void addFundraisingMoney(double moneyIn) {
      moneyRaised += moneyIn;
   }
   
   public void clearFundraisingTally() {
      moneyRaised = 0.0;
   }

   public int compareTo(Fundraiser other) {
      int result = 0;
      if (moneyRaised < other.moneyRaised) { result = -1; }
      else if (moneyRaised > other.moneyRaised) { result = 1; }
      return result;
   }

}
