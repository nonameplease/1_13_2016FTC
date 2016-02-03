package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Scott on 1/31/2016.
 */
public class A_AutoDrive extends A_RobotDrive {
    public A_AutoDrive(DcMotor left, DcMotor right, DcMotor leftrotate, DcMotor rightrotate, Servo Climber, Servo ResQ) {
        super(left, right, leftrotate, rightrotate, Climber, ResQ);
    }

    DeviceInterfaceModule dim;
    ColorSensor color;

    //change the value if necessary LOL
    final static int ENCODER_CPR = 1120;
    final static int GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 36; //in inches

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
    final static int COUNTSINT = (int) COUNTS * -1;

    public A_AutoDrive(DeviceInterfaceModule Dim, ColorSensor Color)
    {
        super(left, right, leftrotate, rightrotate, Climber, ResQ);
        dim = Dim;
        color = Color;
    }

    public void encoderDrive()
    {

    }
}
