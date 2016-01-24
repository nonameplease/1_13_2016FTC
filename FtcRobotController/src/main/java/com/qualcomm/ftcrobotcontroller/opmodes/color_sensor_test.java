package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;

/**
 * Created by owner on 12/27/2015.
 */


/*
grey
blue 220 - 245
green 310 - 330
red 390 - 410

white
blue 600 - 700
green 750 - 900
red 800 - 850

red
blue 180 - 220
green 220 - 270
red 600 - 650
 */

public class color_sensor_test extends OpMode {

    DeviceInterfaceModule dim;
    ColorSensor color;

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftMotorRear;
    DcMotor rightMotorRear;

    @Override
    public void init() {
        dim = hardwareMap.deviceInterfaceModule.get("device");
        color = hardwareMap.colorSensor.get("color");

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void loop() {
        int Red = color.red();
        int Blue = color.blue();
        int Green = color.green();

        if(Red < 375 && Blue < 350 && Green < 350)
        {
            leftMotor.setPower(0.5);
            rightMotor.setPower(0.5);
            leftMotorRear.setPower(0.5);
            rightMotorRear.setPower(0.5);
        }
        else
        {
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            leftMotorRear.setPowerFloat();
            rightMotorRear.setPowerFloat();
        }



        telemetry.addData("Red", Red);
        telemetry.addData("Blue", Blue);
        telemetry.addData("Green", Green);




    }
}
