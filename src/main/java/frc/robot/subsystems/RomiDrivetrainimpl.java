// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.driveCommands.RomiDriveDefault;
import frc.robot.constants.Constants;
import frc.robot.constants.gains;
import frc.robot.constants.ports;
import frc.robot.constants.gains.turnToDegreePID;


public class RomiDrivetrainimpl extends RomiDrivetrain { // 70 mm

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  
  private Spark leftMotor = new Spark(ports.Ports.LEFT_MOTOR_CHANNEL);
  private Spark rightMotor = new Spark(ports.Ports.RIGHT_MOTOR_CHANNEL);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private Encoder leftEncoder;
  private Encoder rightEncoder;

  private RomiGyro gyro;
  private BuiltInAccelerometer accelerometer;
  private DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  // private ProfiledPIDController turnToDegrees = new PIDController(gains.turnToDegreePID.kp, gains.turnToDegreePID.kki, gains.turnToDegreePID.kd, new TrapezoidProfile(0,0 =c =));
  // // Set up the differential drive controller

  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrainimpl() {

    leftEncoder = new Encoder(ports.Ports.LEFT_ENCODER_CHANNELA, ports.Ports.LEFT_ENCODER_CHANNELB);
    rightEncoder = new Encoder(ports.Ports.RIGHT_ENCODER_CHANNELA, ports.Ports.RIGHT_ENCODER_CHANNELB);

    gyro = new RomiGyro();
    accelerometer = new BuiltInAccelerometer();
    // Use inches as unit for encoder distances
    leftEncoder.setDistancePerPulse((Math.PI * Constants.RomiDrivetrainConstants.kWheelDiameterInch) / Constants.RomiDrivetrainConstants.kCountsPerRevolution);
    rightEncoder.setDistancePerPulse((Math.PI * Constants.RomiDrivetrainConstants.kWheelDiameterInch) / Constants.RomiDrivetrainConstants.kCountsPerRevolution);
    resetEncoders();

    // Invert right side since motor is flipped
    rightMotor.setInverted(true);

  }
  
  @Override
  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    drive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  @Override
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  
  
  }

  @Override
  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  @Override
  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }

  @Override
  public double getGyroX() {
    return gyro.getAngleX();
  }

  @Override
  public double getGyroY() {
    return gyro.getAngleY();
  }

  @Override
  public double getGyroZ() {
    return gyro.getAngleZ();
  }

  // public void turnToDegree(Rotation2d target) {
  //   leftMotor.setVoltage(turnToDegreePID(target.getDegrees()));
  //   rightMotor.setVoltage();
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drivetrain/ left motor voltage", leftMotor.getVoltage());
    SmartDashboard.putNumber("Drivetrain/ right motor voltage", rightMotor.getVoltage());
    
  }

  @Override
  public void simulationPeriodic() {}

}

