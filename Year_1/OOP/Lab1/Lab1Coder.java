package Lab1;
import java.util.*;

class Lab1Coder {
    Scanner sc = new Scanner(System.in);
    private String name;
    private ArrayList<String> lang = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();
    int experience;
    String a = "";

    Lab1Coder() {

   }

    Lab1Coder(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    Lab1Coder(String name) {
        this.name = name;
        this.experience = 0;
    }

    void setName() {
        name = sc.nextLine();
    }

    String getName() {
        return (name);
    }

    void setLanguage(String... lang) {
        for (String string : lang)
            this.lang.add(string);
    }

    ArrayList<String> getLanguage() {
        return (this.lang);
    }

    void setExperience() {
        experience = sc.nextInt();
    }

    int getExperience() {
        return (experience);
    }

    ArrayList<String> findCommonLanguages(Lab1Coder other) {
        for (String i : this.getLanguage()) {
            for (String j : other.getLanguage()) {
                if (i.equals(j))
                    ans.add(i);
            }
        }

        if (ans.size() == 0)
            ans.add("None");
        return (ans);
    }

    public String atos() {
        for (int i = 0; i < getLanguage().size(); i++) {
            a += getLanguage().get(i);
            if (i != getLanguage().size())
                a += " ";
        }
        return (a);
    }

    public String toString() {
        return (String.format("%s(%d) know %s", name, experience, atos()));
    }
}
