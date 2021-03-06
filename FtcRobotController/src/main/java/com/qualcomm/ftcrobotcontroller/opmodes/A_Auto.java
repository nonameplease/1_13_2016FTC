package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Scott on 2/4/2016.
 */
public class A_Auto extends LinearOpMode {

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

        while(opModeIsActive()) {
           // myA_AutoDrive.encoderDriveUsingPosition(myA_AutoDrive.getTargetCounts(120), 0.2);
            myA_AutoDrive.leftMotor.setPower(1);
            myA_AutoDrive.rightMotor.setPower(1);
            wait(500);
            myA_AutoDrive.leftMotor.setPowerFloat();
            myA_AutoDrive.rightMotor.setPowerFloat();


           /* do
            {
                myA_AutoDrive.encoderDriveUsingPosition(myA_AutoDrive.getTargetCounts(-50), -0.3);
                //myA_AutoDrive.odsDriveToDistance(300, 0.5);
            }
            while(0 == 1);

            while(myA_AutoDrive.colorDetected() == 'g')
            {
                myA_AutoDrive.leftMotor.setPower(0.5);
                myA_AutoDrive.rightMotor.setPower(0.5);
            }*/

            //myA_AutoDrive.odsDriveToDistance(300, 0.3);
            // myA_AutoDrive.encoderDrive(50, 1.0);


            telemetry.addData("encoder left", myA_AutoDrive.leftMotor.getCurrentPosition());
            telemetry.addData("encoder right", myA_AutoDrive.rightMotor.getCurrentPosition());
            telemetry.addData("current color", myA_AutoDrive.colorDetected());

        }

    }
}
