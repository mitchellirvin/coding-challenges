/*
each instance has a unique_id
has a toString() which returns a String of the form
    "Item #unique_id"
*/

public class Item<E> {
    private int id;

    Item(int id) {
        this.id = id;
    }

    public String toString() {
        return "Item #" + id;
    }
}
