package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by owner on 10/4/2015.
 */
public class tele_12_19_15 extends LinearOpMode {



    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftMotorRotate;
    DcMotor rightMotorRotate;


    final double UP_POSITION = 0.0;
    final double DOWN_POSITION = 0.8;

    final double CLOSE_POSITION = 1;
    final double RESQ_POSITION = 0.3;
    final double Buffer1 = 0.9;
    final double Buffer2 = 0.8;
    final double Buffer3 = 0.7;
    final double Buffer4 = 0.6;
    final double Buffer5 = 0.5;

    Servo resQ_l;
    Servo resQ_r;



    @Override
    public void runOpMode() throws InterruptedException {


        /* get reference to the motors from hardware map */
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotorRotate = hardwareMap.dcMotor.get("left_drive_rotate");
        rightMotorRotate = hardwareMap.dcMotor.get("right_drive_rotate");

        /* reverse the right motor */
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotorRotate.setDirection(DcMotor.Direction.REVERSE);

        resQ_l = hardwareMap.servo.get("resQ_l");
        resQ_r = hardwareMap.servo.get("resQ_r");
        resQ_l.setPosition(CLOSE_POSITION);
        resQ_r.setPosition(255 - CLOSE_POSITION);



        waitForStart();

        while(opModeIsActive()) {



        /*
        get value from gamepad
        caution that gamepad's value is reversed so all value should muptiply by -1
        */
            float leftY = -gamepad1.left_stick_y;
            float rightY = -gamepad1.right_stick_y;


        /* set the power of motors with the gamepad values */
            leftMotor.setPower(leftY);
            rightMotor.setPower(rightY);

        /*
        rotate drive
         */
            double valueFeedFromLT = gamepad1.left_trigger;
            double valueFeedFromRT = gamepad1.right_trigger;

            if (gamepad1.left_bumper) {
                leftMotorRotate.setPower(-1);
            } else if (valueFeedFromLT > 0.5) {
                leftMotorRotate.setPower(1);
            } else {
                leftMotorRotate.setPowerFloat();
            }

            if (gamepad1.right_bumper) {
                rightMotorRotate.setPower(-1);
            } else if (valueFeedFromRT > 0.5) {
                rightMotorRotate.setPower(1);
            } else {
                rightMotorRotate.setPowerFloat();
            }


            if (gamepad2.left_bumper) {
                resQ_l.setPosition(CLOSE_POSITION);
                resQ_r.setPosition(CLOSE_POSITION);
            }

            if (gamepad2.right_bumper) {
                resQ_l.setPosition(Buffer1);
                resQ_r.setPosition(Buffer1);
                sleep(200);
                resQ_l.setPosition(Buffer2);
                resQ_r.setPosition(Buffer2);
                sleep(200);
                resQ_l.setPosition(Buffer3);
                resQ_r.setPosition(Buffer3);
                sleep(200);
                resQ_l.setPosition(Buffer4);
                resQ_r.setPosition(Buffer4);
                sleep(200);
                resQ_l.setPosition(Buffer5);
                resQ_r.setPosition(Buffer5);
                sleep(200);
                resQ_l.setPosition(RESQ_POSITION);
                resQ_r.setPosition(RESQ_POSITION);
            }

            if(-gamepad2.left_stick_y > 0.5)
            {
                resQ_l.setDirection(Servo.Direction.FORWARD);
            }
            else if(-gamepad2.left_stick_y < -0.5)
            {
                resQ_l.setDirection(Servo.Direction.REVERSE);
            }

            if(-gamepad2.right_stick_y > 0.5)
            {
                resQ_r.setDirection(Servo.Direction.FORWARD);
            }
            else if(-gamepad2.right_stick_y < -0.5)
            {
                resQ_r.setDirection(Servo.Direction.REVERSE);
            }





            telemetry.addData("left motor power", leftMotor.getPower());
            telemetry.addData("right motor power", rightMotor.getPower());
            telemetry.addData("resQ position", resQ_r.getPosition());

            waitOneFullHardwareCycle();

        }

    }
}
