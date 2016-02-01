package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Scott on 1/31/2016.
 */
public class A_AutoDrive extends A_RobotDrive {
    public A_AutoDrive(DcMotor left, DcMotor right, DcMotor leftrotate, DcMotor rightrotate, Servo Climber, Servo ResQ) {
        super(left, right, leftrotate, rightrotate, Climber, ResQ);
    }
}
