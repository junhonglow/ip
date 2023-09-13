package task;

/**
 * Class to handle todo tasks
 */
public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    public Todo(String name, boolean marked) {
        super(name, marked);
    }

    @Override
    public Todo mark() {
        return new Todo(this.name, true);
    }

    @Override
    public Todo unmark() {
        return new Todo(this.name, false);
    }

    @Override
    public String saveTask() {
        return String.format("T | %s", super.saveTask());
    }

    /**
     * Checks if this task has a conflict with another task.
     * Always returns false as a conflict cannot be encountered with a Todo Task
     *
     * @param t The task to check for conflicts with.
     * @return {@code false} No conflicts with todo tasks
     */
    @Override
    public boolean hasConflictWith(Task t) {
        return false;
    }

    /**
     * Returns the name of task to be done.
     *
     * @return Name of task to be done
     */
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
