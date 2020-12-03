public class Main {
    public static void main(String[] args) {
        ToDo myToDo = new ToDo();
        //myToDo.getCommands();
        Email emails = new Email();
        //emails.getEmail();
        //emails.showEmails();
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.cmdListener();
    }
}
