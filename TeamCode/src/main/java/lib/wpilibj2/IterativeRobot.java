package lib.wpilibj2;

public class IterativeRobot {

    /**
     * IterativeRobot implements a specific type of robot program framework. It functions
     * similarly to IterativeRobotBase from wpilibj, but not exactly the same.
     *
     * <p>This class provides the following functions which are called by the main loop,
     * startCompetition(), at the appropriate times:
     *
     * <p>robotInit() -- provide for initialization at robot power-on
     *
     * <p>init() functions -- each of the following functions is called once when the
     * appropriate mode is entered:
     *   - disabledInit()   -- called each and every time disabled is entered from
     *                         another mode
     *   - autonomousInit() -- called each and every time autonomous is entered from
     *                         another mode
     *   - teleopInit()     -- called each and every time teleop is entered from
     *                         another mode
     *   - testInit()       -- called each and every time test is entered from
     *                         another mode
     *
     * <p>periodic() functions -- each of these functions is called on an interval:
     *   - robotPeriodic()
     *   - disabledPeriodic()
     *   - autonomousPeriodic()
     *   - teleopPeriodic()
     *   - testPeriodic()
     *
     * Description and code modified from wpilibj IterativeRobotBase as of 8/11/2020
     *
     */

    protected static IterativeRobot instance;

    protected IterativeRobot(){
        robotInit();
    }

    public static synchronized IterativeRobot getInstance(){
        if (instance == null){
            instance = new IterativeRobot();
        }
        return instance;
    }

    /* ----------- Overridable initialization code ----------------- */

    /**
     * Robot-wide initialization code should go here.
     *
     * <p>Users should override this method for default Robot-wide initialization.
     * It should be called exactly one time from the constructor
     *
     */
    protected void robotInit(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    /**
     * Periodic code for all robot modes should go here.
     */
    public void robotPeriodic(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    /* ----------- Overridable autonomous code ----------------- */

    /**
     * Initialization code for autonomous mode should go here.
     *
     * <p>Users should override this method for initialization code which will be called each time the
     * robot enters autonomous mode.
     */
    public void autonomousInit(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    /**
     * Periodic code for autonomous mode should go here.
     */
    public void autonomousPeriodic(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    /* ----------- Overridable periodic code ----------------- */

    /**
     * Initialization code for teleop mode should go here.
     *
     * <p>Users should override this method for initialization code which will be called each time the
     * robot enters teleop mode.
     */
    public void teleopInit(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    /**
     * Periodic code for teleop mode should go here.
     */
    public void teleopPeriodic(){
        System.out.println("Default robotPeriodic() method... Override me!");
    }

}
