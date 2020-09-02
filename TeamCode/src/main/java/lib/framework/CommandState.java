package lib.framework;

import java.util.Calendar;

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
        startTiming();
        startRunning();
    }



    private void startTiming() {
        //Todo: Test to make sure this is accurate
        m_startTime = Calendar.getInstance().getTimeInMillis();
    }



    synchronized void startRunning() {
        m_startTime = -1;
    }

    boolean isInterruptible() {
        return m_interruptible;
    }


    double timeSinceInitialized() {
        return m_startTime != -1 ? Calendar.getInstance().getTimeInMillis() - m_startTime : -1;

    }


}