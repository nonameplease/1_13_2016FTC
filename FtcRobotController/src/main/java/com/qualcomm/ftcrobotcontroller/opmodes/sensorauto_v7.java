package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;

/**
 * Created by Scott on 1/24/2016.
 */
public class sensorauto_v7 extends OpMode {

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
    final static int COUNTSINT = (int) COUNTS * -1;


    final static double distance = 300;
    String state;

    @Override
    public void init() {

        dim = hardwareMap.deviceInterfaceModule.get("device");
        ods_l = hardwareMap.analogInput.get("odsl");
        ods_r = hardwareMap.analogInput.get("odsr");
        color = hardwareMap.colorSensor.get("color");

        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");

        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);

        leftMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotorRear.setMode(DcMotorController.RunMode.RESET_ENCODERS);




    }



    @Override
    public void loop() {
        double distance_l = ods_l.getValue();
        double distance_r = ods_r.getValue();
        for(int i = 1; i < 2; i++)
        {

            leftMotorRear.setTargetPosition(COUNTSINT);
            rightMotorRear.setTargetPosition(COUNTSINT);
            leftMotorRear.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
            rightMotorRear.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

            leftMotorRear.setPower(-0.5);
            rightMotorRear.setPower(-0.5);
        }
            leftMotorRear.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            rightMotorRear.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);


        if (!leftMotorRear.isBusy() && !rightMotorRear.isBusy())
        {
            state = "stopped";
        }
        else
        {
            state = "running";
        }

        if (distance_l < 300)
        {
            //leftMotor.setPower(-0.5);
            //rightMotor.setPower(0.5);
            leftMotorRear.setPower(-0.3);
            // rightMotorRear.setPower(0.5);
        }
        else
        {
            //leftMotor.setPowerFloat();
            // rightMotor.setPowerFloat();
            leftMotorRear.setPowerFloat();
            // rightMotorRear.setPowerFloat();
        }

        if (distance_r < 300)
        {
            //rightMotor.setPower(-0.5);
            rightMotorRear.setPower(-0.3);
        }
        else
        {
            rightMotorRear.setPowerFloat();
            // rightMotor.setPowerFloat();
        }



        telemetry.addData("Distance Detected Left", distance_l);
        telemetry.addData("Distance Detected Right", distance_r);
        telemetry.addData("encoder left", leftMotorRear.getCurrentPosition());
        telemetry.addData("encoder right", rightMotorRear.getCurrentPosition());
        telemetry.addData("state", state);
        telemetry.addData("left power", leftMotorRear.getPower());
        telemetry.addData("right power", rightMotorRear.getPower());
    }
}
