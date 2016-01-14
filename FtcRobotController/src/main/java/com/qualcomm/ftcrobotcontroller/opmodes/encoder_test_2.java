package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by owner on 1/13/2016.
 */

/*
This one really works!!!!
 */
public class encoder_test_2 extends LinearOpMode {

    DeviceInterfaceModule dim;
    ColorSensor color;

    DcMotor leftMotorRear;
    DcMotor rightMotorRear;
    //change the value if necessary LOL
    final static int ENCODER_CPR = 1120;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 36; //in inches

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void runOpMode() throws InterruptedException {

        dim = hardwareMap.deviceInterfaceModule.get("device");
        color = hardwareMap.colorSensor.get("color");

        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");

        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);

        leftMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        waitForStart();

        leftMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(true) {

            if (COUNTS > Math.abs(leftMotorRear.getCurrentPosition())) {
                leftMotorRear.setPower(0.3);
            } else {
                leftMotorRear.setPowerFloat();
            }

            if (COUNTS > Math.abs(rightMotorRear.getCurrentPosition())) {
                rightMotorRear.setPower(0.3);
            } else {
                rightMotorRear.setPowerFloat();
            }

            waitOneFullHardwareCycle();

            telemetry.addData("Counts", COUNTS);
            telemetry.addData("Left Encoder", leftMotorRear.getCurrentPosition());
            telemetry.addData("Right Encoder", rightMotorRear.getCurrentPosition());
        }

    }
}
