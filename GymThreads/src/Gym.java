import java.util.Map;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Gym {
    private final int totalGymMembers;
    private Map<MachineType, Integer> availableMachines;

    public Gym(int totalGymMembers, Map<MachineType, Integer> availableMachines) {
        this.totalGymMembers = totalGymMembers;
        this.availableMachines = availableMachines;
    }

    public void openForTheDay() {
        List<Thread> gymMembersRoutines;
        gymMembersRoutines = IntStream.rangeClosed(1, this.totalGymMembers)
                .mapToObj((id) -> {
                    Member member = new Member(id);
                    return new Thread(() -> {
                        try {
                            member.performRoutine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                })
                .collect(Collectors.toList());
        Thread supervisor = createSupervisor(gymMembersRoutines);
        supervisor.start();

        gymMembersRoutines.forEach((t) -> t.start());
    }

    private Thread createSupervisor(List<Thread> threads) {
        Thread supervisor = new Thread(() -> {
            while (true) {
                List<String> runningThreads = threads.stream()
                        .filter(Thread::isAlive)
                        .map(Thread::getName)
                        .collect(Collectors.toList());
                if (runningThreads.isEmpty()) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " - " + runningThreads.size() +
                        " members currently exercising: " + runningThreads + " \n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " - All members are finished exercising!");
        });
        supervisor.setName("Gym Staff");
        return supervisor;
    }
}