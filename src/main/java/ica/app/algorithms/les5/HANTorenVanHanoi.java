package ica.app.algorithms.les5;

public class HANTorenVanHanoi<T extends Comparable> {
    HANStack<T> stack1 = new HANStack<T>();
    HANStack<T> stack2 = new HANStack<T>();
    HANStack<T> stack3 = new HANStack<T>();

    public HANTorenVanHanoi( HANStack a, HANStack b, HANStack c) {
        this.stack1 = a;
        this.stack2 = b;
        this.stack3 = c;
    }

    public void solve(int n, String start, String auxiliary, String end) {
        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            solve(n - 1, start, end, auxiliary);
            System.out.println(start + " -> " + end);
            solve(n - 1, auxiliary, start, end);
        }
    }

    public <T> void hanoi(int aantal, HANStack bronstok, HANStack doelstok) {
        if(aantal == 1) {
            doelstok.push(bronstok.pop());
        } else {
            hanoi(aantal -1, bronstok, stack3);
            hanoi(1, bronstok, doelstok);
            hanoi(aantal -1, stack3, doelstok);
        }
    }

}
