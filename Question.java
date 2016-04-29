public class Question implements java.io.Serializable {
   private String question;
   private String submitter;
   
   public Question (String questIn, String submitterIn) {
      question = questIn;
      submitter = submitterIn;
   }
   
   public String getQuestion () {
      return question;
   }
   
   public String getSubmitter () {
      return submitter;
   }
   
   public String toString () {
      return question + " - Submitted by: " + submitter;
   }
}