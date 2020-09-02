package lib.framework;

/**
 * Class that holds scheduling state for a command.  Used internally by the
 * {@link CommandScheduler}.
 */
class CommandState {
    //The time since this command was initialized.
    private double m_startTime = -1;

    //Whether or not it is interruptible.
    private final boolean m_interruptible;

    CommandState(boolean interruptible) {
        m_interruptible = interruptible;
        //startTiming();
        startRunning();
    }

    /* Removed until replacement found
    Todo: find a replacement for Timer.getFPGTimestamp
    private void startTiming() {
        m_startTime = Timer.getFPGATimestamp();
    }
    */


    synchronized void startRunning() {
        m_startTime = -1;
    }

    boolean isInterruptible() {
        return m_interruptible;
    }

    /*Removed until replacement found
    double timeSinceInitialized() {
        return m_startTime != -1 ? Timer.getFPGATimestamp() - m_startTime : -1;
    }

     */
}