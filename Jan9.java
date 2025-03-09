import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jan10 {
    public static void main(String[] args) {
        MovingAverage movingAverage = null;
        List<Integer> list = List.of(3, 1, 10, 3, 5);
        int index = 0;
        for (Integer number : list) {
            if (index == 0) {
                movingAverage = new MovingAverage(number);
            } else {
                System.out.println(movingAverage.next(number));
            }
            index++;
        }

    }

}

class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    private double sum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        queue.add(val);
        int cnt = this.queue.size();
        double avg = 0;
        if (cnt > this.size) {
            int polled = queue.poll();
            this.sum = this.sum - polled;
            cnt = this.queue.size();
        }
        this.sum = this.sum + val;
        avg = this.sum / cnt;
        return avg;
    }

}

