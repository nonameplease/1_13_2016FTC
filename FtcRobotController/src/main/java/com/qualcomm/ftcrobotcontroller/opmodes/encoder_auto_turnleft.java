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
public class encoder_auto_turnleft extends LinearOpMode {

    DeviceInterfaceModule dim;
    ColorSensor color;

    DcMotor leftMotorRear;
    DcMotor rightMotorRear;
    DcMotor leftMotor;
    DcMotor rightMotor;
    //change the value if necessary LOL
    final static int ENCODER_CPR = 1120;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 72; //in inches

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void runOpMode() throws InterruptedException {

        dim = hardwareMap.deviceInterfaceModule.get("device");
        color = hardwareMap.colorSensor.get("color");

        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");

        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        waitForStart();

        leftMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(true) {
            if (COUNTS + 50 > Math.abs(leftMotorRear.getCurrentPosition())) {
                if (COUNTS > Math.abs(leftMotorRear.getCurrentPosition())) {
                    leftMotorRear.setPower(-0.6);
                    leftMotor.setPower(-0.6);

                } else {
                    leftMotorRear.setPowerFloat();
                    leftMotor.setPowerFloat();
                }

                if (COUNTS > Math.abs(rightMotorRear.getCurrentPosition())) {
                    rightMotorRear.setPower(-0.6);
                    rightMotor.setPower(-0.6);
                } else {
                    rightMotorRear.setPowerFloat();
                    rightMotor.setPowerFloat();
                }
            } else if (COUNTS + 50 < Math.abs(leftMotorRear.getCurrentPosition()) && COUNTS + 2100 > Math.abs(leftMotorRear.getCurrentPosition())) {
                if (2000 + COUNTS > Math.abs(leftMotorRear.getCurrentPosition())) {
                    leftMotorRear.setPower(-0.6);
                    leftMotor.setPower(-0.6);
                } else {
                    leftMotorRear.setPowerFloat();
                    leftMotor.setPowerFloat();
                }


                if (COUNTS - 2000 < Math.abs(rightMotorRear.getCurrentPosition())) {
                    rightMotorRear.setPower(0.6);
                    rightMotor.setPower(0.6);
                } else {
                    rightMotorRear.setPowerFloat();
                    rightMotor.setPowerFloat();
                }

            }else
            {
                leftMotorRear.setPower(-0.6);
                rightMotorRear.setPower(-0.6);
                leftMotor.setPower(-0.6);
                rightMotor.setPower(-0.6);
                sleep(2000);
                leftMotorRear.setPowerFloat();
                rightMotorRear.setPowerFloat();
                leftMotor.setPowerFloat();
                rightMotor.setPowerFloat();
                sleep(30000);
            }


            waitOneFullHardwareCycle();
            


            telemetry.addData("Counts", COUNTS);
            telemetry.addData("Left Encoder", leftMotorRear.getCurrentPosition());
            telemetry.addData("Right Encoder", rightMotorRear.getCurrentPosition());
        }
    }

}

