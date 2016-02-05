package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by Scott on 12/30/2015.
 */
public class
        dual_ods_test extends OpMode {

    DeviceInterfaceModule dim;
    AnalogInput ods_l;
    AnalogInput ods_r;



    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftMotorRear;
    DcMotor rightMotorRear;

    @Override
    public void init() {
        dim = hardwareMap.deviceInterfaceModule.get("device");
        ods_l = hardwareMap.analogInput.get("odsl");
        ods_r = hardwareMap.analogInput.get("odsr");

    }

    @Override
    public void loop() {
        double distance_l = ods_l.getValue();
        double distance_r = ods_r.getValue();





        telemetry.addData("Distance Detected Left", distance_l);
        telemetry.addData("Distance Detected Right", distance_r);

    }
}
