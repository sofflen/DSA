package utility;

public class JobItem {

    private int profit;
    private int deadline;

    public JobItem(int profit, int deadline) {
        this.profit = profit;
        this.deadline = deadline;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "JobItem{" +
                "profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}
