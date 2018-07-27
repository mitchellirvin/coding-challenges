// Write your Checker class here
class Checker implements Comparator {
    // returns negative is p1 < p2
    // returns 0 if equal
    // returns positive if p1 > p2
    public int compare(Object o1, Object o2) {
        Player p1 = (Player) o1;
        Player p2 = (Player) o2;

        if(p1.score > p2.score) return -1;
        else if(p1.score < p2.score) return 1;
        else return p1.name.compareTo(p2.name);
    }
}
