package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by owner on 12/30/2015.
 */

/*
distance in inches
distance for distance sensor is 300
 */
public class sensorauto_v5 extends LinearOpMode {

    DeviceInterfaceModule dim;
    AnalogInput ods_l;
    AnalogInput ods_r;
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


    final static double distance = 300;

    @Override
    public void runOpMode() throws InterruptedException {

        dim = hardwareMap.deviceInterfaceModule.get("device");
        ods_l = hardwareMap.analogInput.get("odsl");
        ods_r = hardwareMap.analogInput.get("odsr");
        color = hardwareMap.colorSensor.get("color");

        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");

        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);

        leftMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        double distance_l = ods_l.getValue();
        double distance_r = ods_r.getValue();



        waitForStart();

        leftMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);


        while(opModeIsActive()) {

                    resetStartTime();
                    while(getRuntime() < 5) {
                        telemetry.addData("run time", getRuntime());

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
                    }

                    if (distance_l < distance)
                    {
                        leftMotorRear.setPower(0.3);
                    }
                    else if (distance_l > distance)
                    {
                        leftMotorRear.setPower(-0.3);
                    }
                    else
                    {
                        leftMotorRear.setPowerFloat();
                    }

                    if (distance_r < distance)
                    {
                        rightMotorRear.setPower(0.3);
                    }
                    else if (distance_r > distance)
                    {
                        rightMotorRear.setPower(-0.3);
                    }
                    else
                    {
                        rightMotorRear.setPowerFloat();
                    }


            }

            telemetry.addData("Counts", COUNTS);
            telemetry.addData("Left Encoder", leftMotorRear.getCurrentPosition());
            telemetry.addData("Right Encoder", rightMotorRear.getCurrentPosition());
            telemetry.addData("left distance", distance_l);
            telemetry.addData("right distance", distance_r);

            waitOneFullHardwareCycle();
        }
    }

