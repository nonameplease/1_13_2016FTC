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

    @Override
    public void init() {
        dim = hardwareMap.deviceInterfaceModule.get("device");
        color = hardwareMap.colorSensor.get("color");

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void loop() {
        int Red = color.red();
        int Blue = color.blue();
        int Green = color.green();




        telemetry.addData("Red", Red);
        telemetry.addData("Blue", Blue);
        telemetry.addData("Green", Green);




    }
}
