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

        while(opModeIsActive())
        {
            do
            {
                myA_AutoDrive.encoderDrive(myA_AutoDrive.getTargetCounts(50), 0.5);
                //myA_AutoDrive.odsDriveToDistance(300, 0.5);
            }
            while(0 == 1);

            switch (myA_AutoDrive.colorDetected())
            {
                case 'g':
                {
                    while (myA_AutoDrive.colorDetected() == 'g')
                    {
                        myA_AutoDrive.leftMotor.setPower(0.5);
                        myA_AutoDrive.rightMotor.setPower(0.5);
                        wait(100);
                        break;
                    }
                }
                case 'w':
                {
                    myA_AutoDrive.leftMotor.setPowerFloat();
                    myA_AutoDrive.rightMotor.setPowerFloat();
                }
                case 'r':
                {

                }
            }
            waitOneFullHardwareCycle();
        }

    }
}
