package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleopMode extends OpMode {

    @Override
    public void init() {
        Robot.getInstance().teleopInit();
    }

    @Override
    public void loop() {
        Robot.getInstance().robotPeriodic();
        Robot.getInstance().teleopPeriodic();
    }
}
