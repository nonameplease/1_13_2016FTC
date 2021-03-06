/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

/**
 * Register Op Modes
 */
public class FtcOpModeRegister implements OpModeRegister {

  /**
   * The Op Mode Manager will call this method when it wants a list of all
   * available op modes. Add your op mode to the list to enable it.
   *
   * @param manager op mode manager
   */
  public void register(OpModeManager manager) {

    /*
     * register your op modes here.
     * The first parameter is the name of the op mode
     * The second parameter is the op mode class property
     *
     * If two or more op modes are registered with the same name, the app will display an error.
     */

    //manager.register("ExampleTeleopDriveMode", ExampleTeleopDriveMode.class);
    //manager.register("ScottTele1", ScottTele1.class );
    //manager.register("ScottAuto1", ScottAuto2.class);
    //manager.register("tele_11_14_15", tele_11_14_15.class);
    //manager.register("Sensor Calibration", Color_Sensor_Calibration.class);
    //manager.register("ServoCalibration", ServoCalibration.class);
    //manager.register("tele_red", tele_red.class);
    manager.register("linear_tele_12_19_15", tele_12_19_15.class);
    manager.register("linear_tele_red_12_19_15", tele_red_12_19_15.class);
    manager.register("linear_auto_no_sensor_blue", linear_auto_no_sensor_blue.class);
    manager.register("linear_auto_no_sensor_red", linear_auto_no_sensor_red.class);
    manager.register("Color_sensor_test", color_sensor_test.class);
    //manager.register("Optical_distance_sensor_test", optical_distance_sensor_test.class);
    //manager.register("sensorauto_v3 ", sensorauto_v3.class);
    manager.register("dualodstest", dual_ods_test.class);
    //manager.register("followlinetest", followlinetest.class);
    //manager.register("sensorauto_v4", sensorauto_v4.class);
    //manager.register("encoder_test", Encoder_test.class);
    manager.register("encoder_test_2", encoder_test_2.class);
    //manager.register("sensorauto v5", sensorauto_v5.class);
    //manager.register("sensorauto v6", sensorauto_v6.class);
   // manager.register("encoder_test_3", encoder_test_3.class);
   // manager.register("encoder_test_4", encoder_test_4.class);
      manager.register("endcoderauto_turnleft", encoder_auto_turnleft.class);
    manager.register("encoderauto_turnright", encoder_auto_turnright.class);
    //manager.register("sensorauto_v7", sensorauto_v7.class);
    manager.register("endoer_test_5", encoder_test_5.class);
    manager.register("A_tele", A_Tele.class);
    manager.register("A_auto", A_Auto.class);
    manager.register("A_auto_2", A_Auto_2.class);
    manager.register("auto1", auto1.class);
    manager.register("A_auto_3", A_Auto_3.class);


    /*
     * Uncomment any of the following lines if you want to register an op mode.
     */

    //manager.register("AdafruitRGBExample", AdafruitRGBExample.class);
    //manager.register("MRRGBExample", MRRGBExample.class);
    //manager.register("ColorSensorDriver", ColorSensorDriver.class);
    //manager.register("HTRGBExample", HTRGBExample.class);

    //manager.register("IrSeekerOp", IrSeekerOp.class);
    //manager.register("CompassCalibration", CompassCalibration.class);
    //manager.register("I2cAddressChangeExample", LinearI2cAddressChange.class);


    //manager.register("NxtTeleOp", NxtTeleOp.class);
    
    //manager.register("LinearK9TeleOp", LinearK9TeleOp.class);
    //manager.register("LinearIrExample", LinearIrExample.class);

    
    //manager.register ("PushBotManual1", PushBotManual1.class);
    //manager.register ("PushBotAutoSensors", PushBotAutoSensors.class);
    //manager.register ("PushBotIrEvent", PushBotIrEvent.class);
    
    //manager.register ("PushBotManualSensors", PushBotManualSensors.class);
    //manager.register ("PushBotOdsDetectEvent", PushBotOdsDetectEvent.class);
    //manager.register ("PushBotOdsFollowEvent", PushBotOdsFollowEvent.class);
    //manager.register ("PushBotTouchEvent", PushBotTouchEvent.class);    
    
    //manager.register("PushBotDriveTouch", PushBotDriveTouch.class);
    //manager.register("PushBotIrSeek", PushBotIrSeek.class);
    //manager.register("PushBotSquare", PushBotSquare.class);

    
    
  }
}
