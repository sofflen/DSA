package optimizationproblems.greedymethod;

import utility.JobItem;

import java.util.*;
import java.util.stream.Collectors;

public class JobSequencingWithDeadlines {
    public static void main(String[] args) {
        JobSequencingWithDeadlines sequencing = new JobSequencingWithDeadlines();
        List<JobItem> jobItemsList = sequencing.generateList();
        System.out.println(jobItemsList);

        JobItem[] approvedJobItemsList = sequencing.findJobSequence(jobItemsList, 5);
        System.out.println(Arrays.toString(approvedJobItemsList));
    }

    public JobItem[] findJobSequence(List<JobItem> jobs, int maxJobs) {
        JobItem[] approvedJobItems = new JobItem[maxJobs];
        boolean[] isSlotAvailable = new boolean[maxJobs];

        jobs = jobs.stream().sorted(Comparator.comparingInt(JobItem::getProfit).reversed()).collect(Collectors.toList());

        for (JobItem job : jobs) {
            if (Arrays.stream(approvedJobItems).noneMatch(Objects::isNull)) {
                break;
            }
            for (int i = Math.min(maxJobs - 1, job.getDeadline() - 1); i >= 0; i--) {
                if (!isSlotAvailable[i]) {
                    isSlotAvailable[i] = true;
                    approvedJobItems[i] =  job;
                    break;
                }
            }
        }
        return approvedJobItems;
    }

    private List<JobItem> generateList() {
        List<JobItem> result = new ArrayList<>();
        Random random = new Random();

        int minAmount = 3;
        int maxAmount = 15;
        int amountOfItems = random.nextInt(maxAmount - minAmount + 1) + minAmount;

        for (int i = 0; i < amountOfItems; i++) {
            JobItem item = new JobItem(random.nextInt(30) + 1, random.nextInt(5) + 1);
            result.add(item);
        }
        return result;
    }
}
