package frc.robot.commands.driveCommands;


import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

public class RomiDriveDefault extends Command{
    private final RomiDrivetrain drivetrain = RomiDrivetrain.getinstance();
    double xAxisSpeed = 0;
    double yAxisSpeed = 0;
    Gamepad contorller;
    public RomiDriveDefault(Gamepad controller) {
        this.contorller = controller;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("DriveDefault/ X Axis Speed", xAxisSpeed);
        SmartDashboard.putNumber("DriveDefault/ y Axis Speed", yAxisSpeed);
        SmartDashboard.putNumber("DriveDefault/ left controller y", contorller.getLeftY());
        SmartDashboard.putNumber("DriveDefault/ right controller x", contorller.getRightX());
        drivetrain.arcadeDrive(-contorller.getLeftY(), -contorller.getRightX());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
