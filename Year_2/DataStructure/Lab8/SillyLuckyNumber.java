package Lab8;

public class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String s) {
    breed = s;
    for (int i = 0; i < breed.length(); i++)
        luckyNumber += breed.charAt(i);
    threeDigit = luckyNumber % 1000;
    }

    // getters
    public Integer getLuckyNumber() {
        return (luckyNumber);
    }

    public void setBreed(String s) {
        breed = s;
        for (int i = 0; i < breed.length(); i++)
            luckyNumber += breed.charAt(i);
        threeDigit = luckyNumber % 1000;
    }

    public Integer compare(SillyLuckyNumber a, SillyLuckyNumber b) {
        return (a.getLuckyNumber()).compareTo(b.getLuckyNumber());
    }

    @Override
    public String toString() {
    return ("<<"+ breed + " " + luckyNumber + " " + threeDigit + ">>");
    }
}
