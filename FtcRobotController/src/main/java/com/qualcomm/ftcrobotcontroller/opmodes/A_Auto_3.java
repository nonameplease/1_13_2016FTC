package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Scott on 2/6/2016.
 */
public class A_Auto_3 extends LinearOpMode {
    A_AutoDrive myA_AutoDrive;
    @Override
    public void runOpMode() throws InterruptedException {

        myA_AutoDrive = new A_AutoDrive(hardwareMap.dcMotor.get("left_drive"),
                hardwareMap.dcMotor.get("right_drive"),
                hardwareMap.dcMotor.get("left_drive_rotate"),
                hardwareMap.dcMotor.get("right_drive_rotate"),
                hardwareMap.dcMotor.get("climber"),
                hardwareMap.servo.get("resQ_l"),
                hardwareMap.servo.get("resQ_r"),
                hardwareMap.deviceInterfaceModule.get("device"),
                hardwareMap.colorSensor.get("color"),
                hardwareMap.analogInput.get("odsl"),
                hardwareMap.analogInput.get("odsr"));

        waitForStart();

        while(opModeIsActive())
        {
            int a = 0;
            if (myA_AutoDrive.colorDetected() == 2)
            {
                a = 1;
            }

            if(a == 0)
            {
                myA_AutoDrive.leftMotor.setPower(-1);
                myA_AutoDrive.rightMotor.setPower(-1);
            }
            else if(a == 1)
            {
                myA_AutoDrive.odsDriveToDistance();
                myA_AutoDrive.resQ_l.setPosition(0.55);
                myA_AutoDrive.resq_r.setPosition(0.45);
            }
            else
            {
                myA_AutoDrive.leftMotor.setPowerFloat();
                myA_AutoDrive.rightMotor.setPowerFloat();
            }

            // if(!myA_AutoDrive.leftMotor.isBusy() && !myA_AutoDrive.rightMotor.isBusy()) {
            //    myA_AutoDrive.resQ_l.setPosition(0.55);
            //   myA_AutoDrive.resq_r.setPosition(0.45);
            //}


            telemetry.addData("left encoder", myA_AutoDrive.leftMotor.getCurrentPosition());
            telemetry.addData("right encoder", myA_AutoDrive.rightMotor.getCurrentPosition());
            telemetry.addData("encoder goal", myA_AutoDrive.getTargetCounts(50));
            telemetry.addData("odsl", myA_AutoDrive.distance_l());
            telemetry.addData("odsr", myA_AutoDrive.distance_r());
            telemetry.addData("color", myA_AutoDrive.colorDetected());
            telemetry.addData("leftpower", myA_AutoDrive.leftMotor.getPower());
            telemetry.addData("rightpower", myA_AutoDrive.rightMotor.getPower());
            telemetry.addData("state", a);

            waitOneFullHardwareCycle();
        }

    }
}
