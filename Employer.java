import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Employer extends User {
    private final String type;
    private String id;
    private String displayName;
    private String username;
    private String password;
    private boolean verified;
    private ArrayList<Job> myJobs;

    public Employer() {
        type = "1";
        id = UUID.randomUUID().toString();
    }

    public Employer(String id, String displayName, String username, String password, ArrayList<Job> myJobs) {
        type = "1";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.myJobs = myJobs;
    }

    /**
     * Verify takes an emailaddress and uses regular expression 
     * to make sure the user entered a valid email for contact purposes
     * source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
     * @param emailAddress the email to verify
     * @return Returns true if valid, false otherwise
     */
    public boolean verify(String emailAddress) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        if (emailAddress == null) {
            verified = false;
        } else if (pattern.matcher(emailAddress).matches()) {
            verified = true;
        }

        return verified;

    }

    public String viewApplicants() {
        return "";
    }

    public String whatType() {
        return "Employer";
    }

    public Job addJobListing() {
        return new Job();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getID() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPass() {
        return this.password;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Job> getJob() {
        return myJobs;
    }

    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n"
        + getPass();
    }

    @Override
    public boolean checkVerified() {
        return verified;
    }
}
