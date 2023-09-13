package task;

import java.time.LocalDateTime;

/**
 * Class to handle deadline tasks
 */
public class Deadline extends Task {
    private final LocalDateTime deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = LocalDateTime.parse(deadline, INPUT_FORMATTER);
    }

    public Deadline(String name, String deadline, Boolean marked) {
        super(name, marked);
        this.deadline = LocalDateTime.parse(deadline, INPUT_FORMATTER);
    }

    /**
     * Checks if this task has a conflict with another task.
     * Always returns false as a conflict cannot be encountered with a Deadline Task
     *
     * @param t The task to check for conflicts with.
     * @return {@code false} No conflicts with deadline tasks
     */
    @Override
    public boolean hasConflictWith(Task t) {
        return false;
    }

    @Override
    public Deadline mark() {
        return new Deadline(this.name, this.deadline.format(INPUT_FORMATTER), true);
    }

    @Override
    public Deadline unmark() {
        return new Deadline(this.name, this.deadline.format(INPUT_FORMATTER), false);
    }

    @Override
    public String saveTask() {
        return String.format("D | %s | %s", super.saveTask(), this.deadline.format(INPUT_FORMATTER));
    }

    /**
     * Returns the name of task with deadline.
     *
     * @return Task to be done
     */
    @Override
    public String toString() {
        return String.format(
                "[D]%s (by: %s)",
                super.toString(),
                this.deadline.format(OUTPUT_FORMATTER)
        );
    }
}
