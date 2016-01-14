package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by owner on 12/30/2015.
 */
public class followlinetest extends LinearOpMode {

    DeviceInterfaceModule dim;
    OpticalDistanceSensor ods_l;
    OpticalDistanceSensor ods_r;
    ColorSensor color;

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftMotorRear;
    DcMotor rightMotorRear;


    @Override
    public void runOpMode() throws InterruptedException {

        dim = hardwareMap.deviceInterfaceModule.get("device");
        ods_l = hardwareMap.opticalDistanceSensor.get("odsl");
        ods_r = hardwareMap.opticalDistanceSensor.get("odsr");
        color = hardwareMap.colorSensor.get("color");

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotorRear = hardwareMap.dcMotor.get("left_drive_rear");
        rightMotorRear = hardwareMap.dcMotor.get("right_drive_rear");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {
            double distance_l = ods_l.getLightDetected();
            double distance_r = ods_r.getLightDetected();

            int Red = color.red();
            int Blue = color.blue();
            int Green = color.green();


                if(Red > 375 && Blue > 350 && Green > 350)
                {
                    if (distance_l < 0.04)
                    {
                        leftMotor.setPower(-0.3);
                        //rightMotor.setPower(0.5);
                        leftMotorRear.setPower(-0.3);
                        // rightMotorRear.setPower(0.5);
                        sleep(100);
                    }
                    else
                    {
                        leftMotor.setPowerFloat();
                        // rightMotor.setPowerFloat();
                        leftMotorRear.setPowerFloat();
                        // rightMotorRear.setPowerFloat();
                    }

                    if (distance_r < 0.04)
                    {
                        rightMotor.setPower(-0.3);
                        rightMotorRear.setPower(-0.3);
                        sleep(100);
                    }
                    else
                    {
                        rightMotorRear.setPowerFloat();
                        rightMotor.setPowerFloat();
                    }
                }

            leftMotor.setPowerFloat();
            leftMotorRear.setPowerFloat();
            rightMotor.setPowerFloat();
            rightMotorRear.setPowerFloat();

            telemetry.addData("distancel", distance_l);
            telemetry.addData("distancer", distance_r);
            telemetry.addData("red", Red);
            telemetry.addData("blue", Blue);
            telemetry.addData("Green", Green);
            telemetry.addData("left", leftMotor.getCurrentPosition());
            telemetry.addData("right", rightMotor.getCurrentPosition());
            waitOneFullHardwareCycle();
        }

    }
}
