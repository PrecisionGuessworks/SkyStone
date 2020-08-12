package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class AutoMode extends OpMode {

    @Override
    public void init() {
        Robot.getInstance().autonomousInit();
    }

    @Override
    public void loop() {
        Robot.getInstance().robotPeriodic();
        Robot.getInstance().autonomousPeriodic();
    }
}
