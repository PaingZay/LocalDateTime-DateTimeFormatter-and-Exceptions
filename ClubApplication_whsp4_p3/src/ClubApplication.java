import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClubApplication {

   public static void main(String args[]) {

      Club club = new Club();

      // Test class Member
      Member member1, member2, member3, member4, member5;

      member1 = club.addMember("Einstein", "Albert", null);
      member2 = club.addMember("Picasso", "Pablo", "Ruiz");
      member3 = club.addMember("Webber", "Andrew", "Lloyd");
      member4 = club.addMember("Baggio", "Roberto", null);
      member5 = club.addMember("Raffles", "Stamford", null);

      System.out.println("Current Members:");
      club.showMembers();

      System.out.println("Deleting member 3");
      club.removeMember(3);

      System.out.println("Current members:");
      club.showMembers();

      System.out.println("Add another member");
      club.addMember("Ludwig", "Beethoven", "van");

      System.out.println("Current members:");
      club.showMembers();

      // Test class Facility
      Facility lab = club.addFacility("Lab", "Einstein's Experiment Area");
      club.addFacility("Studio", "Picasso's Work Place");
      club.addFacility("Room1", "Conference Room on Level 2");
      club.addFacility("Room2", "Meeting Room on Level 3");
      club.show();

      club.removeFacility("Studio");
      club.removeFacility("Room2");

      club.show();

      // Test class Booking
      System.out.println();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");

      try {
         Booking booking1 = new Booking(member1, lab, LocalDateTime.parse("1-Aug-2007 09:00", df),
               LocalDateTime.parse("2-Aug-2007 07:00", df));

         Booking booking2 = new Booking(member2, lab, LocalDateTime.parse("24-Jul-2007 09:00", df),
               LocalDateTime.parse("25-Aug-2007 09:00", df));

         booking1.show();
         booking2.show();
         if (booking1.overlaps(booking2)) {
            System.out.println("Correct: Overlap");
         } else {
            System.out.println("No overlap");
         }

      } catch (BadBookingException e) {
         System.err.println(e.getMessage());
      }

   }

}
