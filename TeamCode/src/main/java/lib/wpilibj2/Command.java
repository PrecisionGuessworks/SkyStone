import java.util.Set;
import java.util.function.BooleanSupplier;

/**
 * A state machine representing a complete action to be performed by the robot.  Commands are
 * run by the {@link CommandScheduler}, and can be composed into CommandGroups to allow users to
 * build complicated multi-step actions without the need to roll the state machine logic themselves.
 *
 * <p>Commands are run synchronously from the main robot loop; no multithreading is used, unless
 * specified explicitly from the command implementation.
 */
@SuppressWarnings("PMD.TooManyMethods")
public abstract class Command {

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    abstract void initialize();

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     */
    abstract void execute();

    /**
     * The action to take when the command ends.  Called when either the command finishes normally,
     * or when it interrupted/canceled.
     *
     * <p>Do not schedule commands here that share requirements with this command.
     * Use {@link #andThen(Command...)} instead.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    abstract void end(boolean interrupted);

    /**
     * Whether the command has finished.  Once a command finishes, the scheduler will call its
     * end() method and un-schedule it.
     *
     * @return whether the command has finished.
     */
    abstract boolean isFinished();

    /**
     * Specifies the set of subsystems used by this command.  Two commands cannot use the same
     * subsystem at the same time.  If the command is scheduled as interruptible and another
     * command is scheduled that shares a requirement, the command will be interrupted.  Else,
     * the command will not be scheduled.  If no subsystems are required, return an empty set.
     *
     * <p>Note: it is recommended that user implementations contain the requirements as a field,
     * and return that field here, rather than allocating a new set every time this is called.
     *
     * @return the set of subsystems that are required
     */
    Set<Subsystem> getRequirements();

    //Todo: Add Command Decorators

    /**
     * Schedules this command.
     *
     * @param interruptible whether this command can be interrupted by another command that
     *                      shares one of its requirements
     */
    public void schedule(boolean interruptible) {
        CommandScheduler.getInstance().schedule(interruptible, this);
    }

    /**
     * Schedules this command, defaulting to interruptible.
     */
    public void schedule() {
        schedule(true);
    }

    /**
     * Cancels this command.  Will call the command's interrupted() method.
     * Commands will be canceled even if they are not marked as interruptible.
     */
    public void cancel() {
        CommandScheduler.getInstance().cancel(this);
    }

    /**
     * Whether or not the command is currently scheduled.  Note that this does not detect whether
     * the command is being run by a CommandGroup, only whether it is directly being run by
     * the scheduler.
     *
     * @return Whether the command is scheduled.
     */
    public boolean isScheduled() {
        return CommandScheduler.getInstance().isScheduled(this);
    }

    /**
     * Whether the command requires a given subsystem.  Named "hasRequirement" rather than "requires"
     * to avoid confusion with
     * {@link edu.wpi.first.wpilibj.command.Command#requires(edu.wpi.first.wpilibj.command.Subsystem)}
     * - this may be able to be changed in a few years.
     *
     * @param requirement the subsystem to inquire about
     * @return whether the subsystem is required
     */
    public boolean hasRequirement(Subsystem requirement) {
        return getRequirements().contains(requirement);
    }

    /**
     * Whether the given command should run when the robot is disabled.  Override to return true
     * if the command should run when disabled.
     *
     * @return whether the command should run when the robot is disabled
     */
    public boolean runsWhenDisabled() {
        return false;
    }

    /**
     * Gets the name of this Command.
     *
     * @return Name
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}