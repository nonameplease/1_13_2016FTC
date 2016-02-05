package com.qualcomm.ftcrobotcontroller.opmodes;

import android.bluetooth.BluetoothClass;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Scott on 1/31/2016.
 */
public class A_AutoDrive extends A_RobotDrive {

    DeviceInterfaceModule dim;
    ColorSensor color;
    AnalogInput ods_l;
    AnalogInput ods_r;

    /*change the value if necessary LOL
    final static int ENCODER_CPR = 1120;
    final static int GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 36; //in inches

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
    final static int COUNTSINT = (int) COUNTS * -1;
    */

    public A_AutoDrive(DcMotor left, DcMotor right, DcMotor leftrotate, DcMotor rightrotate,
                       DcMotor Climber, Servo ResQl, Servo ResQr, DeviceInterfaceModule Dim,
                       ColorSensor Color, AnalogInput ODSL, AnalogInput ODSR) {
        super(left, right, leftrotate, rightrotate, Climber, ResQl, ResQr);
        dim = Dim;
        color = Color;
        ods_l = ODSL;
        ods_r = ODSR;
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    public int getTargetCounts(int inches)
    {
        final int ENCODER_CPR = 1120;
        final int GEAR_RATIO = 1;
        final int WHEEL_DIAMETER = 4;
        final int DISTANCE = inches; //in inches

        final double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        final double ROTATIONS = DISTANCE / CIRCUMFERENCE;
        final double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
        final int COUNTSINT = (int) COUNTS;
        return COUNTSINT;
    }

    public void encoderDrive(int COUNTSINT, double power)
    {
        leftMotor.setTargetPosition(COUNTSINT);
        rightMotor.setTargetPosition(-COUNTSINT);
        leftMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    public double colorRed()
    {
        int Red = color.red();
        return Red;
    }
    public double colorBlue()
    {
        int Blue = color.blue();
        return Blue;
    }
    public double colorGreen()
    {
        int Green = color.green();
        return Green;
    }

    public String colorDetected()
    {
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
        String Color = "no color";
        if(colorRed() < 450 && colorBlue() < 400 && colorGreen() < 400)
        {
            Color = "grey";
        }

        if(colorRed() > 500 && colorBlue() > 500 && colorGreen() > 500)
        {
            Color = "white";
        }

        if(colorRed() > 500 && colorBlue() < 300 && colorGreen() < 300)
        {
            Color = "red";
        }

        return Color;
    }

    public double distance_l()
    {
        double distance_l = ods_l.getValue();
        return distance_l;
    }
    public double distance_r()
    {
        double distance_r = ods_r.getValue();
        return distance_r;
    }

    public void odsDriveToDistance(int distance, double power)
    {
        if (distance_l() < distance)
        {
            leftMotor.setPower(-power);
            //rightMotor.setPower(0.5);
            //leftMotorRear.setPower(-0.5);
            // rightMotorRear.setPower(0.5);
        }
        else
        {
            leftMotor.setPowerFloat();
            // rightMotor.setPowerFloat();
            //leftMotorRear.setPowerFloat();
            // rightMotorRear.setPowerFloat();
        }

        if (distance_r() < distance)
        {
            rightMotor.setPower(-power);
            //rightMotorRear.setPower(-0.5);
        }
        else
        {
            //rightMotorRear.setPowerFloat();
            rightMotor.setPowerFloat();
        }
    }



}
