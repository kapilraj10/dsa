public class Kapilraj_kc_32 {
    int data;
    Kapilraj_kc_32 next;

    Kapilraj_kc_32(int data) {
        this.data = data;
        this.next = null;
    }

    // Traverse method
    static void traverse(Kapilraj_kc_32 head) {
        Kapilraj_kc_32 cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    // Insert method
    static Kapilraj_kc_32 insert(int data, Kapilraj_kc_32 head, int pos) {
        Kapilraj_kc_32 toAdd = new Kapilraj_kc_32(data);
        if (pos == 0) {
            toAdd.next = head;
            return toAdd;
        }

        Kapilraj_kc_32 prev = head;
        for (int i = 0; i < pos - 1 && prev != null; i++) {
            prev = prev.next;
        }

        if (prev == null) {
            System.out.println("Position out of bounds.");
            return head;
        }

        toAdd.next = prev.next;
        prev.next = toAdd;
        return head;
    }

    // Delete method
    static Kapilraj_kc_32 delete(Kapilraj_kc_32 head, int pos) {
        if (head == null) return null;

        if (pos == 0) {
            return head.next;
        }

        Kapilraj_kc_32 prev = head;
        for (int i = 0; i < pos - 1 && prev.next != null; i++) {
            prev = prev.next;
        }

        if (prev.next == null) {
            System.out.println("Position out of bounds.");
            return head;
        }

        prev.next = prev.next.next;
        return head;
    }

    // Main method to run everything
    public static void main(String[] args) {
        Kapilraj_kc_32 n1 = new Kapilraj_kc_32(10);
        Kapilraj_kc_32 n2 = new Kapilraj_kc_32(20);
        Kapilraj_kc_32 n3 = new Kapilraj_kc_32(30);

        n1.next = n2;
        n2.next = n3;
        Kapilraj_kc_32 head = n1;

        System.out.println("Initial List:");
        traverse(head);

        head = insert(15, head, 1);
        System.out.println("\nAfter Inserting 15 at position 1:");
        traverse(head);

        head = delete(head, 2);
        System.out.println("\nAfter Deleting node at position 2:");
        traverse(head);
    }
}
